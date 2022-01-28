import {ICategory} from './ICategory';
import {IOrderDetail} from './IOrderDetail';

export interface Food {
  fadId: number;
  fadName: string;
  fadImage: string;
  fadCode: string;
  fadPrice: number;
  // fadWaitTime: number;
  deleteFlag: boolean;
  category: ICategory;
  quantityPeopleOrder:number;
  orderDetails: IOrderDetail[];
  description:string;


}
