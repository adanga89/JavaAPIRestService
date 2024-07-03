import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { loginSuccess } from "../interfaces/LoginInterface";

@Injectable({
    providedIn: 'root'
})
export class LoginService{
    private UrlService: string = "http://localhost:8080/login";    
    
    constructor(private http: HttpClient){}

    login(user: string, pass: string){
        return this.http.post<loginSuccess>(this.UrlService,{username: user, password: pass})
    }
}