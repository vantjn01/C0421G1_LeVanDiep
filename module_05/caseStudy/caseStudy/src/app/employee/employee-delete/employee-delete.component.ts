import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {EmployeeServiceService} from "../../employee-service.service";
import {Employee} from "../../../model/Employee";

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  id: number;
  employeeDelete: Employee;

  constructor(private employeeService: EmployeeServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      this.getEmployee(this.id);
    })
  }

  ngOnInit(): void {
  }

  getEmployee(id: number) {
    return this.employeeService.findById(id).subscribe(employee => {
      this.employeeDelete = employee[0];
    });
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(() => {
      this.router.navigate(['/employee']);
    }, e => {
      console.log(e);
    });
  }

}
