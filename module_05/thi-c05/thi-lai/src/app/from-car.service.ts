import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FromCar} from "../../FromCar";

@Injectable({
  providedIn: 'root'
})
export class FromCarService {

  private api_url_customer_type = "http://localhost:3000/fromCar";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<FromCar[]> {
    return this.httpClient.get<FromCar[]>(this.api_url_customer_type);
  }
}
