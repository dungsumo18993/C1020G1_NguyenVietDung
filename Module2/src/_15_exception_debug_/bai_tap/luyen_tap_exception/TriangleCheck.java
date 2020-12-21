package _15_exception_debug_.bai_tap.luyen_tap_exception;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleCheck {

    public static void TriangleCheck (int a,int b, int c) throws IllegalTriangleException {

        if (a<=0 || b<=0 || c<=0 || a+b<c || a+c<b || b+c<a){
            throw new IllegalTriangleException();
        }
        System.out.println("This is a triangle !!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a: ");
        int a = scanner.nextInt();

        System.out.println("Input b: ");
        int b = scanner.nextInt();

        System.out.println("Input c: ");
        int c = scanner.nextInt();

         try {
             TriangleCheck(a,b,c);
         } catch (IllegalTriangleException e){
             e.printStackTrace();
         }
//        TriangleCheck triangleCheck = null;
//        boolean flag;
//        do {
//            flag = true;
//            try {
//                System.out.println("Input a: ");
//                int a = scanner.nextInt();
//
//                System.out.println("Input b: ");
//                int b = scanner.nextInt();
//
//                System.out.println("Input c: ");
//                int c = scanner.nextInt();
//
//                triangleCheck = new TriangleCheck(a,b,c);
//            } catch (InputMismatchException | IllegalTriangleException msg) {
//                flag = false;
//                System.err.println("Nhập k hợp lệ");
//                scanner.nextLine();
//            }
//        }while (!flag);


    }
}
