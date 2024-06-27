import { Injectable } from '@angular/core';
import { IndexDataInterface } from '../interfaces/IndexDataInterface';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  constructor() { }

  public indexData(){

    let data: Array<IndexDataInterface> = [
      {
        title: "Pokémon",
        subTitle: "subTitle",
        description: "Consumo de Servicio para la visualización pokeAPI. Se podrá visualizar la Información de un solo pokémon o el listado de los pokémon.",
        link: "link",
        image: "https://listfist.com/wp-content/uploads/pokemons.jpg"
      },
      {
        title: "Catálogo",
        subTitle: "subTitle",
        description: "Consumo de Servicio para la creación de un catálogo, los usuarios con rol de 'USER' solo viuslizarán los datos y los usuarios con rol de 'ADMIN' podrán Viusalizar, Editar y Eliminar los registros. ",
        link: "link",
        image: "https://img.freepik.com/free-vector/businessman-holding-pencil-big-complete-checklist-with-tick-marks_1150-35019.jpg"
      }
    ];
    return data;
  }
}
