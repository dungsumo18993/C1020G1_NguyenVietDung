package Controllers;

import Models.Customer;
import Models.Villa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainController.displayMainMenu();
    }

    public static void displayMainMenu(){
        int chon =0;
        do {
            System.out.println("1. Add New Services" +
                    "\n2. Show Services" +
                    "\n3. Add New Customer" +
                    "\n4. Show Information of Customer" +
                    "\n5. Add New Booking" +
                    "\n6. Show Information of Employee" +
                    "\n7. Exit");
            System.out.println("Chọn chức năng từ 1-7: ");
            chon=scanner.nextInt();
            switch (chon){
                case 1 :
                    addNewSevices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    CustomerController.addNewCustomer();
                    break;
                case 4:
                    CustomerController.showInformationCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    break;
            }
        } while (chon>0 && chon<7);
    }

    public static void addNewSevices(){
        int chon=0;
        do {
            System.out.println("1. Add New Villa" +
                    "\n2. Add New House" +
                    "\n3. Add New Room" +
                    "\n4. Back to menu" +
                    "\n5. Exit");
            System.out.println("Chọn chức năng từ 1-5: ");
            chon=scanner.nextInt();
            switch (chon){
                case 1:
                    ManegerController.addVilla();
                    break;
                case 2:
                    ManegerController.addHouse();
                    break;
                case 3:
                    ManegerController.addRoom();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (chon>0 && chon<=5);
    }

    public static void showServices(){
        int chon = 0;
        do {
            System.out.println("1. Show All Villa" +
                    "\n2. Show All House" +
                    "\n3. Show All Room" +
                    "\n4. Show All Name Villa Not Duplicate" +
                    "\n5. Show All Name House Not Duplicate" +
                    "\n6. Show All Name Room Not Duplicate" +
                    "\n7. Back to menu" +
                    "\n8. Exit");
            System.out.println("Chọn chức năng từ 1-8:");
            chon=scanner.nextInt();
            switch (chon){
                case 1:
                    ManegerController.showVilla();
                    break;
                case 2:
                    ManegerController.showHouse();
                    break;
                case 3:
                    ManegerController.showRoom();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (chon>0 && chon<=8);
    }

    public static List<Customer> ReadFileCustomer(){
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static void addNewBooking(){
        List<Customer> customerList = ReadFileCustomer();

        for (int i=0; i<customerList.size(); i++){
            System.out.print((i+1) + ".");
            customerList.get(i).showInfo();
        }

        System.out.println("Chọn Khách Hàng: ");
        int chonKhachHang = scanner.nextInt();

        while (chonKhachHang<0 || chonKhachHang>customerList.size()){
            System.err.println("Không tìm thấy customer");
            System.out.println("Chọn Khách Hàng: ");
            chonKhachHang=scanner.nextInt();
        }

        System.out.println("1. Booking Villa" +
                "\n2. Booking House" +
                "\n3. Booking Room");
        System.out.println("Chọn Dịch Vụ: ");
        int chonDichVu=scanner.nextInt();
        switch (chonDichVu){
            case 1:
                List<Villa> villaList = new ArrayList<>();
                try {
                    BufferedReader bufferedReader = new BufferedReader(
                            new FileReader("src/Data/Villa.csv")
                    );
                    String line=null;
                    while ((line=bufferedReader.readLine()) != null){
                        String[] strings=line.split(",");
                        Villa villa = new Villa(strings[0],strings[1],Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),Integer.parseInt(strings[4]),strings[5],strings[6],strings[7],Double.parseDouble(strings[8]),Integer.parseInt(strings[9]));
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
    }
}
