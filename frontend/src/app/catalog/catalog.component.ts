import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CatalogModule } from './catalog.module';

@Component({
  selector: 'app-catalog',
  standalone: true,
  imports: [
    CatalogModule,
    FormsModule
  ],
  templateUrl: './catalog.component.html',
  styleUrl: './catalog.component.css'
})
export class CatalogComponent {

  constructor(private router: Router){
    if(!localStorage.getItem("token")){
      router.navigate(["login"]) .then(() => {
        window.location.reload();
      });
    }
  }

  logOut(){
    localStorage.clear();
    this.router.navigate(["/login"]);
  }

  getUser(){
    return localStorage.getItem("username");
  }

  getUrl(url: string){    
    return !this.router.url.includes(url);
  }
}
