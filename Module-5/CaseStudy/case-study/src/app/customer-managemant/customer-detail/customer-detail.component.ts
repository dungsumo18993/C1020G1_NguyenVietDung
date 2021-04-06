import { Component, OnInit } from '@angular/core';
import {ICustomer} from "../icustomer";
import {ActivatedRoute} from "@angular/router";
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {

  private customerDetail: ICustomer;
  constructor(
    private activatedRoute: ActivatedRoute,
    private customerService: CustomerService
  ) { }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params['id'];
    this.customerService.findCustomerById(id).subscribe(data => {
      this.customerDetail = data;
    });
  }

}
