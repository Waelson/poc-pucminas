import { NotifierService } from 'angular-notifier';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, Route } from '@angular/router';
import { Observable } from 'rxjs';
import { UsuarioLogadoService } from '../../sharing/usuario-logado.service';

@Injectable()
export class AuthorationGuard implements CanActivate {
    constructor( private usuarioLogadoService: UsuarioLogadoService,
        private router: Router, private notifier: NotifierService ) {}

    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        if (this.usuarioLogadoService.getUsuarioLogado() !== undefined &&
            this.usuarioLogadoService.getUsuarioLogado() !== null &&
            this.usuarioLogadoService.isCliente() ) {
            return true;
        }
        this.router.navigate(['/loja/acesso-negado']);
        return false;
    }
}
