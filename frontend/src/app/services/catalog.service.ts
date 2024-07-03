import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CatalogInterface } from "../interfaces/CatalogInterface";

@Injectable({
    providedIn: "root"
})
export class CatalogService{
    private UrlService: string = "http://localhost:8080/";    

    constructor(private http: HttpClient){}

    getList(token: string){
        return this.http.get<CatalogInterface[]>(this.UrlService, {
            headers: {"Authorization": token, 'Content-Type': 'application/json'}
        });
    }

    addToCatalog(data: CatalogInterface, token: string){
        return this.http.post<CatalogInterface>(this.UrlService,data, {
            headers: {"Authorization": "Bearer " + token}
        });        
    }
}