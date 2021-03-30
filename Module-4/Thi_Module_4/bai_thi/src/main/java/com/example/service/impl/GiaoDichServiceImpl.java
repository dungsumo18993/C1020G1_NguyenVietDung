package com.example.service.impl;

import com.example.entity.GiaoDich;
import com.example.entity.KhachHang;
import com.example.repository.GiaoDichRepository;
import com.example.repository.KhachHangRepository;
import com.example.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {

    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public Page<GiaoDich> findAll(Pageable pageable) {
        return giaoDichRepository.findAll(pageable);
    }

    @Override
    public Page<GiaoDich> findAllInput(String keyword, Pageable pageable) {
        return giaoDichRepository.findAllInput(keyword, pageable);
    }

    @Override
    public GiaoDich findById(Integer id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public void remove(Integer id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public List<KhachHang> findAllCustomer() {
        return khachHangRepository.findAll();
    }
}
