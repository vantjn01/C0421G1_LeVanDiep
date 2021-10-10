import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../model/Employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private api_url_customer = "http://localhost:3000/employee";
  employees: Employee[];

  constructor(private httpClient: HttpClient) { }
  findAll():Observable<Employee[]|any>{
    return this.httpClient.get( this.api_url_customer)
  }
  createEmployee(employee):Observable<Employee> {
    return this.httpClient.post<Employee>(this.api_url_customer, employee);
  }
  findById(id: number| null) : Observable<Employee|any> {
    return this.httpClient.get<Employee>(this.api_url_customer + "?id=" + id);
  }
  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(this.api_url_customer + "/" + id, employee);
  }
  deleteEmployee(id: number): Observable<Employee> {
    return this.httpClient.delete<Employee>(this.api_url_customer + "/" + id)

  }
}
