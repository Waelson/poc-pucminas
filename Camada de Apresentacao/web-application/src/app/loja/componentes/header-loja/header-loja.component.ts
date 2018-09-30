import { NgxSpinnerService } from 'ngx-spinner';
import { Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { UsuarioLogadoService } from '../../../sharing/usuario-logado.service';
import { CarrinhoService } from './../../servicos/carrinho.service';
import { DepartamentoService } from './../../servicos/departamento.service';
import { Component, OnInit } from '@angular/core';
import { Subscription, Subject } from 'rxjs';



@Component({
  selector: 'app-header-loja',
  templateUrl: './header-loja.component.html',
  styleUrls: ['./header-loja.component.css']
})
export class HeaderLojaComponent implements OnInit {

  totalItens = 0;
  valorItens = 0;
  tooltipCarrinho = 'Seu carrinho está vázio.';
  subscription: Subscription;
  departamentos: DepartamentoModel[] = [];
  usuarioLogado: any;

  constructor(
    private departamentoServico: DepartamentoService,
    private carrinho: CarrinhoService,
    private usuarioLogadoService: UsuarioLogadoService,
    private notifierService: NotifierService,
    private router: Router,
    private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.totalItens = this.carrinho.quantidadeItens();
    this.valorItens = this.carrinho.valorItens();
    this.spinner.show();

    if ( this.usuarioLogadoService.usuarioEstaLogado() ) {
      const usuario = this.usuarioLogadoService.getUsuarioLogado();
      if ( usuario !== undefined ) {
        this.usuarioLogado = usuario.nome;
      } else {
        this.usuarioLogado = undefined;
      }

    } else {
      this.usuarioLogado = undefined;
    }

    this.departamentoServico.listar().subscribe( (dados: DepartamentoModel[]) => {
      this.departamentos = dados;
      this.spinner.hide();
    });

    this.usuarioLogadoService.getUsuarioStorage().subscribe( function( mensagem ) {
      if ( mensagem !== undefined ) {
        this.usuarioLogado = mensagem.nome;
      } else {
        this.usuarioLogado = undefined;
      }
    }.bind(this));

    this.subscription = this.carrinho.getCarrinho().subscribe( function( mensagem ) {
      this.totalItens = this.carrinho.quantidadeItens();
      this.valorItens = this.carrinho.valorItens();
      if (this.totalItens === 1) {
        this.tooltipCarrinho = 'Seu carrinho tem ' + this.totalItens + ' item.';
      } else if (this.totalItens > 1) {
        this.tooltipCarrinho = 'Seu carrinho tem ' + this.totalItens + ' itens.';
      } else {
        this.tooltipCarrinho = 'Seu carrinho está vázio.';
      }
    }.bind(this));
  }

  getUsuarioLogado() {
    return this.usuarioLogado;
  }

  temUsuarioLogado() {
    return this.usuarioLogadoService.usuarioEstaLogado();
  }

  logoff() {
    this.usuarioLogadoService.logoff();
    if ( this.router.url.includes( '/area-do-cliente' ) ) {
      this.router.navigate(['/loja/home']);
    }
    this.notifierService.notify('info', 'Sua sessão foi encerrada!');
  }

}
