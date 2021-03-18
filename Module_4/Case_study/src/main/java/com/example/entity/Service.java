package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "service_code")
    @Pattern(regexp = "(DV-[\\d]{4})", message = "Service code must be in the correct DV-XXXX format !!")
    private String serviceCode;

    @Column(name = "service_name")
    @Size(min = 4, max = 45, message = "Name not suitable !!")
    private String serviceName;

    @Column(name = "service_area")
    @Min(1)
    private int serviceArea;

    @Column(name = "service_cost")
    @Min(1)
    private double serviceCost;

    @Column(name = "service_max_people")
    @Min(1)
    private int serviceMaxPeople;

    @Column(name = "standard_room")
    @NotEmpty(message = "Not be empty !!")
    private String standardRoom;

    @Column(name = "description_other_convenience")
    @NotEmpty(message = "Not be empty !!")
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    @Min(1)
    private double poolArea;

    @Column(name = "number_of_floors")
    @Min(1)
    private int numberOfFloors;

    //------------------------ Tạo Mối Quan Hệ -------------------------

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    private RentType rentType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contractSet;
    //------------------------------------------------------------------


    public Service() {
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
