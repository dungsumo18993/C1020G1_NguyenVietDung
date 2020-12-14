package _11_generic_stack_queue_.bai_tap.chuyen_doi_tu_thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println("Enter Decimal: ");
             input = scanner.nextInt();
        }while (input<0);

        while (input>0) {
           int binary = input % 2;
            input=input/2;
            stack.push(binary);
        }

        while (!stack.isEmpty()){
            System.out.printf(" %d", stack.pop());
        }
    }
}
