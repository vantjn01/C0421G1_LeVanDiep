import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {ChangPassWordComponent} from './chang-pass-word/chang-pass-word.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'changePass', component: ChangPassWordComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecurityRoutingModule { }
