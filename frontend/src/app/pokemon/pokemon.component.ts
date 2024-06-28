import { Component } from '@angular/core';
import { PokemonModule } from './components/pokemon.module';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [PokemonModule, RouterModule],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css',
})
export class PokemonComponent {  
}
