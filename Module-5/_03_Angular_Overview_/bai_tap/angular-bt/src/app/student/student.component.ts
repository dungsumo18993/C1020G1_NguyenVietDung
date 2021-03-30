import { Component, OnInit } from '@angular/core';
import {IStudent} from '../model/Student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  student: IStudent = {
    id: 1,
    name: 'Zoro',
    age: 28,
    height: 180,
    avatarImg: 'https://phamdo18.com/wp-content/uploads/2020/10/tong-hop-hinh-nen-one-piece-dep-nhat-hien-nay31.jpeg',
    avatarSize: 500
  }
  constructor() { }

  ngOnInit(): void {
  }

}
