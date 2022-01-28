import { Component, OnInit } from '@angular/core';
import {IOrderDetail} from "../../entity/IOrderDetail";
import {Food} from "../../entity/Food";
import {CartService} from "../../core-module/cart/cart.service";
import {FoodService} from "../../core-module/food/food.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


  productCart: any
  listOrder!: IOrderDetail [];
  food!: Food [];
  public products: any;
  public grandTotal: number = 0;

  constructor(private cartService: CartService, private foodService: FoodService) {
  }

  ngOnInit(): void {
    this.getAllFood();
    this.getCard();

    this.cartService.getProduct().subscribe(data => {
      this.products = data;
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }

  getAllFood() {
    this.foodService.getAllFood().subscribe(data => {
      this.food = data;
      // console.log(this.food)
    })
  }

  getCard() {
    this.cartService.getOrderDetailCustomer().subscribe(data => {
      this.productCart = data;
      this.listOrder = data;
    })
  }

  createCart(product: any) {
    this.cartService.createCart(product).subscribe(next => {
    })
  }


  removeCart(product: any) {
    this.cartService.removeCart(product);
  }

}
