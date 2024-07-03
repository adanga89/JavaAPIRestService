import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from "@angular/forms";
import { CatalogListComponentComponent } from './components/catalog-list-component/catalog-list-component.component';

const routes: Routes = [
  {
      path: "",
      loadComponent: () => import('./catalog.component').then(mod => mod.CatalogComponent),
      children: [
          { path: "list", component: CatalogListComponentComponent },
          { path: ":id", component: CatalogListComponentComponent },           
          { path: "**", redirectTo: "list" }
      ]
  },

];


@NgModule({
  declarations: [  
    CatalogListComponentComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    RouterModule,
  ]
})
export class CatalogModule { }
