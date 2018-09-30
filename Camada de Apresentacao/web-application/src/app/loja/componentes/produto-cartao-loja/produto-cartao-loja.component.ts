import { NotifierService } from 'angular-notifier';
import { CarrinhoService } from './../../servicos/carrinho.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-produto-cartao-loja',
  templateUrl: './produto-cartao-loja.component.html',
  styleUrls: ['./produto-cartao-loja.component.css']
})
export class ProdutoCartaoLojaComponent implements OnInit {

  @Input() produto: any;

  constructor(
    private carrinhoService: CarrinhoService,
    private notifierService: NotifierService) { }

  ngOnInit() {
  }

  onComprar() {
    this.carrinhoService.adicionarItem(
      {
        nome: this.produto.nome,
        urlImagem: this.produto.imagem,
        idProduto: this.produto.idProduto,
        quantidade: 1,
        valorUnitario: this.produto.vlrUnitario
      }
    );
    this.notifierService.notify('success', 'Você adicionou o item \"' + this.produto.nome + '\" em seu carrinho.');
  }

}
