import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {ICustomer} from "../../entity/ICustomer";
import {StorageService} from "../account/storage.service";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private httpOptions;
  constructor(private http: HttpClient, private storageService: StorageService) {
    // this.httpOptions ={
    //   headers: new HttpHeaders({'Content-Type': 'application/json', 'Authorization': 'DUNG ' + `${this.storageService.getToken()}`}),
    //   'Access-Control-Allow-Origin': 'http://localhost:4200',
    //   'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    // }
  }


}
