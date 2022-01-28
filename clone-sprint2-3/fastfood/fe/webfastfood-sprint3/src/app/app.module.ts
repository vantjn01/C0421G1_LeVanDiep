import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatDialogModule} from "@angular/material/dialog";
import {MenuModule} from "./feature-module/menu/menu.module";
import {DetailFoodComponent} from "./feature-module/food/detail-food/detail-food.component";
import {FoodComponent} from "./feature-module/food/food.component";
import {FooterComponent} from "./feature-module/footer/footer.component";
import {HeaderComponent} from "./feature-module/header/header.component";
import {CartComponent} from "./feature-module/cart/cart.component";
import {HomeModule} from "./feature-module/home/home.module";
import {CategoryComponent} from "./feature-module/category/category.component";

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CategoryComponent,
    HeaderComponent,
    FooterComponent,
    FoodComponent,
    DetailFoodComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    MenuModule,
    // CartModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatSnackBarModule,
    FormsModule,
    ReactiveFormsModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
