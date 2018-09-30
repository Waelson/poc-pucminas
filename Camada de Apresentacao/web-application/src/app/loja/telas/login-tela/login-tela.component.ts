import { NgxSpinnerService } from 'ngx-spinner';
import { NotifierService } from 'angular-notifier';
import { UsuarioLogadoService } from '../../../sharing/usuario-logado.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioService } from '../../servicos/usuario.service';
import { Router } from '@angular/router';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-login-tela',
  templateUrl: './login-tela.component.html',
  styleUrls: ['./login-tela.component.css']
})
export class LoginTelaComponent implements OnInit {

  formLogin: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,
    private usuarioLogadoService: UsuarioLogadoService,
    private notifier: NotifierService,
    private router: Router,
    private spinner: NgxSpinnerService) { }

  ngOnInit() {
    this.criarFormulario();
  }

  criarFormulario() {
    this.formLogin = this.formBuilder.group({
      email: ['', Validators.email],
      senha: ['']
    });
  }

  getFields() {
    return this.formLogin.controls;
  }

  onConfirmar() {
    this.spinner.show();
    const email = this.formLogin.value.email;
    const senha = this.formLogin.value.senha;
    this.usuarioService.validarPorEmail(email, senha).subscribe( token => {
        this.usuarioService.buscarPorEmail(email, token.access_token).subscribe(
            usuario => {
              const _usuario = {
                idUsuario: usuario.idUsuario,
                idCliente: (usuario.cliente != undefined && usuario.cliente != null  ? usuario.cliente.idCliente : null),
                cpfCnpj: (usuario.cliente != undefined && usuario.cliente != null  ? usuario.cliente.cpfCnpj : null),
                nome: (usuario.cliente != undefined  && usuario.cliente != null ? usuario.cliente.nome : null),
                email: usuario.email,
                perfis: usuario.perfis,
                accessToken: token.access_token,
                refreshToken: token.refresh_token
              };

              this.usuarioLogadoService.registrarUsuarioLogado(_usuario, token);
              this.spinner.hide();
              this.router.navigate(['/loja/home']);
              this.notifier.notify('info', 'A partir de agora você está autenticado no site.');
            }
          );
      },
      err => {
        console.log(err);
        this.spinner.hide();
        if ( err.hasOwnProperty('error') && err.error !== undefined ) {
            if ( err.error.error === 'invalid_grant' ) {
              this.notifier.notify('error', 'Usuário e/ou senha invalido.');
            } else {
              this.notifier.notify('error', 'Ocorreu um erro interno. Tente novamente.');
            }
        } else {
          this.notifier.notify('error', 'Ocorreu um erro interno. Tente novamente.');
        }
      });
  }



}
