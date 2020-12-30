package Models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }


    public Room(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public Room(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoi, String kieuThue, String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public String toString() {
        return  this.getId() +
                "," + this.getTenDichVu()+
                ","+ this.getDienTichSuDung()+
                ","+ this.getChiPhiThue()+
                ","+ this.getSoLuongNguoi()+
                ","+ this.getKieuThue()+
                "," + dichVuMienPhiDiKem ;
    }

    @Override
    public void showInfor() {
        System.out.println("Id: " + this.getId() +
                ", Tên Dịch Vụ: " + this.getTenDichVu()+
                ", Diện tích Sử Dụng: "+ this.getDienTichSuDung()+
                ", Chi Phí Thuê: "+ this.getChiPhiThue()+
                ", Số Lượng Người: "+ this.getSoLuongNguoi()+
                ", Kiểu Thuê: "+ this.getKieuThue()+
                ", Dịch Vụ Miễn Phí Đi Kèm: " + dichVuMienPhiDiKem);
    }
}
