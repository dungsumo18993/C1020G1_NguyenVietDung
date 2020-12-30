package Controllers;

import Commons.*;
import Models.Customer;

import java.io.*;
import java.util.*;

public class CustomerController {
    static Scanner scanner = new Scanner(System.in);

    public static String chuanHoaDuLieu(String str){
        String str1=str.toLowerCase();
        String str2=str1.substring(0,1).toUpperCase();
        String str3=str1.substring(1);
        return str2+str3;
    }

    public static boolean checkBirthDay(String birthDay){
        Calendar calendar = Calendar.getInstance();
        boolean check = false;
        if(Validate.checkBirthDay(birthDay)){
            check=true;
        }
        if (check){
            String[] strings = birthDay.split("/");
            int str = Integer.parseInt(strings[0]);
            int str1 = Integer.parseInt(strings[1]);
            int str2 = Integer.parseInt(strings[2]);
            if (str<32 && str1<13 && (str2>1900 && (calendar.get(Calendar.YEAR) - str2)>=18 )){
                return true;
            }
        }
        return false;
    }

    public static void addNewCustomer(){
        System.out.println("Nhập Họ Tên Khách Hàng: ");
        String hoTen;
        do {
            hoTen=scanner.nextLine();
            if (!Validate.checkHoTen(hoTen)){
                System.err.println(new NameException());
                System.out.println("Nhập Họ Tên Khách Hàng: ");
            }
        } while (!Validate.checkHoTen(hoTen));

        System.out.println("Nhập ngày sinh: ");
        String ngaySinh=scanner.next();
        checkBirthDay(ngaySinh);
        while (!checkBirthDay(ngaySinh)){
            System.err.println(new BirthDayException());
            System.out.println("Nhập ngày sinh: ");
            ngaySinh=scanner.next();
            checkBirthDay(ngaySinh);
        }

        System.out.println("Nhập Giói Tính (Male/Female/Unknow): ");
        String gioiTinh=scanner.next();
        while (!Validate.checkGenDer(chuanHoaDuLieu(gioiTinh))){
            System.err.println(new GenderException());
            System.out.println("Nhập Giói Tính (Male/Female/Unknow): ");
            gioiTinh=scanner.next();
        }
        gioiTinh=chuanHoaDuLieu(gioiTinh);

        System.out.println("Nhập CMND: ");
        String idCard=scanner.next();
        while (!Validate.checkIdCard(idCard)){
            System.err.println(new IdCardException());
            System.out.println("Nhập CMND: ");
            idCard=scanner.next();
            Validate.checkIdCard(idCard);
        }

        System.out.println("Nhập số điện thoại: ");
        String soDienThoai=scanner.next();
        while (!Validate.checkPhoneNumber(soDienThoai)){
            System.err.println("SDT không hợp lệ, vui lòng nhập lại");
            System.out.println("Nhập số điện thoại: ");
            soDienThoai=scanner.next();
            Validate.checkPhoneNumber(soDienThoai);
        }

        System.out.println("Nhập Email: ");
        String email=scanner.next();
        while (!Validate.checkEmail(email)){
            System.err.println(new EmailException());
            System.out.println("Nhập Email: ");
            email=scanner.next();
            Validate.checkEmail(email);
        }

        System.out.println("Nhập loại Khách Hàng: ");
        String loaiKhachHang=scanner.next();
        while (!Validate.checkCustomerType(loaiKhachHang)){
            System.err.println("Loại Khách Hàng không hợp lệ, vui lòng nhập lại!!");
            System.out.println("Nhập loại Khách Hàng: ");
            loaiKhachHang=scanner.next();
            Validate.checkCustomerType(loaiKhachHang);
        }

        scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String diaChi=scanner.nextLine();


        Customer customer = new Customer(hoTen,ngaySinh,gioiTinh,idCard,soDienThoai,email,loaiKhachHang,diaChi);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("src/Data/Customer.csv",true)
            );

            bufferedWriter.write(customer.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showInformationCustomer(){
        List<Customer> customerList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Customer.csv")
            );
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                String[] strings=line.split(",");
                Customer customer = new Customer(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7]);
                customerList.add(customer);
            }
            Collections.sort(customerList);
            for (Customer element : customerList){
                element.showInfo();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
