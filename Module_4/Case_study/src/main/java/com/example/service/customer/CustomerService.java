package com.example.service.customer;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    Page<Customer> findByName(String name, Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);
}
