import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../../../../model/Customer";
import {Employee} from "../../../../model/Employee";

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {
  @Input("employeeChild") employeeDetail: Employee;

  constructor() { }

  ngOnInit(): void {
  }

}
