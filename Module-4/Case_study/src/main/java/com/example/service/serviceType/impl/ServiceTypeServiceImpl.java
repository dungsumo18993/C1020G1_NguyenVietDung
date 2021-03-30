package com.example.service.serviceType.impl;

import com.example.entity.ServiceType;
import com.example.repository.serviceType.ServiceTypeRepository;
import com.example.service.serviceType.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Integer id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
