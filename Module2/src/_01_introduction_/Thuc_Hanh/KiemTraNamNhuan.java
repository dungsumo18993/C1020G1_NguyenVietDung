package bai1_introduction.Thuc_Hanh;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner x= new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year=x.nextInt();

        boolean isLeapYear=false;
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    isLeapYear=true;
                }
            } else {
                isLeapYear=true;
            }
        }
        if(isLeapYear){
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }
}
