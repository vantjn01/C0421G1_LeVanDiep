import { Component, OnInit } from '@angular/core';
import {Food} from "../../../entity/Food";
import {FoodService} from "../../../core-module/food/food.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail-food',
  templateUrl: './detail-food.component.html',
  styleUrls: ['./detail-food.component.css']
})
export class DetailFoodComponent implements OnInit {
  detail!: Food;
  idParam!: number;
  foodRandome!: Food[];

  constructor(private foodService: FoodService, private active: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getByIdDetail();
    this.getRandome();
  }

  getByIdDetail() {
    this.active.params.subscribe(data => {
      this.idParam = data['id'];
      console.log(this.idParam);
      this.foodService.getByIdFood(this.idParam).subscribe(next => {
        this.detail = next;
        console.log(this.detail);
      })
    })
  }

  getRandome() {
    this.foodService.getRandomeFour().subscribe(data => {
      this.foodRandome = data;
    })
  }

}
