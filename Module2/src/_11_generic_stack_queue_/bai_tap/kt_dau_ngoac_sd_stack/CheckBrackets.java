package _11_generic_stack_queue_.bai_tap.kt_dau_ngoac_sd_stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        Stack bstack = new Stack();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Expression want to check: ");
        String string = scanner.nextLine();
        String[] str = string.split("");
        System.out.println(Arrays.toString(str));
        for (int i=0; i<str.length; i++){
            if (str[i].equals("(")){
                bstack.push(str[i]);
            }
            if (str[i].equals(")")){
                bstack.pop();
            }
        }

        if (bstack.isEmpty()){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
