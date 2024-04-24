import {HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { product } from '../product';

@Component({
  selector: 'app-order-list',
  standalone: true,
  imports: [],
  templateUrl: './order-list.component.html',
  styleUrl: './order-list.component.css'
})
export class OrderListComponent implements OnInit {
orderList:product[] = [];
activeOrders:Array<any> = [];
constructor(private router:ActivatedRoute, private http:HttpClient){}
  
ngOnInit(): void {
   for(let i=0;i<5;i++){
      this.http.get("http://localhost:8080/main/order/"+i).subscribe(res=>{
        if(res != null){
          this.activeOrders[i] = res;
        }
      })
   }
   console.log(this.activeOrders)
  }


}
