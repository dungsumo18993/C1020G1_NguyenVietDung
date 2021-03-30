package com.example.service.contract;

import com.example.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findAllCustomerActive(String date, Pageable pageable);

    Page<Contract> findAllInput(String date, String keyword, Pageable pageable);

    void save(Contract contract);
}
