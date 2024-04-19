import { Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { OrdersComponent } from './orders/orders.component';

export const routes: Routes = [
    {path:'product',component:ProductComponent},
    {path:'orders',component:OrdersComponent}
];
