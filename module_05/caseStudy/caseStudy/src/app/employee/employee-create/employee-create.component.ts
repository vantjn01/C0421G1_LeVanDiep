import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../model/Customer";
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {CustomerType} from "../../../model/CustomerType";
import {CustomerServiceService} from "../../customer-service.service";
import {Router} from "@angular/router";
import {CustomerTypeService} from "../../customer-type.service";
import {Employee} from "../../../model/Employee";
import {Level} from "../../../model/Level";
import {Location} from "../../../model/Location";
import {Part} from "../../../model/Part";
import {EmployeeServiceService} from "../../employee-service.service";
import {LevelServiceService} from "../../level-service.service";
import {LocationServiceService} from "../../location-service.service";
import {PartServiceService} from "../../part-service.service";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  employee: Employee| undefined;
  employeeForm: FormGroup;
  // customerType: CustomerType[];
  level: Level[];
  location: Location[];
  part: Part[];

  constructor(private employeeServiceService: EmployeeServiceService, private router:Router ,
              private levelServiceService: LevelServiceService, private locationServiceService: LocationServiceService,
              private partServiceService: PartServiceService) {
    this.employeeForm= new FormGroup({
      id: new FormControl('',[Validators.required]),
      // codeCustomer: new FormControl('',Validators.compose([Validators.required,Validators.pattern('^KH-\\d{4}$')])),
      // customerType: new FormControl('',[Validators.required]),
      name: new FormControl('',[Validators.required]),
      level: new FormControl('',[Validators.required]),
      location: new FormControl('',[Validators.required]),
      part: new FormControl('',[Validators.required]),
      dateOfBirth: new FormControl('',Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
      idCard: new FormControl('',[Validators.required,Validators.pattern('^\\d{9}|\\d{12}$')]),
      salary: new FormControl('',[Validators.required]),
      phone: new FormControl('',[Validators.required,Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')]),
      email: new FormControl('',[Validators.required,Validators.email]),
      address: new FormControl('',[Validators.required])

    })
  };
  validationMessage = {
    id: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    // codeCustomer:[
    //   {type: 'required', message:'<= Vui long nhap'},
    //   {type: 'pattern', message:'<= Sai dinh dang'}
    // ],
    // customerType: [
    //   {type: 'required', message: '<= Vui long nhap.'},
    // ],
    dateOfBirth: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message:'<= Sai dinh dang'}
    ],
    name: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],
    level: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    location: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    part: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    idCard: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    salary: [
      {type: 'required', message: '<- Vui long nhap.'},
      // {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    phone: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    email: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'email', message: '<- Sai định dạng.'},
    ],
    address: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],

  };


  ngOnInit(): void {
    this.getType()
  }

  getType(){
    this.levelServiceService.findAll().subscribe(data1=>{
      this.level = data1
    });
    this.locationServiceService.findAll().subscribe(data2=>{
      this.location = data2
    });
    this.partServiceService.findAll().subscribe(data3=>{
      this.part = data3
    });

  }

  // createCustomer(name: string, gender: string, point: string) {
  //   //gán giá trị cho object student
  //   // this.student = {name: name, gender: parseInt(gender), point: parseInt(point)};
  //   // console.log(this.student);
  // }
  createEmployeeTemplateDrivenForm(registerForm: NgForm) {
    if (registerForm.value.name == "") {
      alert("name không được để trống")
    }
    console.log(registerForm)
  }

  createEmployeeReactiveForms() {
    console.log(this.employeeForm);
    //valid : true nếu validate đúng. flase nếu validate còn có lỗi
    //invalid: true nếu validate còn có lỗi. false nếu validate đúng
    this.employeeServiceService.createEmployee(this.employeeForm.value).subscribe(next => {
      this.router.navigateByUrl("/employee")
    })

  }
}
