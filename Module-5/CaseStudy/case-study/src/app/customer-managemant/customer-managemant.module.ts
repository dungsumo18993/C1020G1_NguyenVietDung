import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { CustomerUpdateComponent } from './customer-update/customer-update.component';
import {RouterModule, Routes} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";


const routes: Routes = [
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-detail/:id', component: CustomerDetailComponent},
  {path: 'customer-update/:id', component: CustomerUpdateComponent}
];

@NgModule({
  declarations: [CustomerListComponent, CustomerDetailComponent, CustomerCreateComponent, CustomerUpdateComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
  ],
  exports: [RouterModule]
})
export class CustomerManagemantModule { }
