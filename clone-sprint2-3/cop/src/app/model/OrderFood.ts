import {Food} from './Food';
import {Orders} from './Orders';

export interface OrderFood {
  orderFoodId:number;
  quantityFood:number;
  orders:  Orders;
  food: Food;
}
