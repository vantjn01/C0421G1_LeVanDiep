import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BenhAnComponent} from "./benh-an/benh-an.component";
import {BenhanDetailComponent} from "./benh-an/benhan-detail/benhan-detail.component";
import {BenhanCreateComponent} from "./benhan-create/benhan-create.component";
import {BenhanEditComponent} from "./benhan-edit/benhan-edit.component";
import {BenhanDeleteComponent} from "./benhan-delete/benhan-delete.component";


const routes: Routes = [
  {path: "benhan", component: BenhAnComponent},
  {path: "benhan/detail/:idBenhAn", component: BenhanDetailComponent},
  {path: "benhan-create", component: BenhanCreateComponent},
  {path: "benhan-edit/:idBenhAn", component: BenhanEditComponent},
  {path: "benhan-delete/:idBenhAn", component: BenhanDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
