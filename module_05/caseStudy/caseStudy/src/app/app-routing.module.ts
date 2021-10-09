import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";
import {CustomerEditComponent} from "./customer/customer-edit/customer-edit.component";
import {CustomerDetailComponent} from "./customer/customer-list/customer-detail/customer-detail.component";
import {CustomerDeleteComponent} from "./customer/customer-delete/customer-delete.component";
import {HomePageComponent} from "./home-page/home-page.component";


const routes: Routes = [
  {path: "", pathMatch: 'full', component: HomePageComponent},
  {path: "customer", component: CustomerListComponent},
  {path: "customer/detail/:id", component: CustomerDetailComponent},
  {path: "customer-create", component: CustomerCreateComponent},
  {path: "customer-edit/:id", component: CustomerEditComponent},
  {path: "customer-delete/:id", component: CustomerDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
