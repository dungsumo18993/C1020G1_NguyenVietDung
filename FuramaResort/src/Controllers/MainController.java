package Controllers;

import Models.*;

import java.io.*;
import java.util.*;

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
                    "\n7. Buy Movie Tickets" +
                    "\n8. Find Employee Data" +
                    "\n9. Exit");
            System.out.println("Chọn chức năng từ 1-9: ");
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
                    showInfoEmployee();
                    break;
                case 7:
                    Cinema4D.showCinemaCustomer();
                    break;
                case 8:
                    FilingCabinets.searchEmployee();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập lại !!");
            }
        } while (chon != 9);
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
                default:
                    System.err.println("Vui lòng nhập lại !!");
            }
        } while (chon != 5);
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
                    showVillaNotDuplicate();
                    break;
                case 5:
                    showHouseNotDuplicate();
                    break;
                case 6:
                    showRoomNotDuplicate();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập lại !!");;
            }
        } while (chon != 8);
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
                    for (int i=0; i<villaList.size(); i++){
                        System.out.print((i+1)+ ".");
                        villaList.get(i).showInfor();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Chọn Villa: ");
                int chonVL=scanner.nextInt();
                while (chonVL<0 || chonVL>villaList.size()){
                    System.err.println("Không tìm thấy Villa !!");
                    System.out.println("Chọn Villa: ");
                    chonVL=scanner.nextInt();
                }
                Villa villa = villaList.get(chonVL-1);
                Customer customer=customerList.get(chonKhachHang-1);
                customer.setProperties(villa);

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new FileWriter("src/Data/Booking.csv",true)
                    );
                    bufferedWriter.write(customer.getIdCard()+","+villa.getId());
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                List<House> houseList = new ArrayList<>();
                try {
                    BufferedReader bufferedReader = new BufferedReader(
                            new FileReader("src/Data/House.csv")
                    );
                    String line=null;
                    while ((line=bufferedReader.readLine()) != null ){
                        String[] strings = line.split(",");
                        House house = new House(strings[0],strings[1],Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),Integer.parseInt(strings[4]),strings[5],strings[6],strings[7],Integer.parseInt(strings[8]));
                        houseList.add(house);
                    }
                    for (int i=0; i<houseList.size(); i++){
                        System.out.print((i+1)+".");
                        houseList.get(i).showInfor();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Chọn House: ");
                int chonHO=scanner.nextInt();

                while (chonHO<0 || chonHO>houseList.size()){
                    System.err.println("Không tìm thấy House !!");
                    System.out.println("Chọn House: ");
                    chonHO=scanner.nextInt();
                }
                House house = houseList.get(chonHO-1);
                Customer customer1=customerList.get(chonKhachHang-1);
                customer1.setProperties(house);

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new FileWriter("src/Data/Booking.csv",true)
                    );
                    bufferedWriter.write(customer1.getIdCard()+","+house.getId());
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                List<Room> roomList = new ArrayList<>();

                try {
                    BufferedReader bufferedReader = new BufferedReader(
                            new FileReader("src/Data/Room.csv")
                    );
                    String line= null;
                    while ((line=bufferedReader.readLine()) != null){
                        String[] arr=line.split(",");
                        Room room = new Room(arr[0],arr[1],Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Integer.parseInt(arr[4]),arr[5],arr[6]);
                        roomList.add(room);
                    }
                    for (int i=0; i<roomList.size(); i++){
                        System.out.print((i+1) + ".");
                        roomList.get(i).showInfor();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Chọn Room: ");
                int chonRO=scanner.nextInt();
                while (chonRO<0 || chonRO>roomList.size()){
                    System.err.println("Không tìm thấy Room !!");
                    System.out.println("Chọn Room: ");
                    chonRO=scanner.nextInt();
                }
                Room room = roomList.get(chonRO-1);
                Customer customer2 = customerList.get(chonKhachHang-1);
                customer2.setProperties(room);

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new FileWriter("src/Data/Booking.csv", true)
                    );
                    bufferedWriter.write(customer2.getIdCard() + "," + room.getId());
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void showVillaNotDuplicate(){
        TreeSet<String> treeSet = new TreeSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Villa.csv")
            );
            String line=null;
            while ((line=bufferedReader.readLine()) != null){
                String[] arr=line.split(",");
                treeSet.add(arr[1]);
            }
            for (String element : treeSet){
                System.out.println(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showHouseNotDuplicate(){
        TreeSet<String> treeSet = new TreeSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/House.csv")
            );
            String line=null;
            while ((line=bufferedReader.readLine()) != null){
                String[] arr=line.split(",");
                treeSet.add(arr[1]);
            }
            for (String element : treeSet){
                System.out.println(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showRoomNotDuplicate(){
        TreeSet<String> treeSet = new TreeSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Room.csv")
            );
            String line=null;
            while ((line=bufferedReader.readLine()) != null){
                String[] arr=line.split(",");
                treeSet.add(arr[1]);
            }
            for (String element : treeSet){
                System.out.println(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showInfoEmployee(){
        Map<String,Employee> employeeMap = new LinkedHashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/Data/Employee.csv")
            );
            String line = null;
            while ((line=bufferedReader.readLine()) != null){
                String[] array=line.split(",");
                Employee employee = new Employee(array[1],Integer.parseInt(array[2]),array[3]);
                employeeMap.put(array[0],employee);
            }
            for (Map.Entry<String,Employee> entry: employeeMap.entrySet()){
                System.out.println(entry.getKey()+ "," + entry.getValue());
            }
//            for (String element : employeeMap.keySet()){
//                System.out.println(element + ", " + employeeMap.get(element));
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
