package Controllers;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static String villa="villa";
    private static String house="house";
    private static String room="room";
    private static String customer="customer";
    private static String employee="employee";

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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    return;
            }
        } while (chon>=7 && chon<=7);
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

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.exit(0);
                    return;
            }
        } while (chon>=1 && chon<=5);
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
                    break;
                case 2:
                    break;
                case 3:
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
                    return;
            }
        } while (chon>=1 && chon<=8);
    }
}
