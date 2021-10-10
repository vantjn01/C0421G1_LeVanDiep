import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Location} from "../model/Location";
import {Part} from "../model/Part";

@Injectable({
  providedIn: 'root'
})
export class PartServiceService {

  private api_url_customer_type = "http://localhost:3000/part";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Part[]> {
    return this.httpClient.get<Part[]>(this.api_url_customer_type);
  }
}
