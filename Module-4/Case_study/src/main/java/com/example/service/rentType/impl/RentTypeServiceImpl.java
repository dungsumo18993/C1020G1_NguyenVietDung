package com.example.service.rentType.impl;

import com.example.entity.RentType;
import com.example.repository.rentType.RentTypeRepository;
import com.example.service.rentType.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return null;
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
