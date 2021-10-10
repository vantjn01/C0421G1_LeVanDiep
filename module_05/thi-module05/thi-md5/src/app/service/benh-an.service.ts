import { Injectable } from '@angular/core';
import {BenhAn} from "../modle/benh-an";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {

  private api_url_customer = "http://localhost:3000/BenhAn";
  benhAnList: BenhAn[];

  constructor(private httpClient: HttpClient) { }
  findAll():Observable<BenhAn[]|any>{
    return this.httpClient.get( this.api_url_customer)
  }
  // createBenhAn(benhAn):Observable<BenhAn> {
  //   return this.httpClient.post<BenhAn>(this.api_url_customer, benhAn);
  // }
  // findById(idBenhAn: string| null) : Observable<BenhAn|any> {
  //   return this.httpClient.get<BenhAn>(this.api_url_customer + "?idBenhAn=" + idBenhAn);
  // }
  // updateBenhAn(idBenhAn: string, benhAn: BenhAn): Observable<BenhAn> {
  //   return this.httpClient.put<BenhAn>(this.api_url_customer + "/" + idBenhAn, benhAn);
  // }
  // deleteBenhAn(idBenhAn: string): Observable<BenhAn> {
  //   return this.httpClient.delete<BenhAn>(this.api_url_customer + "/" + idBenhAn)
  //
  // }
}
