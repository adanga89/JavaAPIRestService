import { Component } from '@angular/core';
import { IndexDataInterface } from '../interfaces/IndexDataInterface';
import { IndexService } from '../services/index.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {
  public data?: Array<IndexDataInterface>;

  constructor(private service?: IndexService){}

  ngOnInit(){
    this.service = new IndexService();    
    this.data = [...this.service.indexData()];   
  }

}
