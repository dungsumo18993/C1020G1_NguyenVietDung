package _07_abstract_interface_.bai_tap.interfaceColorable;

import _06_inheritance_.thuc_hanh.Square;

public class SquareColorable extends Square implements Colorable{
    public SquareColorable() {
    }

    public SquareColorable(double side) {
        super(side);
    }

    public SquareColorable(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    @Override
    public String toString() {
        return "A SquareColorable with side="
                + getSide() +
                " ,color=" + getColor()+
                " ,filled=" + isFilled();
    }

    @Override
    public String howToColor() {
        return "Color all four sides...";
    }
}
