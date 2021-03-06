package Models;

public class House extends Services{
    private String tieuChuanPhong;
    private String tienNghiKhac;
    private int soTang;

    public House() {
    }


    public House(String tieuChuanPhong, String tienNghiKhac, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.soTang = soTang;
    }

    public House(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String tienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
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
                ", Số Tầng: " + soTang);
    }
}
