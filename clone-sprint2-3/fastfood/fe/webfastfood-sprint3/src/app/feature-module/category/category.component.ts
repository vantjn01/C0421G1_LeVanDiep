import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../../core-module/category/category.service";
import {FoodService} from "../../core-module/food/food.service";
import {MatDialog} from "@angular/material/dialog";
import {Food} from "../../entity/Food";
import {ICategory} from "../../entity/ICategory";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categoryList!: ICategory [];
  food!: Food [] | any;

  constructor(private categoryService: CategoryService, private dialog: MatDialog, private foodService: FoodService, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.categoryService.getAllCategory().subscribe(data => {
      this.categoryList = data;

    })
  }

}
