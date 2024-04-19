import { Component } from '@angular/core';
import { OrderService } from '../order.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css',
  providers:[OrderService,HttpClient]
})
export class ProductComponent {

  private oid:number = 0;
  constructor(private orderService:OrderService){

  }

  saveOrder(product:any,price:any,status:any){
    let orderid = this.oid+1;
      let ord ={ oid:orderid,
        product:product,
      price:price,
      status:status};
        this.orderService.saveOrder(ord).subscribe(res=>{
          console.log('order placed');
        });
  }

}
