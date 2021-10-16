import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Car} from "../../Car";

@Injectable({
  providedIn: 'root'
})
export class CarServiceService {

  private api_url_customer = "http://localhost:3000/car";
  cars: Car[];

  constructor(private httpClient: HttpClient) { }
  findAll():Observable<Car[]|any>{
    return this.httpClient.get( this.api_url_customer)
  }
  createCar(car):Observable<Car> {
    return this.httpClient.post<Car>(this.api_url_customer, car);
  }

  findById(id: number| null) : Observable<Car|any> {
    return this.httpClient.get<Car>(this.api_url_customer + "?id=" + id);
  }
  updateCar(id: number, car: Car): Observable<Car> {
    return this.httpClient.put<Car>(this.api_url_customer + "/" + id, car);
  }
  deleteCar(id: number): Observable<Car> {
    return this.httpClient.delete<Car>(this.api_url_customer + "/" + id)

  }
}
