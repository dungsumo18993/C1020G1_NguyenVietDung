package com.example.service.service;

import com.example.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    Service findById(Integer id);

    void save(Service service);

    void remove(Integer id);
}
