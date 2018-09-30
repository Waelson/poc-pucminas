import { CarrinhoService } from './../../servicos/carrinho.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-marketing-loja',
  templateUrl: './marketing-loja.component.html',
  styleUrls: ['./marketing-loja.component.css']
})
export class MarketingLojaComponent implements OnInit {

  produtos: ProdutoDestaqueModel[] =  [
    {
      codigo: 1,
      nome: 'Mesa Ovni',
      nomeLink: 'mesa-ovni',
      descricao: `A mesa Ovni é uma ótima solução para bares,
                  cozinhas ou salas de jantar compactas e pode acomodar
                  até 3 pessoas.`,
      departamento: 'mesa',
      imagem: 'assets/images/c_imagem1.png', valorUnitario: 100.00 },
      {
        codigo: 2,
        nome: 'Mesa Suny',
        nomeLink: 'mesa-suny',
        descricao: `A mesa Ovni é uma ótima solução para bares,
                    cozinhas ou salas de jantar compactas e pode acomodar
                    até 3 pessoas.`,
        departamento: 'mesa',
        imagem: 'assets/images/c_imagem2.png', valorUnitario: 200.00 },
      {
          codigo: 3,
          nome: 'Mesa Karine',
          nomeLink: 'mesa-karine',
          descricao: `A mesa Ovni é uma ótima solução para bares,
                      cozinhas ou salas de jantar compactas e pode acomodar
                      até 3 pessoas.`,
          departamento: 'mesa',
          imagem: 'assets/images/c_imagem3.png', valorUnitario: 300.00 }
  ];

  constructor() { }

  ngOnInit() {
  }


}
