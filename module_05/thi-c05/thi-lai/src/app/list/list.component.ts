import { Component, OnInit } from '@angular/core';
import {Car} from "../../../Car";
import {Router} from "@angular/router";
import {CarServiceService} from "../car-service.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  cars: Car[]|any;
  carParent: Car| undefined;
  nameCar: any;
  p: number = 1;

  constructor(private carServiceService: CarServiceService, private router: Router) {
    this.carServiceService.findAll().subscribe(next=> {
      this.cars = next;
      console.log(this.cars)
    }, error => {

    }, () => {

    });
    console.log(this.cars)
  }
  showDetail(item:Car) {
    this.carParent = item; // gán.
  }

  ngOnInit(): void {
  }
  movePageCreateCar() {
    this.router.navigateByUrl("/car/create")
  }

  Search() {
    if(this.nameCar==""){
      this.ngOnInit();
    } else {
      this.cars = this.cars.filter(res=>{
        return res.nameCar.toLocaleLowerCase().match(this.nameCar.toLocaleLowerCase());

      })
    }

  }
  key: string = 'nameCar';
  reverse: boolean = false

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse

  }

}
