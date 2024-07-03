import { Component } from '@angular/core';
import { CatalogService } from '../../../services/catalog.service';
import { CatalogInterface } from '../../../interfaces/CatalogInterface';

@Component({
  selector: 'app-catalog-list-component',
  templateUrl: './catalog-list-component.component.html',
  styleUrl: './catalog-list-component.component.css'
})
export class CatalogListComponentComponent {

  private _dataService: any;
  private _token: string | null = "";

  public catalogData: CatalogInterface[] = [];
  public load: boolean = false;

  constructor(private service: CatalogService){
    if(localStorage.getItem("token"))
      this._token = localStorage.getItem("token");
  }

  ngOnInit(){
    if(this._token)
      this.service.getList(this._token).subscribe({
        next: (data:CatalogInterface[]) =>{
          this.catalogData = data;
        },
        error: (err) =>{
          console.log(err)
        },
        complete: () => {
          console.log("Ok")
        }
    });
  }

}
