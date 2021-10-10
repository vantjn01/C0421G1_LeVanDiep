import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { ContractComponent } from './contract/contract.component';
import { ServiceComponent } from './service/service.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerDetailComponent } from './customer/customer-list/customer-detail/customer-detail.component';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import { ContractDetailCreateComponent } from './contract/contract-detail-create/contract-detail-create.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeDetailComponent } from './employee/emloyee-list/employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import { ServiceListComponent } from './service/service-list/service-list.component';
import { ServiceCreateComponent } from './service/service-create/service-create.component';
import { ServiceDetailComponent } from './service/service-detail/service-detail.component';
import { ServiceEditComponent } from './service/service-edit/service-edit.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import { HomePageComponent } from './home-page/home-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CustomerDeleteComponent } from './customer/customer-delete/customer-delete.component';
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {Ng2OrderModule} from "ng2-order-pipe";
import {NgxPaginationModule} from "ngx-pagination";
import { EmloyeeListComponent } from './employee/emloyee-list/emloyee-list.component';
import { EmployeeDeleteComponent } from './employee/employee-delete/employee-delete.component';



@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    ContractComponent,
    ServiceComponent,
    CustomerCreateComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerDetailComponent,
    ContractCreateComponent,
    ContractDetailCreateComponent,
    ContractListComponent,
    EmployeeCreateComponent,
    EmployeeDetailComponent,
    EmployeeEditComponent,
    EmloyeeListComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    ServiceDetailComponent,
    ServiceEditComponent,
    HomePageComponent,
    CustomerDeleteComponent,
    EmloyeeListComponent,
    EmployeeDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
