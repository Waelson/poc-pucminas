import { UsuarioLogadoService } from './../../sharing/usuario-logado.service';
import { URL_PEDIDOS } from './../util/end-points.util';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
  })
export class PedidoService {

    constructor(private httpCliente: HttpClient,
        private usuarioLogadoService: UsuarioLogadoService) {}


    salva(pedido: any, accessToken: string): Observable<any> {
        const url = `${URL_PEDIDOS}/`;
        const accessTokenHeader = `Bearer ${accessToken}`;

        const headersObject = new HttpHeaders()
            .set('Authorization', accessTokenHeader);

        return this.httpCliente.post(url, pedido, {headers: headersObject});
    }
}
