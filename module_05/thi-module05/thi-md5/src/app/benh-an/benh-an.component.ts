import { Component, OnInit } from '@angular/core';
import {BenhAn} from "../modle/benh-an";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-benh-an',
  templateUrl: './benh-an.component.html',
  styleUrls: ['./benh-an.component.css']
})
export class BenhAnComponent implements OnInit {

  benhAnList: BenhAn[]|any;
  benhAnParent: BenhAn| undefined;
  p: number = 1;
  private tenBN:string;

  constructor( private router: Router, private httpClient: HttpClient) {
    // this.benhAnService.findAll().subscribe(next=> {
    //   this.benhAnList = next;
    //   console.log(this.benhAnList)
    // }, error => {
    //
    // }, () => {
    //
    // });
    // console.log(this.benhAnList)
  }
  showDetail(item:BenhAn) {
    this.benhAnParent = item; // gán.
  }

  ngOnInit(): void {
    this.httpClient.get("http://localhost:3000/BenhAn").subscribe((result: BenhAn[])=>{
      this.benhAnList = result;
      console.log(this.benhAnList)
    })
  }
  movePageCreateBenhAn() {
    this.router.navigateByUrl("/benhan/create")
  }

  Search() {
    if(this.tenBN==""){
      this.ngOnInit();
    } else {
      this.benhAnList = this.benhAnList.filter(res=>{
        return res.tenBN.toLocaleLowerCase().match(this.tenBN.toLocaleLowerCase());

      })
    }

  }
  key: string = 'tenBN';
  reverse: boolean = false

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse

  }


}
