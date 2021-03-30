package com.example.service;

import com.example.entity.GiaoDich;
import com.example.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiaoDichService {
    Page<GiaoDich> findAll(Pageable pageable);

    Page<GiaoDich> findAllInput(String keyword, Pageable pageable);

    GiaoDich findById(Integer id);

    void save(GiaoDich giaoDich);

    void remove(Integer id);

    List<KhachHang> findAllCustomer();
}
