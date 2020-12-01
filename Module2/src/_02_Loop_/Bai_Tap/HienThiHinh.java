package _02_Loop_.Bai_Tap;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        int choice;
        Scanner x=new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter choice: ");
        choice=x.nextInt();

        String temp="";
        switch (choice){
            case 1:
                for(int i=1;i<=3;i++){
                    for(int j=1;j<=7;j++) {
                        temp+="*";
                    }
                    temp+="\n";
                }
                break;
            case 2:
                for(int i=5;i>=1;i--){
                    for (int j=1;j<=i;j++){
                        temp+="*";
                    }
                    temp+="\n";
                }
                break;
            case 3:
                for(int i=1;i<=7;i++){
                    for(int j=7;j>i; j--){
                        temp+=" ";
                    }
                    for(int z=1; z<=i; z++){
                        temp+="* ";
                    }
                    temp+="\n";
                }
                break;
            default:
                temp+="";
        }
        System.out.println(temp);
    }
}
