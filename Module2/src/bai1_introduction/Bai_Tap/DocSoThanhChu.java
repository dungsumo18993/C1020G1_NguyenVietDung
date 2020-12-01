package bai1_introduction.Bai_Tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        System.out.print("Nhập số: ");
        int num=x.nextInt();

        String ReadNum;
        String ReadOne;
        if(num<10){
        switch (num) {
            case 0:
                ReadNum="Zero";
                break;
            case 1:
                ReadNum="One";
                break;
            case 2:
                ReadNum="Two";
                break;
            case 3:
                ReadNum="Tree";
                break;
            case 4:
                ReadNum="Four";
                break;
            case 5:
                ReadNum="Five";
                break;
            case 6:
                ReadNum="Six";
                break;
            case 7:
                ReadNum="Seven";
                break;
            case 8:
                ReadNum="Eight";
                break;
            case 9:
                ReadNum="Nine";
                break;
            default:
                ReadNum="out of ability";
        }
            System.out.println(ReadNum);
        }else if(num<20){
            int sum=num-10;
            switch (sum){
                case 0:
                    ReadNum="Ten";
                    break;
                case 1:
                    ReadNum="eleven";
                    break;
                case 2:
                    ReadNum="twelve";
                    break;
                case 3:
                    ReadNum="Thirteen";
                    break;
                case 4:
                    ReadNum="Fourteen";
                    break;
                case 5:
                    ReadNum="Fifteen";
                    break;
                case 6:
                    ReadNum="Sixteen";
                    break;
                case 7:
                    ReadNum="Seventeen";
                    break;
                case 8:
                    ReadNum="eighteen";
                    break;
                case 9:
                    ReadNum="nineteen";
                    break;
                default:
                    ReadNum="";
            }
            System.out.println(ReadNum);
        } else if(num<100){
            int tens=num/10;
            int ones=num%10;
            switch (tens){
                case 2:
                    ReadNum="twenty ";
                    break;
                case 3:
                    ReadNum="Thirty ";
                    break;
                case 4:
                    ReadNum="Forty ";
                    break;
                case 5:
                    ReadNum="Fifty ";
                    break;
                case 6:
                    ReadNum="Sixty ";
                    break;
                case 7:
                    ReadNum="Seventy ";
                    break;
                case 8:
                    ReadNum="Eighty ";
                    break;
                case 9:
                    ReadNum="Ninety ";
                    break;
                default:
                    ReadNum="";
            }
            switch (ones){
                case 1:
                    ReadOne="one";
                    break;
                case 2:
                    ReadOne="two";
                    break;
                case 3:
                    ReadOne="three";
                    break;
                case 4:
                    ReadOne="Four";
                    break;
                case 5:
                    ReadOne="Five";
                    break;
                case 6:
                    ReadOne="six";
                    break;
                case 7:
                    ReadOne="seven";
                    break;
                case 8:
                    ReadOne="eight";
                    break;
                case 9:
                    ReadOne="Nine";
                default:
                    ReadOne="";
            }
            System.out.println(ReadNum + ReadOne);
        }

    }
}
