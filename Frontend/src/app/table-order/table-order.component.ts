import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { product, basicProducts, drinkProducts } from '../product';

@Component({
  selector: 'app-table-order',
  standalone: true,
  imports: [NgFor],
  templateUrl: './table-order.component.html',
  styleUrl: './table-order.component.css'
})


export class TableOrderComponent implements OnInit {
  tableId!: number;
  basicProducts:product[] = basicProducts;
  drinkProducts: product[] = drinkProducts;
  orderList:product[] = [];
  fullPrice:number = 0;

  constructor(private router:ActivatedRoute,private http:HttpClient){}

  
  ngOnInit(): void {
    this.router.params.subscribe(res=>{
      if(res)
        this.tableId =  res['id'];
    })
  }

  addToOrder(product:product){
      this.fullPrice+=product.price
      this.orderList.push(product);
  }

  endOrder(){
    if(this.orderList.length==0){
      return;
    }
    this.http.post("http://localhost:8080/main/order/"+this.tableId,this.orderList).subscribe(
      e=>{
        alert("Założono zamówienie!")
        this.fullPrice =0;
        this.orderList = []
      }
    )
  }

}
