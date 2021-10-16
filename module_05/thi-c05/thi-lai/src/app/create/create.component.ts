import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {Car} from "../../../Car";
import {Router} from "@angular/router";
import {FromCar} from "../../../FromCar";
import {ToCar} from "../../../ToCar";
import {CarServiceService} from "../car-service.service";
import {FromCarService} from "../from-car.service";
import {ToCarService} from "../to-car.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  car: Car | undefined;
  carForm: FormGroup;
  fromCar: FromCar[];
  toCar: ToCar[];

  constructor(private carServiceService: CarServiceService, private router: Router,
              private fromCarService: FromCarService, private toCarService: ToCarService) {
    this.carForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      numberCar: new FormControl('', Validators.compose([Validators.required])),
      typeCar: new FormControl('', [Validators.required]),
      nameCar: new FormControl('', [Validators.required]),
      fromCar: new FormControl('', Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
      toCar: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^090\\d{7}|093\\d{7}|097\\d{7}$')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      fromHour: new FormControl("", Validators.compose([Validators.required, this.checkDate])),
      toHour: new FormControl("", Validators.compose([Validators.required, this.checkDate])),
    })
  };

  checkDate(abstractControl: AbstractControl): any {
    const hour = abstractControl.value;
    const legalHour1 = "23:00";
    const legalHour2 = "05:00";
    console.log(hour);

    return hour >= legalHour2 && hour <= legalHour1 ? null : {checkDate: true};
  }

  validationMessage = {
    id: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    numberCar: [
      {type: 'required', message: '<= Vui long nhap'},
    ],
    typeCar: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    nameCar: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],
    fromCar: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],
    toCar: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],
    phone: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    email: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'email', message: '<- Sai định dạng.'},
    ],
    fromHour: [
      {type: 'required', message: '<= Please input.'},
      {type: 'checkDate', message: '<= Nhap giua 05:00 va 23:00'},
    ],
    toHour: [
      {type: 'required', message: '<= Please input.'},
      {type: 'checkDate', message: '<= Nhap giua 05:00 va 23:00'},
    ]

  };


  ngOnInit(): void {
    this.getType()
  }

  getType() {
    this.fromCarService.findAll().subscribe(data => {
      this.fromCar = data
    });
    this.toCarService.findAll().subscribe(data1 => {
      this.toCar = data1
    });
  }

  // createCustomer(name: string, gender: string, point: string) {
  //   //gán giá trị cho object student
  //   // this.student = {name: name, gender: parseInt(gender), point: parseInt(point)};
  //   // console.log(this.student);
  // }
  createCarTemplateDrivenForm(registerForm: NgForm) {
    if (registerForm.value.name == "") {
      alert("name không được để trống")
    }
    console.log(registerForm)
  }

  createCarReactiveForms() {
    console.log(this.carForm);
    //valid : true nếu validate đúng. flase nếu validate còn có lỗi
    //invalid: true nếu validate còn có lỗi. false nếu validate đúng
    this.carServiceService.createCar(this.carForm.value).subscribe(next => {
      this.router.navigateByUrl("/car")
    })

  }

}
