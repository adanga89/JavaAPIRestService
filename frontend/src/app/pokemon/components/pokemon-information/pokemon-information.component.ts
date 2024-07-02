import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PokemonService } from '../../../services/pokemon.service';
import { PokemonDataInterface } from '../../../interfaces/pokemonDataInterface';

@Component({
  selector: 'app-pokemon-information',
  templateUrl: './pokemon-information.component.html',
  styleUrl: './pokemon-information.component.css'
})
export class PokemonInformationComponent {  
  private  pokemon?: string = "";
  public pokemonInfo?: PokemonDataInterface;
  private data: any
  
  constructor(private service: PokemonService,
    private activeRouter: ActivatedRoute){
      this.pokemon = this.activeRouter.snapshot.paramMap.get("pokemon")?.toString();
  }

  ngOnInit(){
    if(this.pokemon)
      this.data = this.service
    .searchPokemon(this.pokemon)
    .subscribe(res => this.pokemonInfo = res);
  }


getImage(pokemon: string){
  return this.service.getimage(pokemon);
}

  ngOnDestroy(){
    this.data.unsuscribe();
  }
}
