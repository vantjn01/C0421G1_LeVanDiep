import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {StorageService} from "../account/storage.service";


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private httpOptions;
  private httpOptions2;

  constructor(private http: HttpClient, private storageService: StorageService) {
    // this.httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //     'Authorization': 'DUNG ' + `${this.storageService.getToken()}`
    //   }),
    //   'Access-Control-Allow-Origin': 'http://localhost:4200',
    //   'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    // };
    //
    // this.httpOptions2 = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json'
    //   }),
    //   'Access-Control-Allow-Origin': 'http://localhost:4200',
    //   'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    // }
  }


}
