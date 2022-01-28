import {Orders} from './Orders';
import {Food} from './Food';

export interface OrderFood {
  orderFoodId: number;
  quantityFood: number;
  orders: Orders;
  food: Food;
}
