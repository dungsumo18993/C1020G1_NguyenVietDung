package _12_map_tree_.bai_tap.lt_arraylist_linkedlist;

import java.util.Comparator;

public class GiaTangDan implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getGiaSanPham() - o2.getGiaSanPham()>0) return 1;
        else if (o1.getGiaSanPham() - o2.getGiaSanPham()<0) return -1;
        return 0;
    }
}
