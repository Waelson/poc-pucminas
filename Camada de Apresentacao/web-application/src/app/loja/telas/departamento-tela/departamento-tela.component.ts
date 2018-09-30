import { PedidoService } from './../../servicos/pedido.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ProdutoService } from './../../servicos/produto.service';
import { DepartamentoService } from './../../servicos/departamento.service';
import { CategoriaService } from './../../servicos/categoria.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-departamento-tela',
  templateUrl: './departamento-tela.component.html',
  styleUrls: ['./departamento-tela.component.css']
})
export class DepartamentoTelaComponent implements OnInit {

  categorias: CategoriaModel[] = [];
  produtos: ProdutoModel[] = [];
  departamento: DepartamentoModel;

  constructor(
    private categoriaService: CategoriaService,
    private activatedRoute: ActivatedRoute,
    private departamentoService: DepartamentoService,
    private produtoService: ProdutoService,
    private spinner: NgxSpinnerService,
    private notifier: NotifierService) {}

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe( params => this.carregarCategoriasAndDepartamento() );
    this.activatedRoute.queryParams.subscribe( params => this.carregarProdutos(params['idCategoria']) );
  }

  carregarCategoriasAndDepartamento() {
    const strIdDepartamento: string = this.activatedRoute.snapshot.paramMap.get('idDepartamento');
    const idDepartamento: number = parseInt(strIdDepartamento, 10);
    this.categoriaService.buscarPorIdDepartamento( idDepartamento ).subscribe( dados => this.categorias = dados );
    this.departamentoService.obterPorId( idDepartamento ).subscribe( dado => this.departamento = dado );
    this.produtos = [];
  }

  carregarProdutos(strIdCategoria: string) {
    if (strIdCategoria !== undefined) {
      this.spinner.show();
      const idDepartamento: number = parseInt(strIdCategoria, 10);
      this.produtoService.buscarPorIdCategoria(idDepartamento).subscribe(
        dados => {
          this.spinner.hide();
          this.produtos = dados;
        },
        error => {
          this.spinner.hide();
          // tslint:disable-next-line:max-line-length
          this.notifier.notify('error', 'O sistema está passando por uma instabilidade. Por favor, aguarde alguns instantes e tente novamente.');
        });
    }
  }

  queryParamCategoria(idCategoria) {
    return {idCategoria: idCategoria};
  }

  temProdutos() {
    if (this.produtos === undefined || this.produtos.length === 0) {
      return false;
    }
    return true;
  }

}
