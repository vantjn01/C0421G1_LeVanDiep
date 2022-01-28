import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Food} from "../../entity/Food";
import {StorageService} from "../account/storage.service";
import {ICategory} from "../../entity/ICategory";

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  private urlTrend = "http://localhost:8080/api/food/listTrend";
  private urlList = "http://localhost:8080/api/food/list";
  private urlFindFoodCategory = "http://localhost:8080/api/food/food-category";
  private urlSortaToz = "http://localhost:8080/api/food/food/sort/a-z";
  private urlfindFood = "http://localhost:8080/api/food/find";
  private urlrandome = "http://localhost:8080/api/food/list/randome";

  constructor(private http: HttpClient) {
  }

  getAllFood(): Observable<Food | any> {
    return this.http.get(this.urlList);
  }

  getListTrend(): Observable<Food | any> {
    return this.http.get(this.urlTrend);
  }

  getFoodFinbyCategory(id: number): Observable<| Food | any> {
    return this.http.get(this.urlFindFoodCategory + "/" + id)
  }

  getSortAToZ(): Observable<Food | any> {
    return this.http.get(this.urlSortaToz);
  }

  getByIdFood(id: number): Observable<Food | any> {
    return this.http.get(this.urlfindFood + "/" + id);
  }

  getRandomeFour(): Observable<Food | any> {
    return this.http.get(this.urlrandome);
  }
}
