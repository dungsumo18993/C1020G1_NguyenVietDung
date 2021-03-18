package com.example.repository.contract;

import com.example.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select c from Contract c where ?1 between c.contractStartDate and c.contractEndDate")
    Page<Contract> findAllCustomerActive(String date, Pageable pageable);

    @Query(value = "select c from Contract c where (?1 between c.contractStartDate and c.contractEndDate) and concat(c.customer.customerCode, " +
            "c.customer.customerName) like %?2%")
    Page<Contract> findAllInput(String date,String keyword, Pageable pageable);
}
