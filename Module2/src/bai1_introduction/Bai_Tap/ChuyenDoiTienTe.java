package bai1_introduction.Bai_Tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner x=new Scanner(System.in);
        System.out.print("Nhập tiền USD: ");
        usd=x.nextDouble();
        double quydoi=usd*23000;
        System.out.print("Giá trị VND: "+quydoi);
    }
}
