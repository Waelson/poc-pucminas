import { UsuarioLogadoService } from './../../../sharing/usuario-logado.service';
import { NotifierService } from 'angular-notifier';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-admin',
  templateUrl: './header-admin.component.html',
  styleUrls: ['./header-admin.component.css']
})
export class HeaderAdminComponent implements OnInit {

  nomeUsuario: string;

  constructor(private notifier: NotifierService,
    private usuarioLogadoService: UsuarioLogadoService,
    private router: Router) { }

  ngOnInit() {
    if ( this.usuarioLogadoService.usuarioEstaLogado() ) {
      const usuario = this.usuarioLogadoService.getUsuarioLogado();
      // console.log(usuario);
      this.nomeUsuario = usuario.nome;
    } else {
      this.nomeUsuario = undefined;
    }
  }

  onClickMenu() {
    this.notifier.notify('warning', 'Funcionalidade não implementada.');
  }

  logoff() {
    this.usuarioLogadoService.logoff();
    this.router.navigate(['/administrativo/login']);

  }

}
