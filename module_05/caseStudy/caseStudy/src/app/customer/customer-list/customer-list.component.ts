import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../model/Customer";
import {CustomerServiceService} from "../../customer-service.service";
import {Router} from "@angular/router";



@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[]|any;
  customerParent: Customer| undefined;
  name: any;
  p: number = 1;

  constructor(private customerServiceService: CustomerServiceService, private router: Router) {
 this.customerServiceService.findAll().subscribe(next=> {
  this.customers = next;
  console.log(this.customers)
}, error => {

}, () => {

});
console.log(this.customers)
}
  showDetail(item:Customer) {
    this.customerParent = item; // gán.
  }

  ngOnInit(): void {
  }
  movePageCreateCustomer() {
    this.router.navigateByUrl("/customer/create")
  }

  Search() {
    if(this.name==""){
      this.ngOnInit();
    } else {
      this.customers = this.customers.filter(res=>{
        return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());

      })
    }

  }
  key: string = 'codeCustomer';
  reverse: boolean = false

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse

  }
}
