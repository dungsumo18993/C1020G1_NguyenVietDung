import { Injectable } from '@angular/core';
import {IStudent} from './model/Student';
import {students} from './model/StudentRepository';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor() { }

  addStudent(student: IStudent){
    students.push(student);
  }

  findById(id){
    // tslint:disable-next-line:triple-equals
    return students.find(x => x.id == id);
  }
}
