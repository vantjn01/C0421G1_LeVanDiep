import { Component } from '@angular/core';
import {Customer} from "../model/Customer";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'caseStudy';
  // customers: Customer[] = [
  //   {idCustomer: 1, idTypeCustomer: 1, name: "Lê Văn Diệp", dateOfBirth: "1991-4-15", identityCard: 197266943,
  //     phone: 987654321, mail: "levandiep1991@gmail.com", address: "QT"},
  //   {idCustomer: 2, idTypeCustomer: 2, name: "Đồng Văn Nhật", dateOfBirth: "1999-4-11", identityCard: 197266943,
  //     phone: 987654321, mail: "levandiep1991@gmail.com", address: "QT"},
  //   {idCustomer: 3, idTypeCustomer: 3, name: "Nguyễn Thanh Hà", dateOfBirth: "1991-4-15", identityCard: 197266943,
  //     phone: 987654321, mail: "levandiep1991@gmail.com", address: "QT"},
  //   {idCustomer: 4, idTypeCustomer: 4, name: "Hồ Kỳ Tài", dateOfBirth: "1991-4-15", identityCard: 197266943,
  //     phone: 987654321, mail: "levandiep1991@gmail.com", address: "QT"},
  // ]
}
