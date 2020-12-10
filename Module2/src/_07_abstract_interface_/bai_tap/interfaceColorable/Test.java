package _07_abstract_interface_.bai_tap.interfaceColorable;

import _06_inheritance_.thuc_hanh.Square;

public class Test {
    public static void main(String[] args) {
        Square[] array=new Square[3];
        array[0]=new SquareColorable();
        array[1]=new SquareColorable(4);
        array[2]=new SquareColorable(5,"red",false);

        for (Square square: array){
            System.out.println(square);
            if (square instanceof SquareColorable){
                System.out.println(((SquareColorable) square).howToColor());
            }
        }
    }
}
