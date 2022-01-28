import {TypeFood} from './TypeFood';
import {StatusFood} from './StatusFood';

export interface Food {
  foodId: number;
  foodName: string;
  foodPrice: number;
  description_food: string;
  flag: number;
  address: string;
  dateCreate: string;
  typeFood: TypeFood;
  statusFood: StatusFood;
  image: string;
}
