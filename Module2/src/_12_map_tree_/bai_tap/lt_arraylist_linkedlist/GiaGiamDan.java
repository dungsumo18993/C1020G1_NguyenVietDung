package _12_map_tree_.bai_tap.lt_arraylist_linkedlist;

import java.util.Comparator;

public class GiaGiamDan implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getGiaSanPham()-o1.getGiaSanPham());
    }
}
