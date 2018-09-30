import { ReactiveFormsModule } from '@angular/forms';
import { GuardRouterAdmin } from './util/guard-router-admin';
import { NotifierModule, NotifierOptions } from 'angular-notifier';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministracaoRoutingModule } from './administracao-routing.module';
import { HeaderAdminComponent } from './componentes/header-admin/header-admin.component';
import { FooterAdminComponent } from './componentes/footer-admin/footer-admin.component';
import { LoginAdminTelaComponent } from './telas/login-admin-tela/login-admin-tela.component';
import { ConsoleAdminTelaComponent } from './telas/console-admin-tela/console-admin-tela.component';
import { LayoutAdminTelasComponent } from './telas/layout-admin-telas/layout-admin-telas.component';
import { HomeAdminTelaComponent } from './telas/home-admin-tela/home-admin-tela.component';
import { LayoutConsoleAdminTelaComponent } from './telas/layout-console-admin-tela/layout-console-admin-tela.component';
// tslint:disable-next-line:max-line-length
import { ControleVendaHomeTelaComponent } from './telas/console-admin-tela/controle-vendas/controle-venda-home-tela/controle-venda-home-tela.component';
// tslint:disable-next-line:max-line-length
import { ControleVendaLayoutTelaComponent } from './telas/console-admin-tela/controle-vendas/controle-venda-layout-tela/controle-venda-layout-tela.component';
import { AcessoNegadoAdminTelaComponent } from './telas/acesso-negado-admin-tela/acesso-negado-admin-tela.component';

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
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NotifierModule.withConfig(customNotifierOptions),
    AdministracaoRoutingModule
  ],
  declarations: [
    HeaderAdminComponent,
    FooterAdminComponent,
    LoginAdminTelaComponent,
    ConsoleAdminTelaComponent,
    LayoutAdminTelasComponent,
    HomeAdminTelaComponent,
    LayoutConsoleAdminTelaComponent,
    ControleVendaHomeTelaComponent,
    ControleVendaLayoutTelaComponent,
    AcessoNegadoAdminTelaComponent],
  providers: [GuardRouterAdmin]
})
export class AdministracaoModule { }
