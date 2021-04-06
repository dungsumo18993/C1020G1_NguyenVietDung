import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from './body/body.component';
import {CustomerListComponent} from "./customer-managemant/customer-list/customer-list.component";


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'body'},
  {path: 'body', component: BodyComponent},
  {path: 'customer-list', component: CustomerListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
