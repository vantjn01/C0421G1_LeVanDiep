import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TokenStorageService} from '../security/token-storage.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private API_URL_PAYMENT = 'http://localhost:8080/pay';
  private API_URL_SUCCESS = 'http://localhost:8080/success';

  httpOptions: any;

  constructor(public httpClient: HttpClient, private tokenStorage: TokenStorageService) {
    this.httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json', Authorization: `Bearer ` + this.tokenStorage.getToken()})
      , 'Access-Control-Allow-Origin': 'http://localhost:4200', 'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  payment(price: any): Observable<any> {
    return this.httpClient.get<any>(this.API_URL_PAYMENT + '?price=' + price, this.httpOptions);
  }

  successPayment(paymentId: string, PayerID: string): Observable<any> {
    return this.httpClient.get<any>(this.API_URL_SUCCESS + '?paymentId=' + paymentId + '&PayerID=' + PayerID, this.httpOptions);
  }
}
