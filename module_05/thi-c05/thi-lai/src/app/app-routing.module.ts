import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EditComponent} from "./edit/edit.component";
import {ListComponent} from "./list/list.component";
import {DeleteComponent} from "./delete/delete.component";
import {HomeComponent} from "./home/home.component";
import {DetailComponent} from "./list/detail/detail.component";
import {CreateComponent} from "./create/create.component";


const routes: Routes = [
  {path: "", pathMatch: 'full', component: HomeComponent},
  {path: "car-create", component: CreateComponent},
  {path: "car", component: ListComponent},
  {path: "car/detail/:id", component: DetailComponent},
  {path: "car-edit/:id", component: EditComponent},
  {path: "car-delete/:id", component: DeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
