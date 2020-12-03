package _03_Array_.Bai_Tap;


import java.util.Arrays;
import java.util.Scanner;

public class TimGTNN {
    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int size = 5;
        int[] arr = new int[size];
        Scanner x = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1) + " : ");
            arr[i] = x.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("GT nhỏ nhất là: " + minValue(arr));
    }
}
