import {Food} from "./Food";
import {IOrders} from "./IOrders";

export interface IOrderDetail {
  orders: IOrders;
  food: Food;
  quantity: number;
}
