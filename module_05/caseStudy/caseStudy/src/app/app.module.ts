import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { EmployeeComponent } from './employee/employee.component';
import { ContractComponent } from './contract/contract.component';
import { ServiceComponent } from './service/service.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import { CustomerDetailComponent } from './customer/customer-detail/customer-detail.component';
import { ContractCreateComponent } from './contract/contract-create/contract-create.component';
import { ContractDetailCreateComponent } from './contract/contract-detail-create/contract-detail-create.component';
import { ContractListComponent } from './contract/contract-list/contract-list.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeDetailComponent } from './employee/employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './employee/employee-edit/employee-edit.component';
import { ServiceListComponent } from './service/service-list/service-list.component';
import { ServiceCreateComponent } from './service/service-create/service-create.component';
import { ServiceDetailComponent } from './service/service-detail/service-detail.component';
import { ServiceEditComponent } from './service/service-edit/service-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
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
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeDetailComponent,
    EmployeeEditComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    ServiceDetailComponent,
    ServiceEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
