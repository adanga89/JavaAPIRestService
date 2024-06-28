import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonList } from './list/pokemon-list.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    PokemonList
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    PokemonList
  ]
})
export class PokemonModule { }
