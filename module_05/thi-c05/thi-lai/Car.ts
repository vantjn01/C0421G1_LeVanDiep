import {FromCar} from "./FromCar";
import {ToCar} from "./ToCar";

export interface Car {
  id: number;
  numberCar: number;
  typeCar: string;
 nameCar: string;
  fromCar: any;
  toCar: any;
  phone: string;
  email: string;
  fromHour: string;
  toHour: string;
}
