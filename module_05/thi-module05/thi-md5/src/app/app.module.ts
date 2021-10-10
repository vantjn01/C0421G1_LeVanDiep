import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BenhAnComponent } from './benh-an/benh-an.component';
import { BenhanCreateComponent } from './benhan-create/benhan-create.component';
import { BenhanEditComponent } from './benhan-edit/benhan-edit.component';
import { BenhanDeleteComponent } from './benhan-delete/benhan-delete.component';
import {FormsModule} from "@angular/forms";
import {Ng2OrderModule} from "ng2-order-pipe";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from "ngx-pagination";
import {BenhanDetailComponent} from "./benh-an/benhan-detail/benhan-detail.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    BenhAnComponent,
    BenhanCreateComponent,
    BenhanEditComponent,
    BenhanDeleteComponent,
    BenhanDetailComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
      Ng2OrderModule,
      Ng2SearchPipeModule,
      NgxPaginationModule,
      HttpClientModule

    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
