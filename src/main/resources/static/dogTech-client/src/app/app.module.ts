import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './core/header/header.component';
import {FooterComponent} from './core/footer/footer.component';
import {CodeHighlighterModule, TabMenuModule, TabViewModule} from "primeng/primeng";
import {AppRoutingModule} from '../app-routing.module';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AnimalListComponent} from './animal/animal-list/animal-list.component';
import {AnimalResource} from "./animal/resource/animal-resource";
import {HttpClientModule} from "@angular/common/http";
import {DataViewModule} from "primeng/dataview";
import {CardModule} from 'primeng/card';
import {AnimalViewComponent} from './animal/animal-view/animal-view.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AnimalListComponent,
    AnimalViewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    TabMenuModule,
    TabViewModule,
    DataViewModule,
    CardModule,
    CodeHighlighterModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AnimalResource],
  bootstrap: [AppComponent]
})
export class AppModule { }
