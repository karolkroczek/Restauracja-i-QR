import { NgFor, NgIf } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-qr-list',
  standalone: true,
  imports: [HttpClientModule,NgFor,NgIf],
  templateUrl: './qr-list.component.html',
  styleUrl: './qr-list.component.css',
  providers:[
    
  ]
})
export class QrListComponent implements OnInit {

  urls:any = [];

  constructor(private httpClient:HttpClient){}
  
  ngOnInit(): void {

    for( let i =0;i<5;i++){

      
      this.httpClient.post("http://localhost:8080/main",{id:i},{
        responseType:"arraybuffer",
        headers:{
        }
      }).subscribe(res=>{
        const blob = new Blob([res],{type:'image/png'});
        const url = URL.createObjectURL(blob);
        console.log(url);
        this.urls[i] = url;
      });
    }
  }

}
