import { Routes } from '@angular/router';

export const routes: Routes = [
    { path: "", loadComponent: () => import('./index/index.component').then(mod => mod.IndexComponent) },
    { path: 'pokemon', loadComponent: () => import('./pokemon/pokemon.component').then(mod => mod.PokemonComponent)},
    { path: 'catalog', loadComponent: () => import('./catalog/catalog.component').then(mod => mod.CatalogComponent)}
];
