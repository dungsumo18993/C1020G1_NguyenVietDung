import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {students} from './model/StudentRepository';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'angular-bt';
}
