import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FooterComponent} from "./layout/footer/footer.component";
import {HeaderComponent} from "./layout/header/header.component";
import {HomeComponent} from "./layout/home/home.component";
import {CartComponent} from "./feature-module/cart/cart.component";
import {DetailComponent} from "./feature-module/detail/detail.component";
import {CustomerListComponent} from "./feature-module/customer-list/customer-list.component";
import {ConfirmPaypalComponent} from "./feature-module/confirm-paypal/confirm-paypal.component";
import {PaymentComponent} from "./feature-module/payment/payment.component";
import {TransactionComponent} from "./feature-module/transaction/transaction.component";
import {HttpClientModule} from "@angular/common/http";
// import {SecurityModule} from "./security/security.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ToastrModule} from "ngx-toastr";


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    // ToastrModule.forRoot(),
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

