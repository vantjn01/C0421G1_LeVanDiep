import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BenhAnComponent } from './benh-an/benh-an.component';
import { BenhanCreateComponent } from './benhan-create/benhan-create.component';
import { BenhanEditComponent } from './benhan-edit/benhan-edit.component';
import { BenhanDeleteComponent } from './benhan-delete/benhan-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    BenhAnComponent,
    BenhanCreateComponent,
    BenhanEditComponent,
    BenhanDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
