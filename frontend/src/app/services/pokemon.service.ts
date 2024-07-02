import { Injectable } from '@angular/core';
import { PokemonsInterface } from '../interfaces/pokemonsInterface';
import { HttpClient } from "@angular/common/http";
import { PokemonDataInterface } from '../interfaces/pokemonDataInterface';
import { Observable } from 'rxjs';

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

  searchPokemon(tag: string): Observable<PokemonDataInterface>{
    this._tagsHistory.unshift(tag);
    return this.http.get<PokemonDataInterface>(`${ this._serviceUrl }/${tag}`);
    //.subscribe(resp => this._pokemonData = resp)
  }

  indexData(): Observable<PokemonsInterface>{
    //let random = Math.floor(Math.random() * 1302);
    let url = `${ this._serviceUrl }`; ///${random}/20`;
    return this.http.get<PokemonsInterface>(url);
    //.subscribe(resp => this._pokemonsList = resp);
  }

  getimage(pokemon: string): string{
    return `${this._imageService}${pokemon}.jpg`;
  }

  getPagination(pagina: number){
    return `${this._serviceUrl}/${pagina*20}/20`;
  } 
}
