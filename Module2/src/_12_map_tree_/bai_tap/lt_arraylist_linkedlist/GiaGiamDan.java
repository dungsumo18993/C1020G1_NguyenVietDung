package _12_map_tree_.bai_tap.lt_arraylist_linkedlist;

import java.util.Comparator;

public class GiaGiamDan implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o2.getGiaSanPham()-o1.getGiaSanPham()>0) return 1;
        else if (o2.getGiaSanPham()-o1.getGiaSanPham()<0) return -1;
        return 0;
    }
}
