package Models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String tienNghiKhac;
    private double dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String tieuChuanPhong, String tienNghiKhac, double dienTichHoBoi, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Villa(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String tienNghiKhac, double dienTichHoBoi, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getTienNghiKhac() {
        return tienNghiKhac;
    }

    public void setTienNghiKhac(String tienNghiKhac) {
        this.tienNghiKhac = tienNghiKhac;
    }

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return   this.getId() +
                "," + this.getTenDichVu()+
                ","+ this.getDienTichSuDung()+
                ","+ this.getChiPhiThue()+
                ","+ this.getSoLuongNguoi()+
                ","+ this.getKieuThue()+
                "," + tieuChuanPhong +
                "," + tienNghiKhac +
                "," + dienTichHoBoi +
                "," + soTang;
    }

    @Override
    public void showInfor() {
        System.out.println("Id: " + this.getId() +
                ", Tên Dịch Vụ: " + this.getTenDichVu()+
                ", Diện tích Sử Dụng: "+ this.getDienTichSuDung()+
                ", Chi Phí Thuê: "+ this.getChiPhiThue()+
                ", Số Lượng Người: "+ this.getSoLuongNguoi()+
                ", Kiểu Thuê: "+ this.getKieuThue()+
                ", Tiêu Chuẩn Phòng: " + tieuChuanPhong + 
                ", Tiện Nghi Khác: " + tienNghiKhac +
                ", Diện Tích Hồ Bơi: "+ dienTichHoBoi +
                ", Số Tầng: " + soTang);
    }
}
