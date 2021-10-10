import { Component, OnInit } from '@angular/core';
import {CustomerType} from "../../../model/CustomerType";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../../model/Customer";
import {CustomerServiceService} from "../../customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerTypeService} from "../../customer-type.service";
import {Level} from "../../../model/Level";
import {Location} from "../../../model/Location";
import {Part} from "../../../model/Part";
import {EmployeeServiceService} from "../../employee-service.service";
import {LevelServiceService} from "../../level-service.service";
import {LocationServiceService} from "../../location-service.service";
import {PartServiceService} from "../../part-service.service";
import {Employee} from "../../../model/Employee";

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  id: number;
  levels: Level[];
  locations: Location[];
  parts: Part[];
  public employeeEditForm: FormGroup;
  public employeeEdit: Employee;

  constructor(private employeeServiceService: EmployeeServiceService, private router:Router ,
              private levelServiceService: LevelServiceService, private locationServiceService: LocationServiceService,
              private partServiceService: PartServiceService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getEmployee(this.id);
    })
  };

  ngOnInit(): void {
    this.getType();
  }
  getType() {
    this.levelServiceService.findAll().subscribe(data1=>{
      this.levels = data1
    });
    this.locationServiceService.findAll().subscribe(data2=>{
      this.locations = data2
    });
    this.partServiceService.findAll().subscribe(data3=>{
      this.parts = data3
    });

  };

  getEmployee(id: number) {
    return this.employeeServiceService.findById(id).subscribe(employee => {
      this.employeeEditForm = new FormGroup({
        id: new FormControl(employee.id),
        name: new FormControl(employee.name, Validators.required),
        dateOfBirth: new FormControl(employee.dateOfBirth, Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
        idCard: new FormControl(employee.idCard, Validators.compose([Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')])),
        salary: new FormControl(employee.salary, Validators.required),
        phone: new FormControl(employee.phone, Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')])),
        email: new FormControl(employee.email, Validators.compose([Validators.required, Validators.email])),
        address: new FormControl(employee.address, Validators.required),
        level: new FormControl(employee.level, Validators.required),
        part: new FormControl(employee.part, Validators.required),
        location: new FormControl(employee.location, Validators.required)
      });
      this.employeeEdit = employee[0];
      this.employeeEditForm.patchValue(this.employeeEdit);
      console.log(employee);
    })
  };

  validationMessageEdit = {
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

  }


  updateEmployee(id: number) {
    const employee = this.employeeEditForm.value
    this.employeeServiceService.updateEmployee(id, employee).subscribe(() => {
      this.router.navigateByUrl("/employee");
    })
  }

}
