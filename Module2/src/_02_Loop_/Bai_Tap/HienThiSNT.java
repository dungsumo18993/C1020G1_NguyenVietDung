package _02_Loop_.Bai_Tap;

import java.util.Scanner;

public class HienThiSNT {
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        System.out.print("Nhập số lượng SNT cần in: ");
        int number = x.nextInt();
        int count = 0;
        int N = 2;
        boolean check = true;
        while (count < number) {
            for(int i=2; i<=Math.sqrt(N); i++) {
                if (N % i == 0) {
                    check = false;
                    break;
                }
                check=true;
            }
            if(check){
                System.out.print(N+"\t");
                count++;
            }
            N++;
        }
    }
}
