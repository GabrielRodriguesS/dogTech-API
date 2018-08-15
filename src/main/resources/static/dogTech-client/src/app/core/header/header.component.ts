import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  menuItens: any[];

  constructor() {
  }

  ngOnInit() {
    this.menuItens = [
      {label: 'Animais', url: '/animais'},
      {label: 'Cadastrar animal', url: '/novo/animal'},
      {label: 'Documentation', icon: 'fa fa-fw fa-book'},
      {label: 'Support', icon: 'fa fa-fw fa-support'},
      {label: 'Social', icon: 'fa fa-fw fa-twitter'}
    ];
  }

}
