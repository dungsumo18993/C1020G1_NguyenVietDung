package _11_generic_stack_queue_.bai_tap.DaoNguocPTSDStack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String strings="Code Gym Da Nang";
        String[] str = strings.split(" ");
//        System.out.println(Arrays.toString(str));
        strings=" ";
        for (String element : str){
            stack.push(element);
        }
        System.out.println("Trước khi xếp: "+stack);
        for (int index=0; index<str.length; index++){
            strings+=stack.pop()+" ";
        }
        System.out.println("Sau khi đảo: "+strings);
    }
}
