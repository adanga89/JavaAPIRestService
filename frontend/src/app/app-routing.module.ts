import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


export const routes: Routes = [
  { path: "", loadComponent: () => import('./index/index.component').then(mod => mod.IndexComponent) },
  { 
      path: 'pokemon',       
      loadChildren: () => import("./pokemon/pokemon.module").then(mod =>mod.PokemonModule)
  },
  { path: 'catalog', loadComponent: () => import('./catalog/catalog.component').then(mod => mod.CatalogComponent)},
  { path: "**", redirectTo: "" }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
