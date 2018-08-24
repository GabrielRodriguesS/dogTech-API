import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './core/header/header.component';
import {FooterComponent} from './core/footer/footer.component';
import {AppRoutingModule} from '../app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AnimalListComponent} from './animal/animal-list/animal-list.component';
import {AnimalResource} from './animal/resource/animal-resource';
import {HttpClientModule} from '@angular/common/http';
import {AnimalViewComponent} from './animal/animal-view/animal-view.component';
import {AnimalCreateComponent} from './animal/animal-create/animal-create.component';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {NgZorroAntdModule, NZ_I18N, pt_BR} from 'ng-zorro-antd';
import {registerLocaleData} from '@angular/common';
import {BaiaCreteComponent} from './baia/baia-crete/baia-crete.component';
import {BaiaResource} from './baia/resource/baia-resource';
import pt from '@angular/common/locales/pt';

registerLocaleData(pt);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AnimalListComponent,
    AnimalViewComponent,
    AnimalCreateComponent,
    BaiaCreteComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgZorroAntdModule
  ],
  providers: [AnimalResource, BaiaResource, { provide: NZ_I18N, useValue: pt_BR }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
