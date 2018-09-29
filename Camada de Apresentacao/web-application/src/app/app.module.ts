import { UsuarioLogadoService } from './sharing/usuario-logado.service';
import { HttpRequestInterceptor } from './sharing/http-request.interceptor';
import { NotifierOptions, NotifierModule } from 'angular-notifier';
import { NgxSpinnerModule } from 'ngx-spinner';
import { ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ErrorsHandler } from './sharing/errors-handler';


const rotas: Routes = [
  { path: 'loja', loadChildren: 'src/app/loja/loja.module#LojaModule' },
  { path: 'administrativo', loadChildren: 'src/app/administracao/administracao.module#AdministracaoModule' },
  { path: '', redirectTo: 'loja', pathMatch: 'full' },
  { path: '**', redirectTo: 'loja' }
];


const customNotifierOptions: NotifierOptions = {
  position: {
    horizontal: {position: 'left', distance: 12},
    vertical: {position: 'bottom', distance: 12, gap: 10}
  },
  theme: 'material',
  behaviour: {autoHide: 1500, onClick: 'hide', onMouseover: 'pauseAutoHide', showDismissButton: true, stacking: 4},
  animations: {
    enabled: true,
    show: {
      preset: 'slide',
      speed: 300,
      easing: 'ease'
    },
    hide: {
      preset: 'fade',
      speed: 300,
      easing: 'ease',
      offset: 50
    },
    shift: {
      speed: 300,
      easing: 'ease'
    },
    overlap: 150
  }
};



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgxSpinnerModule,
    NotifierModule.withConfig(customNotifierOptions),
    RouterModule.forRoot(rotas, { enableTracing: false, useHash: false})
  ],
  exports: [NgxSpinnerModule],
  providers: [
    /*
    {
      provide: ErrorHandler,
      useClass: ErrorsHandler
    }, */{
      provide: HTTP_INTERCEPTORS,
      useClass: HttpRequestInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
