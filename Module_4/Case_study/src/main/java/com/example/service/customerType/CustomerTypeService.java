package com.example.service.customerType;

import com.example.model.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();

    CustomerType findById(Integer id);

    void save(CustomerType customerType);

    void remove(Integer id);
}
