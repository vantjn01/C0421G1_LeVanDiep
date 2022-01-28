import {Gender} from "./Gender";

export interface Customer {
  customerId: number;
  customerName: string;
  flag: number;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
  account: Account;
  gender: Gender;
}
