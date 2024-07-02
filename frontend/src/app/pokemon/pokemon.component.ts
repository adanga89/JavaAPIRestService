import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { PokemonModule } from './pokemon.module';

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [
    PokemonModule,    
    FormsModule
  ],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css',
})
export class PokemonComponent {  
  public pokemonSearch: string = "";

  constructor(private router: Router){}

  searchPokemon(){
    if(this.pokemonSearch.trim() !== ""){
      this.router.navigate([`pokemon/${this.pokemonSearch}`]) 
      .then(() => {
        window.location.reload();
      });
    }else{
      alert("El nombre del pokémon es necesario")
    }
  }
}
