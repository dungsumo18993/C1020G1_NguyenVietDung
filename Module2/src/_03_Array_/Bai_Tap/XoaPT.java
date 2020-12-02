package _03_Array_.Bai_Tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPT {
    public static void delete(int[] arr, int x){
        for (int i=0;i < arr.length; i++){
            if (x == arr[i]){
                for (int j = i;j < arr.length-1;j++){
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,9,11};

        System.out.print("Truoc khi xóa: ");
        System.out.println(Arrays.toString(arr));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập PT cần xóa: ");
        int x = scanner.nextInt();
        delete(arr, x);
        System.out.println("Sau khi xóa: "+Arrays.toString(arr));
    }
}
