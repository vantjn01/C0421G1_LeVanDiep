import { Injectable } from '@angular/core';
import {Cart} from "../entity/Cart";
import {ToastrService} from "ngx-toastr";
import {Food} from "../entity/Food";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  // private _cards: Food[] = [];
  _cards: Cart[] = [];
  cart: Cart;
  check: boolean = false;
  // @ts-ignore
  numberCart = new BehaviorSubject<number>(0);
  currentNumberCart = this.numberCart.asObservable();
  constructor( private toast: ToastrService) {
  }
  changeNumberCart(numberCart:number) {
    this.numberCart.next(numberCart);
  }
  getItems() {
    return this._cards = JSON.parse(<string> localStorage.getItem('Cart'));
  }

  // clearCart(foodId: number) {
  //   return localStorage.removeItem(foodId);
  // }

  addToCart(food: Food, quantity: number) {
    console.log("detail service "+food+ quantity);
    for (let i = 0; i < this._cards.length; i++) {
      if (this._cards[i].food.foodId == food.foodId) {
        this._cards[i].quantity += quantity;
        this.check=true;
      }
    }
    if(this.check==false){
      this._cards.push(new class implements Cart {
        food = food;
        quantity = quantity;
      });
    }
    localStorage.setItem('Cart', JSON.stringify(this._cards));
  }

  removeCartById() {
    localStorage.clear();
  }
}
