package com.example.repository;

import com.example.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, Integer> {
    @Query("select d from GiaoDich d where concat(d.khachHang.tenKhachHang, d.loaiDichVu) like %?1%")
    Page<GiaoDich> findAllInput(String keyword, Pageable pageable);
}
