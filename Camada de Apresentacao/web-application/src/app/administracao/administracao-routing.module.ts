import { GuardRouterAdmin } from './util/guard-router-admin';
import { AcessoNegadoAdminTelaComponent } from './telas/acesso-negado-admin-tela/acesso-negado-admin-tela.component';
// tslint:disable-next-line:max-line-length
import { ControleVendaLayoutTelaComponent } from './telas/console-admin-tela/controle-vendas/controle-venda-layout-tela/controle-venda-layout-tela.component';
import { LoginAdminTelaComponent } from './telas/login-admin-tela/login-admin-tela.component';
import { LayoutAdminTelasComponent } from './telas/layout-admin-telas/layout-admin-telas.component';
import { ConsoleAdminTelaComponent } from './telas/console-admin-tela/console-admin-tela.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeAdminTelaComponent } from './telas/home-admin-tela/home-admin-tela.component';
import { LayoutConsoleAdminTelaComponent } from './telas/layout-console-admin-tela/layout-console-admin-tela.component';
// tslint:disable-next-line:max-line-length
import { ControleVendaHomeTelaComponent } from './telas/console-admin-tela/controle-vendas/controle-venda-home-tela/controle-venda-home-tela.component';


const routes: Routes = [
  {path: '', component: LayoutAdminTelasComponent, children: [
    {path: 'login', component: LoginAdminTelaComponent},
    {path: 'acesso-negado', component: AcessoNegadoAdminTelaComponent},
    {path: 'console', canActivate: [GuardRouterAdmin],  component: LayoutConsoleAdminTelaComponent, children: [
      {path: '', component: ConsoleAdminTelaComponent},
      {path: 'controle-de-vendas', component: ControleVendaLayoutTelaComponent, children: [
        {path: '', component: ControleVendaHomeTelaComponent}
      ]},
      { path: '**', redirectTo: 'console' }
    ]},
    { path: '', redirectTo: 'login' }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministracaoRoutingModule { }
