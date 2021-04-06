import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../customer-type";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {

  createForm = new FormGroup({
    customerCode: new FormControl('', [Validators.required, Validators.pattern("(KH-[\\d]{4})")]),
    customerName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    customerBirthday: new FormControl('', [Validators.required]),
    customerGender: new FormControl('', [Validators.required]),
    customerIdCard: new FormControl('', [Validators.required, Validators.pattern("(\\d{9})|(\\d{12})")]),
    customerPhone: new FormControl('', [Validators.required, Validators.pattern("(090|091|[(]84[)][+]90|[(]84[)][+]91)\\d{7}")]),
    customerEmail: new FormControl('', [Validators.required, Validators.email]),
    customerAddress: new FormControl('', [Validators.required, Validators.minLength(3)]),
    customerType: new FormControl('', [Validators.required])
  });

  customerTypes: CustomerType[];

  constructor(private customerService: CustomerService,
              private router: Router) { }

  ngOnInit(): void {
    this.customerService.getAllCustomerType().subscribe(data =>{
      this.customerTypes = data;
    })
  }

  public createCustomer(){
    this.customerService.addNewCustomer(this.createForm.value).subscribe(data =>{
      this.router.navigateByUrl("customer-list")
    });
  }

  get customerCode(){
    return this.createForm.get('customerCode')
  }
  get customerName(){
    return this.createForm.get('customerName')
  }

  get customerIdCard(){
    return this.createForm.get('customerIdCard')
  }
  get customerPhone(){
    return this.createForm.get('customerPhone')
  }
  get customerEmail(){
    return this.createForm.get('customerEmail')
  }
  get customerAddress(){
    return this.createForm.get('customerAddress')
  }
}
