import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../icustomer";
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customerList: ICustomer[];
  customerId: number;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(data =>{
      this.customerList = data;
    })
  }
  showDelete(id: number) {
    this.customerId = id;
    console.log(this.customerId);
  }
  delete() {
    this.customerService.deleteCustomer(this.customerId).subscribe(data => {
      console.log(this.customerId);
      this.ngOnInit();
    });
  }
}
