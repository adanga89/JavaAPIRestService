import { Component } from "@angular/core";
import { PokemonsInterface } from "../../../interfaces/pokemonsInterface";
import { PokemonService } from "../../../services/pokemon.service";

@Component({
    selector: 'app-pokemon-list',    
    templateUrl: './pokemon-list.component.html',
    styleUrl: './pokemon-list.component.css'
})
export class PokemonList{    
    public pokemonList?: PokemonsInterface;    

    constructor(private pokemonService: PokemonService){}

    ngOnInit(){        
        this.pokemonService.indexData();
        this.pokemonList = this.pokemonService.pokemonList;        
    }

    getImage(pokemon: string){
        return this.pokemonService.getimage(pokemon);
    }
}