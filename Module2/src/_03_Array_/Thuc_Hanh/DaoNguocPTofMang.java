package _03_Array_.Thuc_Hanh;

import java.util.Scanner;

public class DaoNguocPTofMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner x = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = x.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = x.nextInt();
            i++;
        }

        System.out.printf("Elements in array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }

        System.out.printf("Reverse array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }


    }
}
