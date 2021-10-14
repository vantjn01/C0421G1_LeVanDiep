import { Component, OnInit } from '@angular/core';
import {Movie} from "../../../../movie";
import {Router} from "@angular/router";
import {ThiThuServiceService} from "../../thi-thu-service.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  movieD: Movie;

  movies: Movie[]|any;
  movieParent: Movie| undefined;
  name: any;
  p: number = 1;

  constructor(private thiThuServiceService: ThiThuServiceService, private router: Router) {
    this.thiThuServiceService.findAll().subscribe(next=> {
      this.movies = next;
      console.log(this.movies)
    }, error => {

    }, () => {

    });
    console.log(this.movies)
  }
  showDetail(item:Movie) {
    this.movieParent = item; // gán.
  }

  ngOnInit(): void {
  }
  movePageCreateMovie() {
    this.router.navigateByUrl("/movie/create")
  }


}
