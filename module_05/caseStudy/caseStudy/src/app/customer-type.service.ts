import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerType} from "../model/CustomerType";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  private api_url_customer_type = "http://localhost:3000/customerType";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.api_url_customer_type);
  }
}
