import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AuthService} from '../../service/security/auth.service';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TokenStorageService} from '../../service/security/token-storage.service';

@Component({
  selector: 'app-chang-pass-word',
  templateUrl: './chang-pass-word.component.html',
  styleUrls: ['./chang-pass-word.component.css']
})
export class ChangPassWordComponent implements OnInit {

  username: string;
  formPassword: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private toast: ToastrService,
              private auth: AuthService,
              private formBuilder: FormBuilder,
              private tokenStorage: TokenStorageService) {
  }

  ngOnInit(): void {
    this.username = this.tokenStorage.getUser().username;
    console.log(this.username);
    this.formPassword = this.formBuilder.group({
      newPassword: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(20)]],
      repeatNewPassword: ['', [Validators.required]],
    }, {validators: this.passWordValidator});
  }

  changePassword() {
    if (this.formPassword.valid) {
      this.auth.changPassWord(this.username, this.formPassword.value.newPassword).subscribe(value => {
        this.toast.success('thay đổi mật khẩu thành công', ' thông báo');
        window.location.href = 'http://localhost:4200';
      }, error => {
        this.toast.error('không tìm thấy tài khoản', ' thông báo');
      });
    }
  }

  passWordValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const newPassWord = control.get('newPassword');
    const repeatNewPassword = control.get('repeatNewPassword');
    if (newPassWord.value !== null && repeatNewPassword.value !== null) {
      if (newPassWord.value === repeatNewPassword.value) {
        return null;
      }
      return {
        checkPassWord: true
      };
    } else {
      return null;
    }
  }

  reloadPage() {
    window.location.reload();
  }

}
