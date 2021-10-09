import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../../../../model/Customer";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {CustomerServiceService} from "../../../customer-service.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {


  @Input("customerChild") customerDetail: Customer;

  constructor() { }

  ngOnInit(): void {
  }


}
