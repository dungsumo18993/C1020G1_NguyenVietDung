package _13_thuat_toan_tim_kiem_.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        for (int i=0; i<string.length(); i++){
            if (list.size()>1 && string.charAt(i)<= list.getLast() && list.contains(string.charAt(i))){
                    list.clear();
            }
            list.add(string.charAt(i));

            if (list.size() > max.size()){
                max.clear();
                max.addAll(list);
            }
        }
        for (Character ch : list){
            System.out.println(ch);
        }
        System.out.println("------------------");

        for (Character ch : max){
            System.out.println(ch);
        }
    }
}
