import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Employee} from "../../../model/Employee";
import {EmployeeServiceService} from "../../employee-service.service";

@Component({
  selector: 'app-emloyee-list',
  templateUrl: './emloyee-list.component.html',
  styleUrls: ['./emloyee-list.component.css']
})
export class EmloyeeListComponent implements OnInit {

  employees: Employee[]|any;
  employeeParent: Employee| undefined;
  name: any;
  p: number = 1;

  constructor(private employeeServiceService: EmployeeServiceService, private router: Router) {
    this.employeeServiceService.findAll().subscribe(next=> {
      this.employees = next;
      console.log(this.employees)
    }, error => {

    }, () => {

    });
    console.log(this.employees)
  }
  showDetail(item:Employee) {
    this.employeeParent = item; // gán.
  }

  ngOnInit(): void {
  }
  movePageCreateEmployee() {
    this.router.navigateByUrl("/employee/create")
  }

  Search() {
    if(this.name==""){
      this.ngOnInit();
    } else {
      this.employees = this.employees.filter(res=>{
        return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());

      })
    }

  }
  key: string = 'name';
  reverse: boolean = false

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse

  }

}
