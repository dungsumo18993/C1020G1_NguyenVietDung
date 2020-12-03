package _04_class_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a,b,c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant(){
        double delta=(this.b*this.b)-(4*this.a*this.c);
        return delta;
    }

    public double getRoot1(){
        double r1=((-this.b)+(Math.sqrt(getDiscriminant())))/(2*this.a);
        return r1;
    }
    public double getRoot2(){
        double r2=((-this.b)-(Math.sqrt(getDiscriminant())))/(2*this.a);
        return r2;
    }

    public double getRoot3(){
        return -this.b/2*this.a;
    }

    public String getRoot4(){
        return "The equation has no roots";
    }


    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        System.out.println("Nhập a: ");
        double a=x.nextDouble();
        System.out.println("Nhập b: ");
        double b=x.nextDouble();
        System.out.println("Nhập c: ");
        double c=x.nextDouble();

        QuadraticEquation equation=new QuadraticEquation(a,b,c);
        if (equation.getDiscriminant()>0){
            System.out.println("The equation has two roots "+equation.getRoot1()+" and "+equation.getRoot2());
        } else if (equation.getDiscriminant()==0){
            System.out.println("The equation has one root "+equation.getRoot3());
        } else {
            System.out.println(equation.getRoot4());
        }

    }
}
