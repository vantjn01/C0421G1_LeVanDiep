import { Injectable } from '@angular/core';
import {Customer} from "../model/Customer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private api_url_customer = "http://localhost:3000/customer";
  customers: Customer[];

  constructor(private httpClient: HttpClient) { }
  findAll():Observable<Customer[]|any>{
    return this.httpClient.get( this.api_url_customer)
  }
  createCustomer(customer):Observable<Customer> {
    return this.httpClient.post<Customer>(this.api_url_customer, customer);
  }
  findById(id: number| null) : Observable<Customer|any> {
    return this.httpClient.get<Customer>(this.api_url_customer + "?id=" + id);
  }
  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.api_url_customer + "/" + id, customer);
  }
  deleteCustomer(id: number): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.api_url_customer + "/" + id)

  }
}
