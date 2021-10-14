import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./thithu/home/home.component";
import {DeleteComponent} from "./thithu/delete/delete.component";
import {CreateComponent} from "./thithu/create/create.component";
import {ListComponent} from "./thithu/list/list.component";


const routes: Routes = [
  {path: "", pathMatch: 'full', component: HomeComponent},
  {path: "movie", component: ListComponent},
  {path: "movie-create", component: CreateComponent},
  {path: "movie-delete/:id", component: DeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
