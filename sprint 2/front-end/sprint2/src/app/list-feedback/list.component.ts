import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SnackbarService} from "../snackbar/snackbar.service";
import {HttpClient} from "@angular/common/http";
import {IFeedback} from "../entity/IFeedback";
import {FeedbackService} from "../feedback.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  // tour: ITour; // tạo đối tượng tour
  // tours: ITour [] = []; //tạo danh sách tour

  constructor(private feedbackService: FeedbackService,
              private route: Router,
              private snackBar: SnackbarService,
              private activatedRoute: ActivatedRoute,
              private httpClient: HttpClient) { }


  feedbacks: IFeedback[];
  feedbackFather: IFeedback;

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/api/feed-back').subscribe((result: IFeedback[]) => {
      this.feedbacks = result;
      console.log(this.feedbacks);
    })
  }

}
