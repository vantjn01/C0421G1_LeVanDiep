import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Level} from "../model/Level";

@Injectable({
  providedIn: 'root'
})
export class LevelServiceService {

  private api_url_customer_type = "http://localhost:3000/level";

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Level[]> {
    return this.httpClient.get<Level[]>(this.api_url_customer_type);
  }
}
