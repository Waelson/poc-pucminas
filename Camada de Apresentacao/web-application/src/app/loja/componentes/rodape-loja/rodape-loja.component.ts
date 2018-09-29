import { NotifierService } from 'angular-notifier';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rodape-loja',
  templateUrl: './rodape-loja.component.html',
  styleUrls: ['./rodape-loja.component.css']
})
export class RodapeLojaComponent implements OnInit {

  constructor(private notifier: NotifierService) { }

  ngOnInit() {
  }

  onPoliticaDePrivacidade() {
    this.notifier.notify('info', 'Funcionalidade não implementada.');
  }

}
