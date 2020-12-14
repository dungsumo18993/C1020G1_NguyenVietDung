package _11_generic_stack_queue_.bai_tap.DaoNguocPTSDStack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr={1,2,3,4,5};
        for(int element:arr){
            stack.push(element);
        }
        System.out.println("Trước khi xếp: "+ stack);
        for (int index=0; index<arr.length; index++){
            arr[index]=stack.pop();
        }
        System.out.println("Sau khi đảo: "+ Arrays.toString(arr));
    }
}
