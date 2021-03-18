package com.example.service.contract.impl;

import com.example.entity.Contract;
import com.example.repository.contract.ContractRepository;
import com.example.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllCustomerActive(String date, Pageable pageable) {
        return contractRepository.findAllCustomerActive(date, pageable);
    }

    @Override
    public Page<Contract> findAllInput(String date, String keyword, Pageable pageable) {
        return contractRepository.findAllInput(date, keyword, pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
