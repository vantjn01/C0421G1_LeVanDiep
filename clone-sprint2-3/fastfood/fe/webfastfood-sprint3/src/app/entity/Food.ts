import {ICategory} from './ICategory';
import {IOrderDetail} from './IOrderDetail';

export interface Food {
  categoryId: number;
  categoryName: string;
  categoryCode: string;
  foodAndDrink: Food[];
  deleteFlag: boolean;

}
