import { Subject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';

const USUARIO_LOGADO = '@usuarioLogado';
const CLIENTE = 'CLIENTE';
const VENDEDOR = 'VENDEDOR';
const ADMINISTRADOR = 'ADMINISTRADOR';

@Injectable({
  providedIn: 'root'
})
export class UsuarioLogadoService {

  private subject = new Subject<any>();

  constructor() { }

  registrarUsuarioLogado(usuario: any, tokens: any) {
    localStorage.setItem(USUARIO_LOGADO, JSON.stringify( usuario ));
    this.subject.next( usuario );
  }

  usuarioEstaLogado() {
    const usuario = this.getUsuarioLogado();
    const v = usuario !== null;

    // console.log( this.isCliente() );
    // console.log( this.isVendedor() );
    // console.log( this.isAdministrador() );
    return v;
  }

  getUsuarioLogado() {
    const usuario = JSON.parse( localStorage.getItem(USUARIO_LOGADO) );
    return usuario;
  }

  getUsuarioStorage(): Observable<any> {
    return this.subject.asObservable();
  }

  logoff() {
    localStorage.clear();
    this.subject.next( undefined );
  }

  isVendedor() {
    const resultado = this.temPerfil(VENDEDOR);
    // console.log('Is vendedor: ' + resultado);
    return resultado;
  }

  isCliente() {
    const resultado = this.temPerfil(CLIENTE);
    // console.log('Is cliente: ' + resultado);
    return resultado;
  }

  isAdministrador() {
    const resultado = this.temPerfil(ADMINISTRADOR);
    // console.log('Is administrador: ' + resultado);
    return resultado;
  }

  private temPerfil (nomePerfill) {
    if ( ! this.usuarioEstaLogado() ) {
      return false;
    }
    const usuarioLogado = this.getUsuarioLogado();
    for (const perfil of usuarioLogado.perfis) {
      if (perfil.nome === nomePerfill) {
        return true;
      }
    }
    return false;
  }
}
