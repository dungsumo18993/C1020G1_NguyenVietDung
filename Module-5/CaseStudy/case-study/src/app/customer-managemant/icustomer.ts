import {CustomerType} from "./customer-type";

export class ICustomer {
  id: number;
  customerCode: string;
  customerName: string;
  customerBirthday: string;
  customerGender: string;
  customerIdCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
  customerType: CustomerType;


  constructor(id: number, customerCode: string, customerName: string, customerBirthday: string, customerGender: string, customerIdCard: string, customerPhone: string, customerEmail: string, customerAddress: string, customerType: CustomerType) {
    this.id = id;
    this.customerCode = customerCode;
    this.customerName = customerName;
    this.customerBirthday = customerBirthday;
    this.customerGender = customerGender;
    this.customerIdCard = customerIdCard;
    this.customerPhone = customerPhone;
    this.customerEmail = customerEmail;
    this.customerAddress = customerAddress;
    this.customerType = customerType;
  }
}
