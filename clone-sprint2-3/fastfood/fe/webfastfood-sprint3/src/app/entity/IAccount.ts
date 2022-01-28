import {IRole} from './IRole';
import {ICustomer} from './ICustomer';


export interface IAccount {
  accountId: number;
  accountUsername: string;
  accountPassword: string;
  email: string;
  deleteFlag: boolean;
  activeFlag: boolean;
  roles: IRole[];
  customer: ICustomer;

}
