import { Observable } from 'rxjs';
import { NotifierService } from 'angular-notifier';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { UsuarioLogadoService } from './../../sharing/usuario-logado.service';
import { Injectable } from '@angular/core';

@Injectable()
export class GuardRouterAdmin {

    constructor(
        private usuarioLogadoService: UsuarioLogadoService ,
        private router: Router,
        private notifier: NotifierService) {}

    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        // console.log('Guardador de rotas.');
        if (this.usuarioLogadoService.getUsuarioLogado() !== undefined &&
            this.usuarioLogadoService.getUsuarioLogado() !== null &&
            (this.usuarioLogadoService.isVendedor() || this.usuarioLogadoService.isAdministrador())) {
            return true;
        }
        this.router.navigate(['/administrativo/acesso-negado']);
        return false;
    }
}
