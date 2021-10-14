import { Component, OnInit } from '@angular/core';
import {Movie} from "../../../../movie";
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {ThiThuServiceService} from "../../thi-thu-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  movie: Movie| undefined;
  movieForm: FormGroup;


  constructor(private thiThuServiceService: ThiThuServiceService, private router:Router ) {
    this.movieForm= new FormGroup({
      id: new FormControl('',[Validators.required]),
      codeMovie: new FormControl('',Validators.compose([Validators.required,Validators.pattern('^CI-\\d{4}$')])),
      nameMovie: new FormControl('',[Validators.required]),
      date: new FormControl('',Validators.compose([Validators.required,this.checkNow])),
      quantityCard: new FormControl('',[Validators.required,Validators.min(0)]),

    })
  };
  validationMessage = {
    id: [
      {type: 'required', message: '<= Vui long nhap.'},
    ],
    codeMovie:[
      {type: 'required', message:'<= Vui long nhap'},
      {type: 'pattern', message:'<= Nhap Code theo dang : CI-XXXX'}
    ],
    nameMovie: [
      {type: 'required', message: '<- Vui long nhap.'},
    ],
    date: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'errorTime', message:'Ngày phải lơn hơn ngày hiện tại'}
    ],
    quantityCard: [
      {type: 'required', message: '<- Vui long nhap.'},
      {type: 'pattern', message: '<- So luong phai lon hon 0.'},
    ],

  };


  ngOnInit(): void {

  }


  checkNow(abstractControl: AbstractControl): any {
    const date = abstractControl.value;
    const now = new Date().toJSON().slice(0,10).split('-').join("");
    // console.log(now);
    // console.log(date);
    // console.log(date.toString().split('-').reverse().join(""));

    return now <= date.toString().split('-').join("") ? null : {errorTime: true};
  }

  // getType(){
  //   this.customerTypeService.findAll().subscribe(data=>{
  //     this.customerType = data
  //   })
  // }

  // createCustomer(name: string, gender: string, point: string) {
  //   //gán giá trị cho object student
  //   // this.student = {name: name, gender: parseInt(gender), point: parseInt(point)};
  //   // console.log(this.student);
  // }

  // createMovieTemplateDrivenForm(registerForm: NgForm) {
  //   if (registerForm.value.name == "") {
  //     alert("name không được để trống")
  //   }
  //   console.log(registerForm)
  // }

  createMovieReactiveForms() {
    console.log(this.movieForm);
    //valid : true nếu validate đúng. flase nếu validate còn có lỗi
    //invalid: true nếu validate còn có lỗi. false nếu validate đúng
    this.thiThuServiceService.createMovie(this.movieForm.value).subscribe(next => {
      alert('Tạo thành công');
      this.router.navigateByUrl("/movie")
    })

  }


}
