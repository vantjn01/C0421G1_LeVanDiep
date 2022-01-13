import {Component, OnInit} from '@angular/core';
import {Cart} from '../../../entity/Cart';
import {CartService} from '../../../service/cart/cart.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  cards: Cart[] = [];

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    this.getCart();
  }

  getCart() {
    this.cards = this.cartService.getItems();
    console.log('caaaaa=  ' + this.cards);
  }
}
