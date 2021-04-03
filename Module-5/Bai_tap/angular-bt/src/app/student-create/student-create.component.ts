import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.scss']
})
export class StudentCreateComponent implements OnInit {

  studentService;

  createForm = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.minLength(5)]),
    age: new FormControl('', [Validators.required, Validators.min(18), Validators.max(40)]),
    height: new FormControl('', [Validators.required, Validators.min(160)]),
    avatarImg: new FormControl('', [Validators.required])
  });
  constructor() {
    this.studentService = new StudentService();
  }

  ngOnInit(): void {
  }

  createStudent() {
    this.studentService.addStudent(this.createForm.value);
    this.createForm.reset();
  }

  get Id(){
    return this.createForm.get('id');
  }
  get Name(){
    return this.createForm.get('name');
  }
  get Age(){
    return this.createForm.get('age');
  }
  get Height(){
    return this.createForm.get('height');
  }
  get Avatar(){
    return this.createForm.get('avatarImg');
  }

}
