import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {StudentService} from '../student.service';
import {IStudent} from '../model/Student';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.scss']
})
export class StudentDetailComponent implements OnInit {
  studentDetail: IStudent;

  constructor(private activatedRoute: ActivatedRoute,
              private studentService: StudentService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) =>
    this.studentDetail = this.studentService.findById(param.get('id')));
  }

}
