import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { URL_PRODUTOS } from '../util/end-points.util';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private httpCliente: HttpClient) { }

  buscarPorIdCategoria( idCategoria: number ): Observable<any> {
    return this.httpCliente.get(
      `${URL_PRODUTOS}/categoria/${idCategoria}`
    );
  }

}
