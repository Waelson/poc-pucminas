import { Router } from '@angular/router';
import { PedidoService } from './../../servicos/pedido.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { EnderecoService } from './../../servicos/endereco.service';
import { UsuarioLogadoService } from '../../../sharing/usuario-logado.service';
import { NotifierService } from 'angular-notifier';
import { CarrinhoService } from './../../servicos/carrinho.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carrinho-tela',
  templateUrl: './carrinho-tela.component.html',
  styleUrls: ['./carrinho-tela.component.css']
})
export class CarrinhoTelaComponent implements OnInit {

  itensCarrinho: ItemCarrinhoModel[] = [];
  enderecos: any = [];
  protocolo = undefined;

  constructor(
    private carrinhoService: CarrinhoService,
    private notifier: NotifierService,
    private usuarioLogadoService: UsuarioLogadoService,
    private enderecoService: EnderecoService,
    private spinner: NgxSpinnerService,
    private pedidoService: PedidoService,
    private router: Router) { }

  ngOnInit() {
    this.itensCarrinho = this.carrinhoService.getItens();
    this.protocolo = undefined;

    if ( this.usuarioLogadoService.usuarioEstaLogado() ) {
      this.spinner.show();
      const usuarioLogado = this.usuarioLogadoService.getUsuarioLogado();
      this.enderecoService.buscarPorIdCliente(
        usuarioLogado.idCliente,
        usuarioLogado.accessToken).subscribe( dados => {
          this.enderecos = dados;
          this.spinner.hide();
        },
        (err) => {
          this.spinner.hide();
          if ( err.status === 401 ) {
            this.router.navigate(['/loja/login-cliente']);
            this.notifier.notify('info', 'Sua sessão expirou. Efetue o login novamente.');
          } else {
            this.notifier.notify('error', 'Ocorreu um erro ao recuperar o endereço do cliente. Tente novamente.');
          }
        });
    }
  }

  montarListaItensPedido() {
    const lista = [];
    for (const item of this.itensCarrinho) {
      const itemPedido = {
        idItemPedido: null,
        pedido: {
          idPedido: null,
        },
        produto: {
          idProduto: item.idProduto
        },
        vlrUnitario: item.valorUnitario,
        quantidade: item.quantidade,
        vlrTotal: item.valorUnitario * item.quantidade
      };
      lista.push(itemPedido);
    }
    return lista;
  }

  onConfirmarCompra() {
    this.spinner.show();

    const usuarioLogado = this.usuarioLogadoService.getUsuarioLogado();
    const itensPedidos = this.montarListaItensPedido();
    const pedido = {
      cliente: {
        idCliente: usuarioLogado.idCliente
      },
      endereco: {
        idEndereco: this.enderecos[0].idEndereco
      },
      formaPagamento: {
        codFormaPagamento: 2
      },
      situacaoPedido: {
        codSituacaoPedido: null
      },
      dataHoraCriacao: null,
      vlrTotal: this.valorItens(),
      itensPedido: itensPedidos
    };

    const accessToken = this.usuarioLogadoService.getUsuarioLogado().accessToken;
    this.pedidoService.salva(pedido, accessToken).subscribe(
      (data) => {
        this.enderecos = [];
        this.itensCarrinho = [];
        this.protocolo = data.protocolo;
        this.carrinhoService.limpar();
        this.spinner.hide();
      },
      (err) => {
        this.spinner.hide();
        if (err.status === 401 ) {
          this.router.navigate(['/loja/login-cliente']);
          this.notifier.notify('info', 'Sua sessão expirou. Efetue o login novamente.');
        } else {
          this.notifier.notify('error', 'Ocorreu um erro ao confirmar o pedido.');
        }
      }
    );

  }

  quantidadeItensCarrinho(): number {
    return this.carrinhoService.quantidadeItens();
  }

  carrinhoEstaVazio() {
    const resultado = this.carrinhoService.quantidadeItens() === 0;
    return resultado;
  }

  onExcluirItem(idProduto: number) {
    console.log(idProduto);
  }

  valorItens() {
    return this.carrinhoService.valorItens();
  }

  onLimparCarrinho() {
    this.carrinhoService.limpar();
    this.notifier.notify('info', 'Seu carrinho foi esvaziado.');
  }

  usuarioEstaLogado() {
    return this.usuarioLogadoService.usuarioEstaLogado() && this.usuarioLogadoService.isCliente();
  }



}
