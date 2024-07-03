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
    private service: any;

    constructor(private pokemonService: PokemonService){}

    ngOnInit(){        
        this.service = this.pokemonService.indexData().subscribe(res => this.pokemonList = res);          
    }

    getImage(pokemon: string){
        return this.pokemonService.getimage(pokemon);
    }

    getInformation(pokemon: string){
        return `pokemon/${pokemon}`;
    }

    ngOnDestroy() {
        this.service.unsubscribe();
    }
}