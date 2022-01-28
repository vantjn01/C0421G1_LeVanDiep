import {Component, DoCheck, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart/cart.service';
import {Cart} from '../../../model/Cart';
import {ToastrService} from 'ngx-toastr';
import {PaymentService} from '../../../service/payment/payment.service';
import {Router} from '@angular/router';
import {HeaderComponent} from '../../../layout/header/header.component';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cards: Cart[]=[];
  numberCart: any;
  totalMoney: number = 0;
  imageCartEmpty='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSs9WG8Ggi4MCejzhZ5O0eECAYdUz67MxqCiA&usqp=CAU';


  constructor(private cartService: CartService,
              private toast: ToastrService,
              private paymentService: PaymentService,
              private router: Router) {
  }


  ngOnInit(): void {
    this.getCart();
    this.sendNumberOfCartToHeader();
    this.totalMoneyOfFood();
  }

  sendNumberOfCartToHeader() {
    this.cartService.changeNumberCart(this.cards.length);
  }

  getCart() {
    this.cards = this.cartService.getItems();
    console.log('caaaaa=  ' + this.cards);
  }

  deleteOrderFood() {
    this.cartService.removeCartById();
    this.toast.success("Hủy Giỏ Hàng Thành Công")
    this.getCart();
    this.totalMoney=0;
    this.cards.length=0;
  }

  totalMoneyOfFood() {
    console.log(this.cards);
    for (let i = 0; i < this.cards.length; i++) {
      this.totalMoney +=this.cards[i].food.foodPrice*this.cards[i].quantity;
    }
  }
  showInfoView() {

  }

  payPal(totalMoney: any) {
    localStorage.setItem("orderId", String(this.cards));
    this.paymentService.payment(totalMoney).subscribe(value => {
      console.log(value)
      // window.open(value.link)
      // @ts-ignore
      window.location.href = value.link;
    })
  }
}
