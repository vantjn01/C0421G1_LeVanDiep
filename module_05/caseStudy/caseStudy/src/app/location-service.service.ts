import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Level} from "../model/Level";
import {Location} from "../model/Location";

@Injectable({
  providedIn: 'root'
})
export class LocationServiceService {

  private api_url_customer_type = "http://localhost:3000/location";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Location[]> {
    return this.httpClient.get<Location[]>(this.api_url_customer_type);
  }
}
