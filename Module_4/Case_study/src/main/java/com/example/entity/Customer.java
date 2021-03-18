package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_code")
    @NotNull(message = "Not be empty !!")
    @Pattern(regexp = "(KH-[\\d]{4})", message = "Customer code wrong format !!")
    private String customerCode;

    @Column(name = "customer_name")
    @NotNull(message = "Not be empty !!")
    @Size(min = 5, max = 45, message = "Name not suitable !!")
    private String customerName;

    @Column(name = "customer_birthday")
    @NotEmpty(message = "Not be empty !!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String customerBirthday;

    @Column(name = "customer_gender")
    @NotNull(message = "Not be empty !!")
    private String customerGender;

    @Column(name = "customer_id_card")
    @Pattern(regexp = "(\\d{9})|(\\d{12})", message = "The ID number must be in the format XXXXXXXXX or XXXXXXXXXXXX !!")
    private String customerIdCard;

    @Column(name = "customer_phone")
    @Pattern(regexp = "(090|091|(84)+90|(84)+91)\\d{7}", message = "Phone number must be in the format 090xxxxxxx or" +
            " 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx !!")
    private String customerPhone;

    @Column(name = "customer_email")
    @NotEmpty(message = "Not be empty !!")
    @Email(message = "Email malformed !!")
    private String customerEmail;

    @Column(name = "customer_address")
    @NotEmpty(message = "Not be empty !!")
    private String customerAddress;

    // ----------------------------- Tạo mối quan hệ ------------------------------------------

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Contract> contractSet;
    //-----------------------------------------------------------------------------------------

    public Customer() {
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
