import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExchangerateComponent } from './exchangerate/exchangerate.component';

const routes: Routes = [
  { path: '',component: ExchangerateComponent},
  { path: '**', component: ExchangerateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
