package _12_map_tree_.bai_tap.lt_arraylist_linkedlist;

import java.util.Collections;

public class TestProduct {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Product sp1 = new Product(1,"Sách",10000);
        Product sp2 = new Product(2,"bút",3000);
        Product sp3 = new Product(3,"vở",5000);
        Product sp4 = new Product(4,"thước",2000);
        Product sp5 = new Product(5,"tẩy",1500);

        productManager.add(sp1);
        productManager.add(sp2);
        productManager.add(sp3);
        productManager.add(sp4);
        productManager.add(sp5);

        Collections.sort(productManager.productList, new GiaTangDan());
        for (Product element : productManager.productList){
            System.out.println(element);
        }
        System.out.println("---------------------------");
        productManager.edit(1,"compa");
        productManager.delete(2);

        for (Product element : productManager.productList){
            System.out.println(element);
        }
        System.out.println("---------------------------");
        productManager.search("vở");

    }
}
