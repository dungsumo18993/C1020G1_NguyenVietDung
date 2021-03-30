package com.example.service.rentType;

import com.example.entity.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();

    RentType findById(Integer id);

    void save(RentType rentType);

    void remove(Integer id);
}
