import { AcessoNegadoTelaComponent } from './telas/acesso-negado-tela/acesso-negado-tela.component';
import { AuthorationGuard } from './util/authorization-guard';
import { ReclamacoesComponent } from './telas/area-cliente-tela/reclamacoes/reclamacoes.component';
import { AreaClienteTelaComponent } from './telas/area-cliente-tela/area-cliente-tela.component';
import { CarrinhoTelaComponent } from './telas/carrinho-tela/carrinho-tela.component';
import { LoginTelaComponent } from './telas/login-tela/login-tela.component';
import { DepartamentoTelaComponent } from './telas/departamento-tela/departamento-tela.component';
import { LayoutComponent } from './telas/layout/layout.component';


import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeTelaComponent } from './telas/home-tela/home-tela.component';
import { HistoricoComprasComponent } from './telas/area-cliente-tela/historico-compras/historico-compras.component';
import { MeusDadosComponent } from './telas/area-cliente-tela/meus-dados/meus-dados.component';


const routes: Routes = [
  {path: '', component: LayoutComponent, children: [
    {path: 'home', component: HomeTelaComponent},
    {path: 'acesso-negado', component: AcessoNegadoTelaComponent},
    {path: 'area-do-cliente', canActivate: [AuthorationGuard], component: AreaClienteTelaComponent, children: [
      {path: 'historico-de-compras', component: HistoricoComprasComponent},
      {path: 'reclamacoes', component: ReclamacoesComponent},
      {path: 'meus-dados', component: MeusDadosComponent},
      {path: '', redirectTo: 'historico-de-compras'},
      { path: '**', redirectTo: '' }
    ]},
    {path: 'login-cliente', component: LoginTelaComponent},
    {path: 'carrinho', component: CarrinhoTelaComponent},
    {path: 'departamento/:nomeDepartamento/:idDepartamento', component: DepartamentoTelaComponent},
    {path: '', redirectTo: 'home'},
  ]}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LojaRoutingModule { }
