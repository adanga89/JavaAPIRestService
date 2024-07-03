import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


export const routes: Routes = [
  { path: "", pathMatch: "full", loadComponent: () => import('./index/index.component').then(mod => mod.IndexComponent) },
  { 
      path: 'pokemon',       
      loadChildren: () => import("./pokemon/pokemon.module").then(mod =>mod.PokemonModule)
  },
  { 
      path: 'catalog', 
      //loadComponent: () => import('./catalog/catalog.component').then(mod => mod.CatalogComponent)},
      loadChildren: () => import("./catalog/catalog.module").then(mod => mod.CatalogModule)
  },
  { path: 'login', loadComponent: () => import('./login/login.component').then(comp => comp.LoginComponent) },
  { path: "**", redirectTo: "" }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
