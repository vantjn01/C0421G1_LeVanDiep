import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DetailFoodComponent} from "./feature-module/food/detail-food/detail-food.component";
import {HomeComponent} from "./feature-module/home/home.component";
import {CategoryComponent} from "./feature-module/category/category.component";
import {CartComponent} from "./feature-module/cart/cart.component";
import {MenuComponent} from "./feature-module/menu/menu.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'menu', component: MenuComponent},
  {path: 'cart', component: CartComponent},

  {path: 'admin/category', component: CategoryComponent},


  {path: 'food/detail/:id', component: DetailFoodComponent},

  {path: '**', redirectTo: "/not-found"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
