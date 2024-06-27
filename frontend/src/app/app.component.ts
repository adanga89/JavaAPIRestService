import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { IndexService } from './services/index.service';
import { IndexDataInterface } from './interfaces/IndexDataInterface';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  public data?: Array<IndexDataInterface>;

  constructor(private service?: IndexService){}

  ngOnInit(){
    this.service = new IndexService();    
    this.data = this.service.indexData();   
  }

  title = 'Angular Frontend';
}
