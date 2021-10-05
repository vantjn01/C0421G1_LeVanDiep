// import { BrowserModule } from '@angular/platform-browser';
// import { NgModule } from '@angular/core';
//
// import { AppRoutingModule } from './app-routing.module';
// import { AppComponent } from './app.component';
// import { FormComponent } from './form/form.component';
// import {ReactiveFormsModule} from "@angular/forms";
//
// @NgModule({
//   declarations: [
//     AppComponent,
//     FormComponent
//   ],
//   imports: [
//     BrowserModule,
//     AppRoutingModule,
//     ReactiveFormsModule
//   ],
//   providers: [],
//   bootstrap: [AppComponent]
// })
// export class AppModule { }
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {ReactiveFormsModule} from '@angular/forms';
import {RegisterComponent} from "./register/register.component";


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    // LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
