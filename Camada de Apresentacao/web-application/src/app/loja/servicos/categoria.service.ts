import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { URL_CATEGORIAS } from '../util/end-points.util';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private httpCliente: HttpClient) { }

  buscarPorIdDepartamento(idDepartamento: number): Observable<any> {
    return this.httpCliente.get(
      `${URL_CATEGORIAS}/departamento/${idDepartamento}`
    );
  }

}
