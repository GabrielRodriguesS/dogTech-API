import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app/app.component';
import {AnimalListComponent} from './app/animal/animal-list/animal-list.component';
import {AnimalViewComponent} from './app/animal/animal-view/animal-view.component';
import {AnimalCreateComponent} from './app/animal/animal-create/animal-create.component';

const routes: Routes = [
  { path: '*', component: AppComponent },
  { path: 'animais', component: AnimalListComponent},
  { path: 'animais/:name', component: AnimalViewComponent},
  { path: 'animal/novo', component: AnimalCreateComponent}

];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
