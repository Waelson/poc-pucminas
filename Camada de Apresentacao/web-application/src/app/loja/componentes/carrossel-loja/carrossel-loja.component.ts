import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-carrossel-loja',
  templateUrl: './carrossel-loja.component.html',
  styleUrls: ['./carrossel-loja.component.css']
})
export class CarrosselLojaComponent implements OnInit {

  produtos: ProdutoCarrosselModel[] = [
    {
      nome: 'Cama de Casal Celia',
      descricao: 'Largura: 1,30 - 1,40 CM Comprimento: 1,90 M Altura da cabeceira: 0,95 CM - 5x8 CM.',
      imagem: 'assets/images/imagem1.png'
    },
    {
      nome: 'Cama de Solteiro Laura',
      descricao: 'Largura: 0,80 - 0,90 CM Comprimento: 1,90 M Altura da cabeceira: 0,95 CM - 8x8 CM.',
      imagem: 'assets/images/imagem2.png'
    },
    {
      nome: 'Cama de Casal Liane',
      descricao: 'Largura: 1,30 - 1,40 CM Comprimento: 1,90 M Altura da cabeceira: 0,95 CM - 5x8 CM.',
      imagem: 'assets/images/imagem3.png'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}
