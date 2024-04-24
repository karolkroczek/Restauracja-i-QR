import { Routes } from '@angular/router';
import { QrListComponent } from './qr-list/qr-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { TableOrderComponent } from './table-order/table-order.component';

export const routes: Routes = [
    {path:'qr-list',component:QrListComponent},
    {path:'order-list',component:OrderListComponent},
    {path:'table/:id',component:TableOrderComponent}
];
