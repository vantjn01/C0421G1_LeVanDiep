import { Component, OnInit } from '@angular/core';
import {Todo} from "../todo";
import {FormControl} from "@angular/forms";
import {TodoService} from '../todo.service';
import {Router} from '@angular/router';
let _id = 1;


@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todoList: Todo[] = [];
  inputControl = new FormControl();

  constructor(public todoService: TodoService,  public router: Router) { }

  ngOnInit(): void {
    this.showAll();
  }


  // change() {
  //   const value = this.content.value;
  //   if (value) {
  //     const todo: Todo = {
  //       id: _id++,
  //       content: value,
  //       complete: false
  //     };
  //     this.todos.push(todo);
  //     this.content.reset();
  //   }
  // }
  //
  // toggleTodo(i: number) {
  //   this.todos[i].complete = !this.todos[i].complete;
  //
  // }
  showAll() {
    this.todoService.getAll().subscribe(data => {
      this.todoList = data;
      console.log(this.todoList);
    });
  }
  toggleTodo(i: number){
    const todo = this.todoList[i];
    todo.complete = !todo.complete;
    this.todoService.edit(this.todoList[i], this.todoList[i].id).subscribe(next => {
      this.todoList[i].complete = next.complete;
    });
  }
  addTodo(){}
  deleteTodo(i){}
}
