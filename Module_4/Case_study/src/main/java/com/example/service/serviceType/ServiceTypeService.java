package com.example.service.serviceType;

import com.example.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(Integer id);

    void save(ServiceType serviceType);

    void remove(Integer id);
}
