package com.example.repository.customer;

import com.example.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select * from customer c where concat(c.customer_name,c.customer_code,c.customer_email) like %:key%",nativeQuery = true)
    @Query(value = "select c from Customer c where concat(c.customerName, c.customerCode, c.customerEmail, c.customerAddress) like %?1% ")
    Page<Customer> findAllInput(String keyword, Pageable pageable);
}
