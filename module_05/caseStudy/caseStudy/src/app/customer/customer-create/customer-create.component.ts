import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../model/Customer";
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {CustomerServiceService} from "../../customer-service.service";
import {Router} from "@angular/router";
import {CustomerType} from "../../../model/CustomerType";
import {CustomerTypeService} from "../../customer-type.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customer: Customer| undefined;
  customerForm: FormGroup;
  customerType: CustomerType[];

  constructor(private customerServiceService: CustomerServiceService, private router:Router , private customerTypeService: CustomerTypeService) {
    this.customerForm= new FormGroup({
      idCustomer: new FormControl('',[Validators.required]),
      codeCustomer: new FormControl('',Validators.compose([Validators.required,Validators.pattern('^KH-\\d{4}$')])),
      customerType: new FormControl('',[Validators.required]),
      name: new FormControl('',[Validators.required]),
      dateOfBirth: new FormControl('',Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
      identityCard: new FormControl('',[Validators.required,Validators.pattern('^\\d{9}|\\d{12}$')]),
      phone: new FormControl('',[Validators.required,Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')]),
      mail: new FormControl('',[Validators.required,Validators.email]),
      address: new FormControl('',[Validators.required])

    })
  };
  validationMessage = {
    idCustomer: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    codeCustomer:[
      {type: 'required', message:'<= Vui long nhap'},
      {type: 'pattern', message:'<= Sai dinh dang'}
    ],
    customerType: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    dateOfBirth: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message:'<= Sai dinh dang'}
    ],
    name: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],
    identityCard: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    phone: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- Sai định dạng.'},
    ],
    mail: [
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
    this.customerTypeService.findAll().subscribe(data=>{
      this.customerType = data
    })
  }

  // createCustomer(name: string, gender: string, point: string) {
  //   //gán giá trị cho object student
  //   // this.student = {name: name, gender: parseInt(gender), point: parseInt(point)};
  //   // console.log(this.student);
  // }
  createCustomerTemplateDrivenForm(registerForm: NgForm) {
    if (registerForm.value.name == "") {
      alert("name không được để trống")
    }
    console.log(registerForm)
  }

  createCustomerReactiveForms() {
    console.log(this.customerForm);
    //valid : true nếu validate đúng. flase nếu validate còn có lỗi
    //invalid: true nếu validate còn có lỗi. false nếu validate đúng
      this.customerServiceService.createCustomer(this.customerForm.value).subscribe(next => {
        this.router.navigateByUrl("/customer")
    })

  }

}
