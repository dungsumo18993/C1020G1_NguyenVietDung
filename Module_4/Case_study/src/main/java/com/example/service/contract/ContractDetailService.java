package com.example.service.contract;

import com.example.entity.AttachService;
import com.example.entity.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    void save(ContractDetail contractDetail);

    List<AttachService> findAllAttach();
}
