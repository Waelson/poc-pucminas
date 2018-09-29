import { AuthorationGuard } from './util/authorization-guard';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TooltipModule } from 'ngx-bootstrap';
import { NotifierModule, NotifierOptions } from 'angular-notifier';
import { NgxSpinnerModule } from 'ngx-spinner';


import { LojaRoutingModule } from './loja-routing.module';
import { HeaderLojaComponent } from './componentes/header-loja/header-loja.component';
import { CarrosselLojaComponent } from './componentes/carrossel-loja/carrossel-loja.component';
import { RodapeLojaComponent } from './componentes/rodape-loja/rodape-loja.component';
import { MarketingLojaComponent } from './componentes/marketing-loja/marketing-loja.component';
import { ProdutoDestaqueComponent } from './componentes/produto-destaque/produto-destaque.component';
import { CarouselModule } from 'ngx-bootstrap';
import { HomeTelaComponent } from './telas/home-tela/home-tela.component';
import { LayoutComponent } from './telas/layout/layout.component';
import { DepartamentoTelaComponent } from './telas/departamento-tela/departamento-tela.component';
import { ProdutoCartaoLojaComponent } from './componentes/produto-cartao-loja/produto-cartao-loja.component';
import { LoginTelaComponent } from './telas/login-tela/login-tela.component';
import { CarrinhoTelaComponent } from './telas/carrinho-tela/carrinho-tela.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AreaClienteTelaComponent } from './telas/area-cliente-tela/area-cliente-tela.component';
import { HistoricoComprasComponent } from './telas/area-cliente-tela/historico-compras/historico-compras.component';
import { ReclamacoesComponent } from './telas/area-cliente-tela/reclamacoes/reclamacoes.component';
import { MeusDadosComponent } from './telas/area-cliente-tela/meus-dados/meus-dados.component';
import { AcessoNegadoTelaComponent } from './telas/acesso-negado-tela/acesso-negado-tela.component';


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
    // NgxSpinnerModule,
    LojaRoutingModule,
    CarouselModule.forRoot(),
    NotifierModule.withConfig(customNotifierOptions),
    TooltipModule.forRoot()
  ],

  declarations: [HeaderLojaComponent,
    CarrosselLojaComponent, RodapeLojaComponent, MarketingLojaComponent,
    ProdutoDestaqueComponent,
    HomeTelaComponent,
    LayoutComponent,
    DepartamentoTelaComponent,
    ProdutoCartaoLojaComponent,
    LoginTelaComponent,
    CarrinhoTelaComponent,
    AreaClienteTelaComponent,
    HistoricoComprasComponent,
    ReclamacoesComponent,
    MeusDadosComponent,
    AcessoNegadoTelaComponent],

  providers: [AuthorationGuard]
})
export class LojaModule { }
