import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './core/header/header.component';
import { FooterComponent } from './core/footer/footer.component';
import { CodeHighlighterModule, TabMenuModule, TabViewModule } from 'primeng/primeng';
import { AppRoutingModule } from '../app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AnimalListComponent } from './animal/animal-list/animal-list.component';
import { AnimalResource } from './animal/resource/animal-resource';
import { HttpClientModule } from '@angular/common/http';
import { DataViewModule } from 'primeng/dataview';
import { CardModule } from 'primeng/card';
import { InputSwitchModule } from 'primeng/inputswitch';
import { AnimalViewComponent } from './animal/animal-view/animal-view.component';
import { AnimalCreateComponent } from './animal/animal-create/animal-create.component';
import { FormsModule } from '@angular/forms';
import { StepsModule } from 'primeng/steps';
import { ButtonModule } from 'primeng/button';
import { ArchwizardModule } from 'angular-archwizard';
import { CalendarModule } from 'primeng/calendar';
import { SelectButtonModule } from 'primeng/selectbutton';
import { TooltipModule } from 'primeng/tooltip';
import { InputTextModule } from 'primeng/inputtext';
import { MultiSelectModule } from 'primeng/multiselect';
import { ListboxModule } from 'primeng/listbox';
import { InputTextareaModule } from 'primeng/inputtextarea';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AnimalListComponent,
    AnimalViewComponent,
    AnimalCreateComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    TabMenuModule,
    TabViewModule,
    DataViewModule,
    InputSwitchModule,
    CardModule,
    StepsModule,
    CodeHighlighterModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonModule,
    ArchwizardModule,
    CalendarModule,
    SelectButtonModule,
    TooltipModule,
    InputTextModule,
    MultiSelectModule,
    ListboxModule,
    InputTextareaModule
  ],
  providers: [AnimalResource],
  bootstrap: [AppComponent]
})
export class AppModule {
}
