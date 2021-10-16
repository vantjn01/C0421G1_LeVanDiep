import { Component, OnInit } from '@angular/core';
import {Car} from "../../../Car";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CarServiceService} from "../car-service.service";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  id: number;
  carDelete: Car;

  constructor(private carServiceService: CarServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      this.getCar(this.id);
    })
  }

  ngOnInit(): void {
  }

  getCar(id: number) {
    return this.carServiceService.findById(id).subscribe(car => {
      this.carDelete = car[0];
    });
  }

  deleteCar(id: number) {
    this.carServiceService.deleteCar(id).subscribe(() => {
      this.router.navigate(['/car']);
    }, e => {
      console.log(e);
    });
  }

}
