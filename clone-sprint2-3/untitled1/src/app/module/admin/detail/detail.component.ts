import {Component, OnInit} from '@angular/core';
import {FoodService} from '../../../service/food.service';
import {ToastrService} from 'ngx-toastr';
import {DataService} from '../../../service/data/data.service';
import {ActivatedRoute} from '@angular/router';
import {Food} from '../../../model/Food';
import {CartService} from '../../../service/cart/cart.service';
import {Cart} from '../../../model/Cart';
import {CartComponent} from '../cart/cart.component';
import {HeaderComponent} from '../../../layout/header/header.component';

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
              private cartService: CartService,
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

  addToCard(food: Food, quantity: number) {
    console.log("detail html"+food+ this.id);
    this.cartService.addToCart(food, quantity);
     this.toast.success('Thêm vào Giỏ Hàng Thành Công');
     this.getCart();
     this.sendNumberOfCartToHeader();
  }

  sendNumberOfCartToHeader() {
    this.cartService.changeNumberCart(this.cards.length);
  }

  // receiveDataFromFoodList() {
  //   this.cartService.currentNumberCart.subscribe(data => {
  //     this.numberOfCart = data;
  //
  //   });
  // }

  getCart() {
    this.cards = this.cartService.getItems();
    console.log("get cart localSto" + this.cards);
  }
}
