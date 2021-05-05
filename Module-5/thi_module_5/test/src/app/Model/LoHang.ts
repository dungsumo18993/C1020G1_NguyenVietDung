import {SanPham} from './SanPham';

export class LoHang {
  id: number;
  maLoHang: string;
  sanPham: SanPham;
  soLuong: number;
  ngayNhapHang: string;
  ngaySanXuat: string;
  ngayHetHan: string;

  constructor(id: number, maLoHang: string, sanPham: SanPham, soLuong: number, ngayNhapHang: string, ngaySanXuat: string, ngayHetHan: string) {
    this.id = id;
    this.maLoHang = maLoHang;
    this.sanPham = sanPham;
    this.soLuong = soLuong;
    this.ngayNhapHang = ngayNhapHang;
    this.ngaySanXuat = ngaySanXuat;
    this.ngayHetHan = ngayHetHan;
  }
}
