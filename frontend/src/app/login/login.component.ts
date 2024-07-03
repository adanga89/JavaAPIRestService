import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { Alert } from '../interfaces/AlertInterface';
import { LoginService } from '../services/login.service';
import { loginSuccess } from '../interfaces/LoginInterface';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    NgbAlertModule,
    FormsModule,
    RouterModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {
  
  public validandoLogin: boolean = false;
  public user: string = "";
  public pass: string = "";
  private _login: any;

  alerts?: Alert;

	constructor(private service: LoginService,
    private router: Router
  ) {		
    if(localStorage.getItem("token")){
      router.navigate(["catalog"]);
    }
	}

  return(){
    this.router.navigate(["/index"]);
  }

	close(alert: Alert) {
    if(alert)
		  this.alerts = undefined;
	}

	reset() {
		this.alerts = undefined;
	}

  private loginError(message: string): void {
    this.alerts = {
      type: 'danger',
      message: message
    }
  }

  login(){
    if(this.user.trim() === "" || this.pass.trim() === ""){
      this.loginError("User and Password is required.");
      return;
    }
    this.validandoLogin = true;
    this._login = this.service
    .login(this.user, this.pass)
    .subscribe(
      {
        next:(datos: loginSuccess) =>{          
          this.validandoLogin = false;
          localStorage.setItem("token", datos.token);
          localStorage.setItem("username", datos.username);        
          this.router.navigate(["catalog"]);
        },
        error: (err) => {
          this.validandoLogin = false;          
          this.loginError(err.error.message);          
        },       
        complete: () => {
          setTimeout(() => {            
            if(this.alerts)
              this.close(this.alerts);
           }, 5000)
        } 
      }
    )
  }

  ngOnDestroy(){
    if(this._login)
      this._login.unsubscribe();
  }
}
