import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { DetailComponent } from './detail/detail.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {ToastrModule} from 'ngx-toastr';
import { CartComponent } from './cart/cart.component';
import { ListComponent } from './customer/list/list.component';
import {SortPipe} from "./sort.pipe";
import {ComfirmPaypalComponent} from "./comfirm-paypal/comfirm-paypal.component";
import {PaymentComponent} from "./payment/payment.component";


@NgModule({
  declarations: [
    DetailComponent,
    CartComponent,
    ListComponent,
    SortPipe,
    ComfirmPaypalComponent,
    PaymentComponent
  ],
  exports: [
    SortPipe
  ],
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
