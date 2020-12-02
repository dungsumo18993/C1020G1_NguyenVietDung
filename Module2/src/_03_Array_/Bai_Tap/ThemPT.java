package _03_Array_.Bai_Tap;


import java.util.Arrays;
import java.util.Scanner;

public class ThemPT {
    public static void main(String[] args) {
        int[] arr={1,3,5,4,2};
        int N = arr.length;
        System.out.println("Trước khi thêm: ");
        System.out.println(Arrays.toString(arr));

        Scanner x=new Scanner(System.in);
        System.out.println("Nhập PT muốn thêm: ");
        int num=x.nextInt();
        System.out.println("Nhập vị trí muốn thêm: ");
        int index=x.nextInt();

        int[] arr2 = new int[N + 1];
        for (int i = 0;i < N;i++){
            arr2[i] = arr[i];
            //Gắn PT từ arr vào arr2
        }
        arr2[N] = num;
        int temp;
        for (int i = index; i < arr.length;i++){
            temp = arr2[i];
            arr2[i] = arr2[arr2.length - 1];
            arr2[arr2.length - 1] = temp;
        }
        System.out.println(Arrays.toString(arr2));
    }
}

