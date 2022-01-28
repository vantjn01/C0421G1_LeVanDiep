import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./layout/home/home.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  // {path: 'login', component: LoginComponent},
  {
    path: 'admin',
    loadChildren: () => import('./feature-module/feature-module.module').then(module => module.FeatureModuleModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
