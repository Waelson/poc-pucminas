import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {



  private departamentos: DepartamentoModel[] = [
    { idDepartamento: 1, nome: 'Cama', nomeLink: 'cama', icone: 'fa fa-bed' },
    { idDepartamento: 2, nome: 'Mesa', nomeLink: 'mesa', icone: 'fa fa-table' },
    { idDepartamento: 3, nome: 'Banho', nomeLink: 'banho', icone: 'fa fa-shower' },
    { idDepartamento: 4, nome: 'Eletro', nomeLink: 'eletrodomesticos', icone: 'fa fa-tv' }
  ];

  constructor(private httpClient: HttpClient) { }


  listart(): Observable<DepartamentoModel[]> {
    return of(this.departamentos);
  }


  listar() {
    const url = '/api/controle-vendas/departamentos/';
   return this.httpClient.get(url);
  }


  obterPorId(idDepartamento: number): Observable<DepartamentoModel> {

    for (const tmp of this.departamentos) {
      if (tmp.idDepartamento === idDepartamento) {
        return of(tmp);
      }
    }
    return of(null);
  }
}
