import {Component, OnInit} from '@angular/core';
import {CustomerType} from "../../../model/CustomerType";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../../model/Customer";
import {CustomerServiceService} from "../../customer-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerTypeService} from "../../customer-type.service";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  id: number;
  customerTypes: CustomerType[];
  public customerEditForm: FormGroup;
  public customerEdit: Customer;

  constructor(private customerService: CustomerServiceService, private activatedRoute: ActivatedRoute,
              private customerTypeService: CustomerTypeService, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    })
  };

  ngOnInit(): void {
    this.getType();
  }
  getType() {
    this.customerTypeService.findAll().subscribe(data => {
      this.customerTypes = data;
    });
  };

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      this.customerEditForm = new FormGroup({
        id: new FormControl(customer.id),
        codeCustomer: new FormControl(customer.codeCustomer),
        dateOfBirth: new FormControl(customer.dateOfBirth, Validators.compose([Validators.required, Validators.pattern('^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$')])),
        name: new FormControl(customer.name, Validators.required),
        identityCard: new FormControl(customer.identityCard, Validators.compose([Validators.required, Validators.pattern('^\\d{9}|\\d{12}$')])),
        phone: new FormControl(customer.phone, Validators.compose([Validators.required, Validators.pattern('^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$')])),
        mail: new FormControl(customer.mail, Validators.compose([Validators.required, Validators.email])),
        address: new FormControl(customer.address, Validators.required),
        customerType: new FormControl(customer.customerType, Validators.required)
      });
      this.customerEdit = customer[0];
      this.customerEditForm.patchValue(this.customerEdit);
      console.log(customer);
    })
  };

  validationMessageEdit = {
    idCustomer: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    codeCustomer: [
      {type: 'required', message: '<= Vui long nhap'},
      {type: 'pattern', message: '<= Sai dinh dang'}
    ],
    customerType: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    dateOfBirth: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<= Sai dinh dang'}
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






  }

  updateCustomer(id: number) {
    const customer = this.customerEditForm.value;
    this.customerService.updateCustomer(id, customer).subscribe(() => {
      this.router.navigateByUrl("/customer");
    })
  }
}

