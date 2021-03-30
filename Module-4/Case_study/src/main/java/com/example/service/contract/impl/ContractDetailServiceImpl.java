package com.example.service.contract.impl;

import com.example.entity.AttachService;
import com.example.entity.ContractDetail;
import com.example.repository.contract.AttachServiceRepository;
import com.example.repository.contract.ContractDetailRepository;
import com.example.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<AttachService> findAllAttach() {
        return attachServiceRepository.findAll();
    }
}
