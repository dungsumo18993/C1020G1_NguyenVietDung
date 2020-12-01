package _02_Loop_.Thuc_Hanh;

import java.util.Scanner;

public class KiemTraSNT {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        System.out.print("Nhập số cần KT: ");
        int number=x.nextInt();

        if(number<2){
            System.out.println(number+" k phải là SNT.");
        } else {
            int i=2;
            boolean check = true;
            while (i<=Math.sqrt(number)){
                if (number%i==0){
                    check=false;
                    break;
                }
                i++;
            }
            if(check){
                System.out.println(number+" là SNT.");
            } else {
                System.out.println(number+" k là SNT.");
            }
        }
    }
}
