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
                    "\n4. Exit" +
                    "\n5. Edit Product" +
                    "\n6. Delete Product");
            System.out.println("Chọn chức năng từ 1-6: ");
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
                case 4:
                    System.exit(0);
                case 5:
                    editProduct();
                    break;
                case 6:
                    deleteProduct();
                    break;
                default:
                    System.err.println("Vui lòng chọn lại !!");
            }
        } while (choose != 4);
    }

    public static void addNewProduct(){
        readProduct();
        int id;
        if (productList.isEmpty()){
            id = 1;
        } else {
            id=(productList.get(productList.size()-1).getProductId()) + 1;
        }
//        System.out.println("Enter id: ");
//        int id = scanner.nextInt();
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
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("src\\_17_io_binary_file_\\bai_tap\\quan_ly_sp\\Data\\Product.csv",true));

            bufferedWriter.write(product.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeProductEdit(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("src\\_17_io_binary_file_\\bai_tap\\quan_ly_sp\\Data\\Product.csv")
            );
            for (Product product : productList) {
                bufferedWriter.write(product.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readProduct() {
        productList = new ArrayList<>();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader("src\\_17_io_binary_file_\\bai_tap\\quan_ly_sp\\Data\\Product.csv")
                );
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] array = line.split(",");
                    Product product = new Product(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]), array[4]);
                    productList.add(product);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void showProduct(){
        readProduct();
        for (Product element : productList){
           element.showInfo();
        }
    }

    public static void searchProduct(){
        System.out.println("Enter id: ");
        int id=scanner.nextInt();

        readProduct();
        boolean check = false;
        for (Product product : productList) {
            if (product.getProductId() == id) {
                System.out.println(product.toString());
                check = true;
            }
        }
        if(!check){
            System.err.println("Id không hợp lệ!!");
        }
    }

    public static void editProduct(){
        readProduct();
        showProduct();
        System.out.println("Nhập Id: ");
        int id = scanner.nextInt();
        int index;
        for(index = 0 ; index < productList.size() ; index++){
            int idOfProduclist = productList.get(index).getProductId();
            if(id == idOfProduclist){
                System.out.println("Input Name: ");
                String name = scanner.next();
                productList.get(index).setProductName(name);
                break;
            }
        }
        if(index == productList.size()){
            System.err.println("Notfound input ID!!");
        }
        writeProductEdit();
    }

    public static void deleteProduct(){
        readProduct();
        showProduct();
        System.out.println("Input Id: ");
        int id = scanner.nextInt();
        int index;
        for (index=0; index<productList.size(); index++) {
            int idOfProductList = productList.get(index).getProductId();
            if (id == idOfProductList) {
                productList.remove(index);
                break;
            }
        }
            if (index == productList.size()){
                System.err.println("Notfound input ID!!");
            }
            writeProductEdit();
    }
}
