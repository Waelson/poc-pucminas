import { CarrinhoService } from './../../servicos/carrinho.service';
import { Component, OnInit, Input } from '@angular/core';
import { NotifierService } from 'angular-notifier';

@Component({
  selector: 'app-produto-destaque',
  templateUrl: './produto-destaque.component.html',
  styleUrls: ['./produto-destaque.component.css']
})
export class ProdutoDestaqueComponent implements OnInit {

  @Input() produto: ProdutoDestaqueModel;

  constructor(private carrinhoServico: CarrinhoService,
    private notifier: NotifierService ) { }

  ngOnInit() {

  }

  onComprar() {
    // console.log( this.produto );
    if ( this.produto !== undefined ) {
      this.carrinhoServico.adicionarItem(
        { idProduto: this.produto.codigo, urlImagem: this.produto.imagem,
          nome: this.produto.nome, quantidade: 1, valorUnitario: this.produto.valorUnitario }
      );
      this.notifier.notify('success', 'Você adicionou o item \"' + this.produto.nome.toLocaleUpperCase() + '\" em seu carrinho.');
    }
  }

  onDetalhe() {
    this.notifier.notify('info', 'Funcionalidade não implementada.');
  }

}
