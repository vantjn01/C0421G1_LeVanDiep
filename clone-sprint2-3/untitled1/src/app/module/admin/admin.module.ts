import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { DetailComponent } from './detail/detail.component';
import { PaymentComponent } from './payment/payment.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {ToastrModule} from 'ngx-toastr';
import { CartComponent } from './cart/cart.component';
import { ComfirmPaypalComponent } from './comfirm-paypal/comfirm-paypal.component';
import { ListComponent } from './customer/list/list.component';
import { TransactionComponent } from './transaction/transaction.component';
import { InfoCustomerComponent } from './info-customer/info-customer.component';


@NgModule({
  declarations: [DetailComponent, PaymentComponent, CartComponent, ComfirmPaypalComponent, ListComponent, TransactionComponent, InfoCustomerComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot()
  ]
})
export class AdminModule { }
