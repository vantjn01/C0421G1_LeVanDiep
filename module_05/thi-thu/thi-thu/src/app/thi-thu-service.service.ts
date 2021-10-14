import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../../movie";

@Injectable({
  providedIn: 'root'
})
export class ThiThuServiceService {

  private api_url_customer = "http://localhost:3000/movie";
  movies: Movie[];

  constructor(private httpClient: HttpClient) { }
  findAll():Observable<Movie[]|any>{
    return this.httpClient.get( this.api_url_customer)
  }
  createMovie(movie):Observable<Movie> {
    return this.httpClient.post<Movie>(this.api_url_customer, movie);
  }
  findById(id: number| null) : Observable<Movie|any> {
    return this.httpClient.get<Movie>(this.api_url_customer + "?id=" + id);
  }
  // updateMovie(id: number, movie: Movie): Observable<Movie> {
  //   return this.httpClient.put<Movie>(this.api_url_customer + "/" + id, movie);
  // }
  deleteMovie(id: number): Observable<Movie> {
    return this.httpClient.delete<Movie>(this.api_url_customer + "/" + id)

  }
}
