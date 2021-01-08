package Controllers;

import Commons.Validate;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManegerController {
    private static Scanner scanner = new Scanner(System.in);

    public static String nhapIdVilla(){
        System.out.println("Nhập Id: ");
        String idVilla=scanner.nextLine();
        while (!Validate.checkIdVilla(idVilla)){
            if (Validate.checkIdVilla(idVilla)){
                idVilla=scanner.nextLine();
            } else {
                System.err.println("Id không hợp lệ, vui lòng nhập lại!!");
                System.out.println("Nhập Id: ");
                idVilla=scanner.nextLine();
            }
        }
        return idVilla;
    }

    public static String nhapIdHouse(){
        System.out.println("Nhập Id: ");
        String idHouse=scanner.next();
        while (!Validate.checkIdHouse(idHouse)){
            if (Validate.checkIdHouse(idHouse)){
                idHouse=scanner.next();
            } else {
                System.err.println("Id không hợp lệ, vui lòng nhập lại!!");
                System.out.println("Nhập Id: ");
                idHouse=scanner.next();
            }
        }
        return idHouse;
    }

    public static String nhapIdRoom(){
        System.out.println("Nhập Id: ");
        String idRoom=scanner.next();
        while (!Validate.checkIdRoom(idRoom)){
            if (Validate.checkIdRoom(idRoom)){
                idRoom=scanner.next();
            } else {
                System.err.println("Id không hợp lệ, vui lòng nhập lại!!");
                System.out.println("Nhập Id: ");
                idRoom=scanner.next();
            }
        }
        return idRoom;
    }

    public static String nhapTenDichVu(){
        System.out.println("Nhập Tên Dịch Vụ: ");
        String tenDichVu=scanner.next();
        while (!Validate.checkTenDichVu(tenDichVu)){
            System.err.println("Tên Dịch Vụ không hợp lệ, vui lòng nhập lại!!");
            System.out.println("Nhập Tên Dịch Vụ: ");
            tenDichVu=scanner.next();
        }
        return tenDichVu;
    }

    public static double nhapDienTich() {
        double dienTich=0.0;
        do {
            System.out.println("Nhập Diện Tích Sử Dụng: ");
            try {
                double dienTich1 = scanner.nextDouble();
                if (dienTich1 < 30) {
                    System.err.println("Diện tích phải lớn hơn 30m2!!");
                    dienTich = 0.0;
                } else {
                    dienTich = dienTich1;
                }
            }
            catch (InputMismatchException e){
                System.err.println("Diện tích phải là số!!");
                scanner.nextLine();
            }
        } while (dienTich==0.0);

        return dienTich;
    }

    public static double nhapChiPhi(){
        System.out.println("Nhập Chi Phí Thuê: ");
        double chiPhi= scanner.nextDouble();
        while (chiPhi<=0){
            System.err.println("Chi Phí phải là số dương!!");
            System.out.println("Nhập Chi Phí Thuê: ");
            chiPhi=scanner.nextDouble();
        }
        return chiPhi;
    }

    public static int nhapSoLuongNguoi(){
        System.out.println("Nhập Số Lượng Người: ");
        int soLuongNguoi= scanner.nextInt();
        while (soLuongNguoi<0 || soLuongNguoi>20){
            System.err.println("Số lượng người không hợp lệ, vui lòng nhập lại!!");
            System.out.println("Nhập Số Lượng Người: ");
            soLuongNguoi=scanner.nextInt();
        }
        return soLuongNguoi;
    }

    public static String nhapKieuThue(){
        System.out.println("Nhập Kiểu Thuê: ");
        String kieuThue= scanner.next();
        while (!Validate.checkKieuThue(kieuThue)){
            System.err.println("Kiểu thuê không hợp lệ, vui lòng nhập lại!!");
            System.out.println("Nhập Kiểu Thuê: ");
            kieuThue=scanner.next();
        }
        return kieuThue;
    }

    public static String nhapTieuChuanPhong(){
        System.out.println("Nhập Tiêu Chuẩn Phòng: ");
        String tieuChuanPhong= scanner.next();
        while (!Validate.checkTieuChuan(tieuChuanPhong)){
            System.err.println("Tiêu Chuẩn không hợp lệ, vui lòng nhập lại!!");
            System.out.println("Nhập Tiêu Chuẩn Phòng: ");
            tieuChuanPhong=scanner.next();
        }
        return tieuChuanPhong;
    }

    public static String nhapTienNghiKhac(){
        System.out.println("Nhập Tiện Nghi Khác: ");
        return scanner.next();
    }

    public static double nhapDienTichHoBoi(){
        System.out.println("Nhập Diện Tích Hồ Bơi: ");
        double dienTichHoBoi=scanner.nextDouble();
        do {
            System.err.println("Diện tích phải lớn hơn 30m2!!");
            System.out.println("Nhập Diện Tích Hồ Bơi: ");
            dienTichHoBoi=scanner.nextDouble();
        }while (dienTichHoBoi<30);
        return dienTichHoBoi;
    }

    public static int nhapSoTang(){
        System.out.println("Nhập số tầng: ");
        int soTang= scanner.nextInt();
        while (soTang<=0){
            System.err.println("Số tầng không hợp lê, vui lòng nhập lại!!");
            System.out.println("Nhập số tầng: ");
            soTang=scanner.nextInt();
        }
        return soTang;
    }

    public static String nhapDichVuMienPhiDiKem(){
        System.out.println("Nhập Dịch Vụ Miễn Phí Đi Kèm: ");
        String dichVuDiKem= scanner.next();
        while (!Validate.checkDichVuDiKem(dichVuDiKem)){
            System.err.println("Dịch vụ không hợp lệ, vui lòng nhập lại!!");
            System.out.println("Nhập Dịch Vụ Miễn Phí Đi Kèm: ");
            dichVuDiKem=scanner.next();
        }
        return dichVuDiKem;
    }

    public static void addVilla(){
        Villa villa = new Villa(nhapIdVilla(),nhapTenDichVu(),nhapDienTich(),nhapChiPhi(),nhapSoLuongNguoi(),nhapKieuThue(),nhapTieuChuanPhong(),nhapTienNghiKhac(),nhapDienTichHoBoi(),nhapSoTang());

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("src/Data/Villa.csv",true)
            );

            bufferedWriter.write(villa.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showVilla(){
        List<Villa> villaList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Villa.csv")
            );
            String line = null;
            while ((line=bufferedReader.readLine()) != null){
                String[] string=line.split(",");
                double st2 = Double.parseDouble(string[2]);
                double st3 = Double.parseDouble(string[3]);
                int st4 = Integer.parseInt(string[4]);
                double st8 = Double.parseDouble(string[8]);
                int st9 = Integer.parseInt(string[9]);
                Villa villa = new Villa(string[0],string[1],st2,st3,st4,string[5],string[6],string[7],st8,st9);
                villaList.add(villa);
            }
            for (Villa element : villaList){
                element.showInfor();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHouse(){
        House house = new House(nhapIdHouse(),nhapTenDichVu(),nhapDienTich(),nhapChiPhi(),nhapSoLuongNguoi(),nhapKieuThue(),nhapTieuChuanPhong(),nhapTienNghiKhac(),nhapSoTang());

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("src/Data/House.csv",true)
            );

            bufferedWriter.write(house.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showHouse(){
        List<House> houseList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/House.csv")
            );
            String line = null;
            while ((line=bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                double st2 = Double.parseDouble(strings[2]);
                double st3 = Double.parseDouble(strings[3]);
                int st4 = Integer.parseInt(strings[4]);
                int st8 = Integer.parseInt(strings[8]);
                House house = new House(strings[0],strings[1],st2,st3,st4,strings[5],strings[6],strings[7],st8);
                houseList.add(house);
            }
            for (House element : houseList){
                element.showInfor();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addRoom(){

        Room room = new Room(nhapIdRoom(),nhapTenDichVu(),nhapDienTich(),nhapChiPhi(),nhapSoLuongNguoi(),nhapKieuThue(),nhapDichVuMienPhiDiKem());

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("src/Data/Room.csv",true)
            );

            bufferedWriter.write(room.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showRoom(){
        List<Room> roomList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Room.csv")
            );
            String line = null;
            while ((line=bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                double st2 = Double.parseDouble(strings[2]);
                double st3 = Double.parseDouble(strings[3]);
                int st4 = Integer.parseInt(strings[4]);
                Room room = new Room(strings[0],strings[1],st2,st3,st4,strings[5],strings[6]);
                roomList.add(room);
            }
            for (Room element : roomList){
                element.showInfor();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
