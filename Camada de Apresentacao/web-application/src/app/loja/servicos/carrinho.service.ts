
import { Subject, Observable } from 'rxjs';
import { Injectable, OnInit } from '@angular/core';

const CACHE = 'ITENS';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService implements OnInit {



  private subject = new Subject<any>();
  private itens: ItemCarrinhoModel[] = [];

  constructor() { }

  ngOnInit(): void {

    console.log( this.itens );
  }

  getItens() {
    return this.itens;
  }

  adicionarItem(item: ItemCarrinhoModel ) {
    this.itens.push(item);
    // localStorage.removeItem(CACHE);
    // localStorage.setItem(CACHE, JSON.stringify( this.itens ) );
    this.subject.next( { produto: item } );
  }

  quantidadeItens() {
    // this.itens = JSON.parse( localStorage.getItem(CACHE) );
    return this.itens.length;
  }

  valorItens() {
    // this.itens = JSON.parse( localStorage.getItem(CACHE) );
    // console.log(this.itens);
    let total = 0;
    for ( const i of this.itens ) {
      total += ( i.quantidade * i.valorUnitario );
    }
    return total;
  }

  limpar() {
    this.itens = [];
    this.subject.next();
  }

  getCarrinho(): Observable<any> {
    return this.subject.asObservable();
  }

}
