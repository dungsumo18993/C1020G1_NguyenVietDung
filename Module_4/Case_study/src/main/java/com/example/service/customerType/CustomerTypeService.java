package com.example.service.customerType;

import com.example.entity.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();

    CustomerType findById(Integer id);

    void save(CustomerType customerType);

    void remove(Integer id);
}
