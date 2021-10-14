import { Component, OnInit } from '@angular/core';
import {ThiThuServiceService} from "../../thi-thu-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Movie} from "../../../../movie";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  id: number;
  movieDelete: Movie;

  constructor(private thiThuServiceService: ThiThuServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      this.getMovie(this.id);
    })
  }

  ngOnInit(): void {
  }

  getMovie(id: number) {
    return this.thiThuServiceService.findById(id).subscribe(customer => {
      this.movieDelete = customer[0];
    });
  }

  deleteMovie(id: number) {
    this.thiThuServiceService.deleteMovie(id).subscribe(() => {
      this.router.navigate(['/movie']);
    }, e => {
      console.log(e);
    });
  }


}
