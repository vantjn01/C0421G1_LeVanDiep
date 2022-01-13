import {Component, OnInit} from '@angular/core';
import {Cart} from '../../../entity/Cart';
import {CartService} from '../../../service/cart/cart.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {FoodService} from '../../../service/food.service';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {Orders} from '../../../entity/Orders';
import {OrderFood} from '../../../entity/OrderFood';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  username: string;
  orderFoods: any;

  constructor(private cartService: CartService,
              private toast: ToastrService,
              private router: Router,
              private foodService: FoodService,
              private tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
    this.username = this.tokenStorage.getUser().username;
    console.log(this.username);
    this.getTransactionCart();
  }

  getTransactionCart() {
    this.foodService.getTransaction(this.username).subscribe(data => {
      this.orderFoods = data;
      console.log(this.orderFoods);
      this.toast.success("Cập Nhật Thành Công","Lịch Sử Giỏ Hàng")
    });
  }
}
