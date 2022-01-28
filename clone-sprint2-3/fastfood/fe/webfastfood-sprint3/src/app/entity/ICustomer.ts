
import {IAccount} from './IAccount';
import {IOrders} from './IOrders';

export interface ICustomer {
  customerId: number;
  customerName: string;
  accountName: string;
  customerAddress: string;
  customerPhone: string;
  customerImage: string;
  customerGender:number;
  customerBirthday: string;
  account: IAccount;
  ordersSet: IOrders[];

}
