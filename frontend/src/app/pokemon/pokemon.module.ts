import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from "@angular/forms";
import { PokemonList } from './components/list/pokemon-list.component';
import { PokemonPaginationComponent } from './components/pokemon-pagination/pokemon-pagination.component';
import { PokemonInformationComponent } from './components/pokemon-information/pokemon-information.component';

const routes: Routes = [
  {
      path: "",
      loadComponent: () => import('./pokemon.component').then(mod => mod.PokemonComponent),
      children: [
          { path: "list", component: PokemonList },
          { path: ":pokemon", component: PokemonInformationComponent },           
          { path: "**", redirectTo: "list" }
      ]
  },

];


@NgModule({
  declarations: [
    PokemonList,
    PokemonInformationComponent,
    PokemonPaginationComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    RouterModule,
    PokemonList,
    PokemonInformationComponent,
    PokemonPaginationComponent    
  ]
})
export class PokemonModule { }
