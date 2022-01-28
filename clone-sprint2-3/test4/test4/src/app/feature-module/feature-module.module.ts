import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeatureModuleRoutingModule } from './feature-module-routing.module';
import { DetailComponent } from './detail/detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {ToastrModule} from "ngx-toastr";
import {HeaderComponent} from "../layout/header/header.component";
import {FooterComponent} from "../layout/footer/footer.component";
import {HomeComponent} from "../layout/home/home.component";


@NgModule({
  declarations: [DetailComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FeatureModuleRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot()
  ]
})
export class FeatureModuleModule { }
