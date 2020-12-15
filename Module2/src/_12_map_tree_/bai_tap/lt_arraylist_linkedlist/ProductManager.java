package _12_map_tree_.bai_tap.lt_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.List;


public class ProductManager {
    List<Product> productList = new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public void edit(int id, String name) {
        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.get(i).setTenSanPham(name);
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Not found id of Product");
        }
    }

    public void delete(int id) {
        boolean check=false;
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(i);
                check=true;
                break;
            }
        }
        if (!check){
            System.out.println("Not found id of Product");
        }
    }

    public void search(String name){
        boolean check=false;
        for (int i = 0; i < productList.size(); i++){
            if (name.equals(productList.get(i).getTenSanPham())){
                System.out.println(productList.get(i));
                check=true;
                break;
            }
        }
        if (!check){
            System.out.println("Not name id of Product");
        }
    }

}
