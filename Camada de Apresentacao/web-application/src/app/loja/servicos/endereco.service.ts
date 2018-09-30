import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL_ENDERECOS } from './../util/end-points.util';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class EnderecoService {

    constructor(private httpCliente: HttpClient) {}

    buscarPorIdCliente(idCliente: number, accessToken: string): Observable<any> {
        const url = `${URL_ENDERECOS}/cliente/${idCliente}?access_token=${accessToken}`;
        return this.httpCliente.get(url);
    }

}
