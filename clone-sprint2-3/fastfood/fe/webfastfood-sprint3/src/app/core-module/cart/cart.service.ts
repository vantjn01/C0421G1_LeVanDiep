import { Injectable } from '@angular/core';
import {IOrderDetail} from "../../entity/IOrderDetail";
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Cart} from "../../entity/Cart";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  qty: number = 1;
  public cartItemList: IOrderDetail | any = [];
  public productList = new BehaviorSubject<any>([]);
  private urlFindCustomer = "http://localhost:8080/api/order-detail/list/customer";
  private urlCreateCart = "http://localhost:8080/api/order-detail/create";

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

  getProduct() {
    return this.productList.asObservable();
  }

  setProduct(product: any) {
    this.cartItemList.push(...product);
    this.productList.next(product);
  }

  addToCard(product: any) {

    this.getTotalPrice();

    let check: boolean = true;
    for (let i in this.cartItemList) {
      console.log(this.cartItemList[i].fadName);
      if (this.cartItemList[i].fadName == product.fadName) {
        product.quantity++;
        product.totalDetailCart += product.fadPrice;
        console.log("hello")
        check = false;
      }
    }
    if (check) {
      product.quantity = 1;
      product.totalDetailCart = product.fadPrice;
      this.cartItemList.push(product);
      this.productList.next(this.cartItemList);

    }
  }

  getTotalPrice(): any {
    let grandTotal = 0;
    for (let i in this.cartItemList) {
      grandTotal += this.cartItemList[i].totalDetailCart;
    }

    console.log(grandTotal);
    return grandTotal;
  }

  removeCart(product: any) {
    for (let i in this.cartItemList) {
      if (this.cartItemList[i].fadId == product.fadId) {
        this.cartItemList.splice(i, 1);
      }
    }
  }

  getOrderDetailCustomer(): Observable<IOrderDetail | any> {
    return this.http.get(this.urlFindCustomer);
  }

  createCart(cart: IOrderDetail): Observable<IOrderDetail | any> {
    return this.http.post(this.urlCreateCart, cart);
  }
}
