package bai1_introduction.Thuc_Hanh;

import java.util.Scanner;

public class GiaiPTbacnhat {
    public static void main(String[] args) {
        Scanner x= new Scanner(System.in);
        double a,b,c;

        System.out.println("a: ");
        a=x.nextDouble();
        System.out.println("b: ");
        b=x.nextDouble();
        System.out.println("c: ");
        c=x.nextDouble();

        if(a!=0){
            double answer=(c-b)/a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
