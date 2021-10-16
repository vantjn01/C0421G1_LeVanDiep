import {Component, Input, OnInit} from '@angular/core';
import {Car} from "../../../../Car";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  @Input("carChild") carDetail: Car;


  constructor() { }

  ngOnInit(): void {
  }

}
