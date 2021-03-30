package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "giao_dich")
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_giao_dich")
    private Integer idGiaoDich;

    @Column(name = "ma_giao_dich")
    @NotEmpty(message = "Không được để trống !!")
    @Pattern(regexp = "(MGD-[\\d]{4})", message = "Mã giao dịch phải đúng định dạng (MGD-XXXX) X là số (0-9)")
    private String maGiaoDich;

    @Column(name = "ngay_giao_dich")
    @NotEmpty(message = "Không được để trống !!")
    private String ngayGiaoDich;

    @Column(name = "loai_dich_vu")
    @NotEmpty(message = "Không được để trống !!")
    private String loaiDichVu;

    @Column(name = "don_gia")
    @Min(value = 500000,message = "Đơn giá phải lớn hơn 500.000 VND !!" )
    private double donGia;

    @Column(name = "dien_tich")
    @Min(value = 20, message = "Diện tích phải lớn hơn 20m vuông !!")
    private int dienTich;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang", referencedColumnName = "id_khach_hang")
    private KhachHang khachHang;

    public GiaoDich() {
    }

    public Integer getIdGiaoDich() {
        return idGiaoDich;
    }

    public void setIdGiaoDich(Integer idGiaoDich) {
        this.idGiaoDich = idGiaoDich;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
