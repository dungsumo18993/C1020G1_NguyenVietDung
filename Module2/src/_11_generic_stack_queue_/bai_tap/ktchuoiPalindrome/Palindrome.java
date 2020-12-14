package _11_generic_stack_queue_.bai_tap.ktchuoiPalindrome;

import _11_generic_stack_queue_.bai_tap.trienkhaiQueue.Solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String want to check: ");
        String string = scanner.nextLine();
        String[] str = string.split("");
        for (String element : str){
            stack.push(element);
            queue.add(element);
        }
        System.out.println(stack.pop());
        System.out.println(queue.poll());
        boolean check=true;
        for (int i=0; i<stack.size(); i++){
            if (!stack.pop().equals(queue.poll())){
                check=false;
            }
        }
        if(check){
            System.out.println("is palindrome string");
        } else {
            System.out.println("not a palindrome string");
        }
    }
}
