import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HomeComponent} from '../home/home.component';
import {DataService} from '../../service/data/data.service';
import {CartService} from '../../service/cart/cart.service';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {AuthService} from '../../service/security/auth.service';
import Swal from 'sweetalert2';
import {Cart} from '../../entity/Cart';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  defaultImgUrl = 'https://previews.123rf.com/images/marylia17/marylia171701/marylia17170100023/69256309-vector-fastfood-restaurant-cafe-colorful-logo-burger-fried-potatoes.jpg?fj=1';
  keySearch: string = '';
  page = 0;
  numberOfCart: number;
  carts: any;

  private roles: string[];
  isLogged = false;
  username: string;
  image: string;
  private Swal: any;

  role: string;
  showUserBoard = false;
  showAdminBoard = false;
  showCartBoard= true;

  constructor(private router: Router,
              private homeComponent: HomeComponent,
              private data: DataService,
              private cartService: CartService,
              private tokenStorageService: TokenStorageService,
              private authService: AuthService
  ) {
  }

  ngOnInit(): void {
    this.receiveDataFromFoodList();
    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.isLogged = !!this.tokenStorageService.getToken();
      this.roles = user.roles;
      this.username = user.username;
      this.showUserBoard = this.roles.includes('ROLE_USER');
    }
    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      if (this.roles.includes('ROLE_ADMIN')) {
        this.showAdminBoard = true;
      }
      if (this.roles.includes('ROLE_ADMIN') || this.roles.includes('ROLE_USER')){
        this.showCartBoard = true;
      }
    }
  }

  logout() {
    Swal.fire({
      title: 'Đăng xuất với tên ' + this.username + ' ?',
      // icon: 'info',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý',
      cancelButtonText: 'Hủy',
      allowOutsideClick: false,
      // confirmButtonColor: '#DD6B55',
      // cancelButtonColor: '#768394'
    }).then((result) => {
      if (result.value) {
        this.authService.logout(this.tokenStorageService.getUser().username).subscribe();
        this.tokenStorageService.signOut();
        window.location.href = 'http://localhost:4200';
      } else if (result.dismiss === this.Swal.DismissReason.cancel) {
      }
    });
  }

  receiveDataFromFoodList() {
    this.cartService.currentNumberCart.subscribe(data => {
      this.numberOfCart = data;
    });
  }

  search() {
    console.log(this.keySearch);
    this.data.changeKeySearch(this.keySearch);
  }

  setPage() {
    this.data.changeNumberPage(this.page);
  }
}
