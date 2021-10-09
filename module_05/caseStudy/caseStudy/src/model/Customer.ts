import {CustomerType} from "./CustomerType";

export interface Customer {
  id: number;
  codeCustomer: string;
  name: string;
  dateOfBirth: string;
  identityCard: number;
  phone: number;
  mail: string;
  address: string;
  customerType: CustomerType;

}
