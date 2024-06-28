import { Injectable } from '@angular/core';
import { PokemonResult, PokemonsInterface } from '../interfaces/pokemonsInterface';
import { HttpClient } from "@angular/common/http";
import { PokemonDataInterface } from '../interfaces/pokemonDataInterface';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private _pokemonsList?: PokemonsInterface;
  private _pokemonData?: PokemonDataInterface;
  private _tagsHistory: string[] = [];
  private _serviceUrl: string = "http://localhost:8080/api/pokemon";
  private _imageService: string ="https://img.pokemondb.net/artwork/";
  
  constructor(private http: HttpClient) {}

  get tagsHistory(){
    return this._tagsHistory;
  }

  searchPokemon(tag: string): void{
    this._tagsHistory.unshift(tag);
    this.http.get<PokemonDataInterface>(`${ this._serviceUrl }/${tag}`)
    .subscribe(resp => this._pokemonData = resp)
  }

  async indexData(){
    this.http.get<PokemonsInterface>(`${ this._serviceUrl }`)
    .subscribe(resp => this._pokemonsList = resp);
  }

  getimage(pokemon: string): string{
    return `${this._imageService}${pokemon}.jpg`;
  }

  get pokemonsResult(){
    return this._pokemonsList;
  }

  get pokemonList(){
    return this._pokemonsList;
  }
}
