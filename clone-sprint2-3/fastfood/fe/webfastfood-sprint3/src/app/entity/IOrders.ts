
import {IOrderDetail} from './IOrderDetail';

import {IAccount} from "./IAccount";

export interface IOrders {
  orderId: number;
  orderCode: string;
  createDate: string;
  account: IAccount;
  orderDetails: IOrderDetail[];
}
