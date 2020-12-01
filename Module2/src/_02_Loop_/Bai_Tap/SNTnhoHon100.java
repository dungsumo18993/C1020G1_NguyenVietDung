package _02_Loop_.Bai_Tap;

import java.util.Scanner;

public class SNTnhoHon100 {
    public static void main(String[] args) {
        for(int j=2;j<=100;j++) {
            boolean check = true;
            for (int i = 2; i <=Math.sqrt(j); i++) {
                if (j % i == 0) {
                    check = false;
                    break;
                }
                check = true;
            }
            if(check){
                System.out.print(j+"\t");
            }
            }
        }
}
