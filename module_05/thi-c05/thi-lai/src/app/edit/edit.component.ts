import { Component, OnInit } from '@angular/core';
import {FromCar} from "../../../FromCar";
import {ToCar} from "../../../ToCar";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CarServiceService} from "../car-service.service";
import {Car} from "../../../Car";
import {FromCarService} from "../from-car.service";
import {ToCarService} from "../to-car.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  id: number;
  fromCars: FromCar[];
  toCars: ToCar[];
  public carEditForm: FormGroup;
  public carEdit: Car;

  constructor(private carService: CarServiceService, private activatedRoute: ActivatedRoute,
              private fromCarService: FromCarService, private router: Router,
              private toCarService: ToCarService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getType();
      this.getCar(this.id);
      // console.log(this.carEditForm.controls.fromCar.value.nameFromCar)
    })
  };

  ngOnInit(): void {
    this.getType();
  }
  getType() {
    this.fromCarService.findAll().subscribe(data => {
      this.fromCars = data;
    });
    this.toCarService.findAll().subscribe(data1 =>{
      this.toCars = data1;
    })
  };

  getCar(id: number) {
    return this.carService.findById(id).subscribe(car => {
      this.carEditForm = new FormGroup({
        id: new FormControl(car.id),
        numberCar: new FormControl(car.numberCar),
        nameCar: new FormControl(car.nameCar, Validators.required),
       fromCar: new FormControl(car.fromCar),
       toCar: new FormControl(car.toCar),
        typeCar: new FormControl(car.typeCar, Validators.required),
        phone: new FormControl(car.phone, Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|093\\d{7}|097\\d{7}$')])),
        email: new FormControl(car.email, Validators.compose([Validators.required, Validators.email])),
        fromHour: new FormControl(car.fromHour, Validators.compose([Validators.required, this.checkDate])),
        toHour: new FormControl(car.toHour, Validators.compose([Validators.required, this.checkDate])),
      });
      this.carEdit = car[0];
      this.carEditForm.patchValue(this.carEdit);
      console.log(car);
    })
  };
  checkDate(abstractControl: AbstractControl): any {
    const hour = abstractControl.value;
    const toNum = hour;
    const legalHour1 = 23.00;
    const legalHour2 = 5.00;
    console.log(hour);
    console.log(toNum);

    return toNum > legalHour2 && toNum < legalHour1  ? null : {checkDate: true};
  };

  validationMessageEdit = {
    nameCar: [
      {type: 'required', message: '<= Vui long nhap'},
    ],
    typeCar: [
      {type: 'required', message: '<= Vui long nhap'},
    ],
    phone: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<= Sai dinh dang'}
    ],
    email: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    fromHour: [
      {type: 'required', message: '<= Vui long nhap.'},
      {type: 'checkDate', message: '<= Nhap giua 5:00 va 23:00'},
    ],
    toHour: [
      {type: 'required', message: '<= Vui long nhap.'},
      {type: 'checkDate', message: '<= Nhap giua 5:00 va 23:00'},
    ]
  }

  updateCar(id: number) {
    const car = this.carEditForm.value;
    this.carService.updateCar(id, car).subscribe(() => {
      this.router.navigateByUrl("/car");
    })
    console.log(car)
  }

}
