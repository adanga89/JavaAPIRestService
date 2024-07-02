import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pokemon-pagination',
  templateUrl: './pokemon-pagination.component.html',
  styleUrl: './pokemon-pagination.component.css'
})
export class PokemonPaginationComponent {
  @Input()
  public totalPokemon: number = 0;
  public pagination: number = 0;
  private _tagPaginate : number = 1;
  public offset: number = 0;
  public limit: number = 20;
  
  ngOnInit(){    
    if(this.totalPokemon > 0)
      this.pagination = Math.ceil(this.totalPokemon / 20);
  }

  getPagination(pagina: number){
    this._tagPaginate = pagina;
    return `/${pagina*20}/20`;
  }

  getActivePage(){
    return this._tagPaginate;
  }
}
