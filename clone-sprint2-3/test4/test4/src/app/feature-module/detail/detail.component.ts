import { Component, OnInit } from '@angular/core';
import {Food} from "../../entity/Food";
import {Cart} from "../../entity/Cart";
import {FoodService} from "../../core-module/food.service";
import {ActivatedRoute} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  food: Food;
  id: number;
  numberOfCart: number = 0;
  quantity: number = 1;
  cards: Cart[] = [];

  constructor(private foodService: FoodService,
              private activatedRoute: ActivatedRoute,
              // private cartService: CartService,
              private toast: ToastrService
  ) {
    this.id = Number(this.activatedRoute.snapshot.params.id);
  }

  ngOnInit(): void {
    this.getFoodById();
  }

  getFoodById() {
    console.log('this.id=' + this.id);
    this.foodService.getFoodById(this.id).subscribe(data => {
      this.food = data;
      console.log(this.food);
    }, error => {
      console.log('GetInfoFood' + error + 'BackEnd');
    });
  }

  incrementQuantity() {
    this.quantity++;
  }

  decrementQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
  }

  // addToCard(food: Food, quantity: number) {
  //   console.log("detail html"+food+ this.id);
  //   this.cartService.addToCart(food, quantity);
  //   this.toast.success('Thêm vào Giỏ Hàng Thành Công');
  //   this.getCart();
  //   this.sendNumberOfCartToHeader();
  // }
  //
  // sendNumberOfCartToHeader() {
  //   this.cartService.changeNumberCart(this.cards.length);
  // }

  // receiveDataFromFoodList() {
  //   this.cartService.currentNumberCart.subscribe(data => {
  //     this.numberOfCart = data;
  //
  //   });
  // }

  // getCart() {
  //   this.cards = this.cartService.getItems();
  //   console.log("get cart localSto" + this.cards);
  // }

}
