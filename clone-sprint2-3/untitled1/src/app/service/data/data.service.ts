import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  keySearch = new BehaviorSubject<String>('');
  numberPage = new BehaviorSubject<number>(0);
  currentKeySearch = this.keySearch.asObservable();
  currentNumberPage = this.numberPage.asObservable();


  constructor() {
  }

  changeKeySearch(keySearch) {
    this.keySearch.next(keySearch);
  }
  changeNumberPage(numberPage) {
    this.numberPage.next(numberPage);
  }
}
