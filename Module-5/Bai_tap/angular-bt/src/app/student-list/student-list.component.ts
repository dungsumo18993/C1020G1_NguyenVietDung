import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from '../model/Student';
import {students} from '../model/StudentRepository';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {
  constructor() {
  }

  studentList = students;
  student: IStudent;

  ngOnInit(): void {
  }

  findStudent(student: IStudent) {
    this.student = student;
  }
}
