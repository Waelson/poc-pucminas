import { NgxSpinnerService } from 'ngx-spinner';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { UsuarioLogadoService } from './usuario-logado.service';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {

    constructor(private spinner: NgxSpinnerService,
        private usuarioLogadoService: UsuarioLogadoService) {}

    intercept( request: HttpRequest<any>, next: HttpHandler ): Observable<HttpEvent<any>> {
        if ( this.usuarioLogadoService.usuarioEstaLogado() ) {
            const cloneRequest = request.clone(
                // { headers: request.headers.set('Authorization', 'Bearer ' + this.usuarioLogadoService.getUsuarioLogado().accessToken) }
            );
            return next.handle(cloneRequest);
        } else {
            return next.handle(request);
        }

    }

}
