import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../customer-type";

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.scss']
})
export class CustomerUpdateComponent implements OnInit {

  updateCustomerForm = new FormGroup({
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

  customerId: number;
  customerTypes: CustomerType[];

  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
     this.activatedRoute.params.subscribe(data => {
       this.customerId = data.id;
       this.customerService.findCustomerById(this.customerId).subscribe(data => {
         this.updateCustomerForm.patchValue(data);
       });
     });

    this.customerService.getAllCustomerType().subscribe(data =>{
      this.customerTypes = data;
    })
  }

  compareFn(c1: CustomerType, c2: CustomerType): boolean {
    return c1 && c2 ? c1.customerTypeId === c2.customerTypeId : false;
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.customerId, this.updateCustomerForm.value).subscribe(data => {
      this.router.navigateByUrl("customer-list");
    });

  }

  get customerCode(){
    return this.updateCustomerForm.get('customerCode')
  }
  get customerName(){
    return this.updateCustomerForm.get('customerName')
  }

  get customerIdCard(){
    return this.updateCustomerForm.get('customerIdCard')
  }
  get customerPhone(){
    return this.updateCustomerForm.get('customerPhone')
  }
  get customerEmail(){
    return this.updateCustomerForm.get('customerEmail')
  }
  get customerAddress(){
    return this.updateCustomerForm.get('customerAddress')
  }


}
