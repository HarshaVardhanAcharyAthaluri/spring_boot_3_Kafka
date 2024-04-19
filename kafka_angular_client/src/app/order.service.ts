import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { order } from './order';
@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { 


  }

  saveOrder(order:order){
    console.log('order placed::: '+ order.oid + ":: "+ order.product);
    return this.http.post('http://localhost:7070/save',order);
  }

  
}
