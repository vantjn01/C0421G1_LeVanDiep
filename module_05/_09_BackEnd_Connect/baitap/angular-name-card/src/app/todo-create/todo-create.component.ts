import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {TodoService} from '../todo.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {

  public todoForm: FormGroup;

  constructor(public todoService: TodoService, public router: Router) {
  }

  ngOnInit(): void {
    this.initfrom();
  }

  initfrom() {
    this.todoForm = new FormGroup({
      content: new FormControl(),
      complete: new FormControl(false),
    });
  }

  create() {
    this.todoService.create(this.todoForm.value).subscribe(data => {
      this.router.navigateByUrl('/list');
    });
  }

}
