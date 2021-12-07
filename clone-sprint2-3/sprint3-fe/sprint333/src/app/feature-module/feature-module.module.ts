import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeatureModuleRoutingModule } from './feature-module-routing.module';
import { CartComponent } from './cart/cart.component';
import { ConfirmPaypalComponent } from './confirm-paypal/confirm-paypal.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { DetailComponent } from './detail/detail.component';
import { CustomerInfoComponent } from './customer-info/customer-info.component';
import { PaymentComponent } from './payment/payment.component';
import { TransactionComponent } from './transaction/transaction.component';


@NgModule({
  declarations: [CartComponent, ConfirmPaypalComponent, CustomerListComponent, DetailComponent, CustomerInfoComponent, PaymentComponent, TransactionComponent],
  imports: [
    CommonModule,
    FeatureModuleRoutingModule
  ]
})
export class FeatureModuleModule { }
