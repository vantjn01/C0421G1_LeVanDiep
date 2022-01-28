import { Pipe, PipeTransform } from '@angular/core';
import {Food} from "../../model/Food";

@Pipe({
  name: 'sort'
})
export class SortPipe implements PipeTransform {

  transform(value: Array<Food>, args: any[]): any {
    const sortFill = args[0];
    const sortDirection = args[1];

    let multiplier = 1;
    if (sortDirection === 'desc') {
      multiplier = -1;
    }

    value.sort((a: any, b:any) =>{
      if (a[sortFill] < b[sortFill]) {
        return -1 * multiplier;
      } else if (a[sortFill] > b[sortFill]) {
        return 1 * multiplier;
      } else {
        return 0;
      }
    })
    return value;
  }
}
