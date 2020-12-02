package _03_Array_.Bai_Tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int[] arr = new int[5];
        int n = arr.length;
        int i = 0;
        int[] arr1 = new int[5];
        int n1 = arr1.length;
        while (i < n) {
            System.out.println("Thêm GT " + (i + 1) + ": ");
            arr[i] = x.nextInt();
            arr1[i]=x.nextInt();
            i++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        int[] arr2=new int[n+n1];
        for (int j=0; j<n; j++){
            arr2[j]=arr[j];
        }
        for (int k=0; k<n1; k++){
            arr2[arr1.length+k]=arr1[k];
        }
        System.out.println("Mảng mới khi gộp lại là: "+Arrays.toString(arr2));
    }

}
