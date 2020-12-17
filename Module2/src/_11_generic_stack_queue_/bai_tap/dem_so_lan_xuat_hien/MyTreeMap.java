package _11_generic_stack_queue_.bai_tap.dem_so_lan_xuat_hien;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a string: ");
        String[] strings = input.nextLine().split(" ");
//        for (int i=0; i<size; i++){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("input string: ");
//            strings[i]=scanner.nextLine();
//        }
        System.out.println(Arrays.toString(strings));

        Map<String,Integer> map = new TreeMap();
        for (int i=0; i<strings.length; i++){
            if (map.containsKey(strings[i])){
                map.put(strings[i], map.get(strings[i])+1);
            } else {
                map.put(strings[i],1);
            }
        }
        System.out.println(map);
    }
}
