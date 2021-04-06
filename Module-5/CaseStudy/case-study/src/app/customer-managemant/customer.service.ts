import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomer} from "./icustomer";
import {CustomerType} from "./customer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API_URL: string = "http://localhost:3000/customers";
  public API_TYPE: string = "http://localhost:3000/customerTypes";

  constructor(private httpClient: HttpClient) { }

  public getAllCustomer(): Observable<ICustomer[]>{
    return this.httpClient.get<ICustomer[]>(this.API_URL);
  }

  public getAllCustomerType(): Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(this.API_TYPE);
  }

  public addNewCustomer(customer): Observable<any>{
    return this.httpClient.post(this.API_URL, customer);
  }

  public deleteCustomer(customerId): Observable<any>{
    return this.httpClient.delete(this.API_URL + '/' + customerId);
  }

  public findCustomerById(id: number): Observable<ICustomer>{
    return this.httpClient.get<ICustomer>(this.API_URL + '/' + id);
    //return this.httpClient.get<ICustomer>(`${this.API_URL}/${id}`);
  }

  public updateCustomer(customerId, customer ): Observable<any>{
    return this.httpClient.put(this.API_URL + '/' + customerId, customer);
  }
}
