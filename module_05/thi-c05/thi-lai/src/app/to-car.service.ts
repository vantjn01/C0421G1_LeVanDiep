import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FromCar} from "../../FromCar";
import {ToCar} from "../../ToCar";

@Injectable({
  providedIn: 'root'
})
export class ToCarService {

  private api_url = "http://localhost:3000/toCar";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<ToCar[]> {
    return this.httpClient.get<ToCar[]>(this.api_url);
  }
}
