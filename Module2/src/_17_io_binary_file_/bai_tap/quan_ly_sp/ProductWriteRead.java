package _17_io_binary_file_.bai_tap.quan_ly_sp;

import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductWriteRead {
    private static Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        ProductWriteRead.displayMenu();
    }

    public static void displayMenu(){
        int choose=0;
        do {
            System.out.println("1. Add New Product"+
                    "\n2. Show Product" +
                    "\n3. Search Product" +
                    "\n4. Exit");
            System.out.println("Chọn chức năng từ 1-4: ");
            choose=scanner.nextInt();

            switch (choose){
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
            }
        } while (choose>=1 && choose<4);
    }

    public static void addNewProduct(){
        readProduct();
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        System.out.println("Enter name: ");
        String name= scanner.next();
        System.out.println("Enter manufacturer");
        String manufacturer = scanner.next();
        System.out.println("Enter price: ");
        double price=scanner.nextDouble();
        System.out.println("Enter descriptionsOther");
        String description=scanner.next();

        Product product = new Product(id,name,manufacturer,price,description);
        productList.add(product);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src\\_17_io_binary_file_\\bai_tap\\quan_ly_sp\\Product_file.io"));

            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readProduct(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src\\_17_io_binary_file_\\bai_tap\\quan_ly_sp\\Product_file.io"));

            productList = (List<Product>) objectInputStream.readObject();
        }catch (EOFException e){

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showProduct(){
        readProduct();
        for (Product element : productList){
            System.out.println(element.toString());
        }
    }

    public static void searchProduct(){
        System.out.println("Enter id: ");
        int id=scanner.nextInt();

        readProduct();
        boolean check = false;
        for (int i=0; i<productList.size(); i++){
            if (productList.get(i).getProductId() == id){
                System.out.println(productList.get(i).toString());
                check = true;
            }
        }
        if(!check){
            System.out.println("Id không hợp lệ!!");
        }
    }
}
