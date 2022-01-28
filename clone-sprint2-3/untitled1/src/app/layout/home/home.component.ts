import {Component, Injectable, Input, OnInit} from '@angular/core';
import {FoodService} from '../../service/food.service';
import {ToastrService} from 'ngx-toastr';
import {DataService} from '../../service/data/data.service';
import {CartService} from '../../service/cart/cart.service';
import {Cart} from '../../model/Cart';

@Injectable({
  providedIn: 'root'
})

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  cards: Cart[]=[];
  food: any;
  foodList: any;
  keySearch = '';
  totalPage = 0;
  page = 0;

  constructor(private foodService: FoodService,
              private toast: ToastrService,
              private cartService: CartService,
              private data: DataService
  ) {
  }

  ngOnInit(): void {
    this.getFoodList();
    this.getDataKeySearch();
  }

  getFoodList() {
    this.foodService.getFoodList(this.page).subscribe(data => {
      console.log('list=  ' + data);
      this.foodList = data.content;
      this.totalPage = data.totalPages;
      console.log('page=  ' + this.page);
      this.page = data.number
    }, error => {
    });
  }

  searchFoodList() {
    this.page=0;
    this.foodService.searchFoodList(this.keySearch,this.page).subscribe(data => {
      this.foodList = data;
      console.log(this.foodList);
      this.totalPage = data.totalPages;
    }, error => {
    });
  }

  getDataKeySearch() {
    this.data.currentKeySearch.subscribe(data => {
      // @ts-ignore
      this.keySearch = data;
      this.searchFoodList();
    });
  }

  // getDataNumberPage() {
  //   this.data.currentNumberPage.subscribe(data => {
  //     this.page=data;
  //   });
  // }

  // upPage() {
  //   this.page += 4;
  //   this.getFoodList();
  // }
  previousPage() {
    if (this.page > 0) {
      this.page--;
    } else {
      this.page = 0;
    }
    this.getFoodList();
  }

  nextPage() {
    if (this.page < this.totalPage - 1) {
      this.page++;
    }
    this.getFoodList();
  }

  toPage(number: number) {

  }

  addToCard(food: any) {
  }

}
