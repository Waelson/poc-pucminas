import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of, pipe } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { URL_AUTENTICACAO,
        BASIC_AUTHORIZATION,
        GRANT_TYPE_AUTHORIZATION,
        URL_CONTROLE_VENDAS } from '../util/end-points.util';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {



  constructor(private httpClient: HttpClient) { }


  /**
   * Recupera os dados dos usuario por email.
   * @param email Email do usuario
   * @param token Token de autenticacao do usuario
   */
  buscarPorEmail(email: string, token: string): Observable<any> {
    return this.httpClient.get(
      `${URL_CONTROLE_VENDAS}/usuarios/search/findByEmail/${email}?access_token=${token}`);
  }

  validarPorEmail(email: string, senha: string): Observable<any> {
    const headersObject = new HttpHeaders().
      set('Content-Type', 'application/x-www-form-urlencoded').
      set('Authorization', BASIC_AUTHORIZATION);

    const body = new HttpParams()
      .set('username', email)
      .set('password', senha)
      .set('grant_type', GRANT_TYPE_AUTHORIZATION);

    return this.httpClient.post(
      `${URL_AUTENTICACAO}/oauth/token`,
      body.toString(), {headers: headersObject});
  }
}
