package _07_abstraction.bai_tap.bai_tap1;

import _06_inheritance.thuc_hanh.Shape;

public class Rectangle implements Resizeable {
    double side1, side2;

    Rectangle(){
    }

    Rectangle(double side1, double side2){
        this.side1=side1;
        this.side2=side2;
    }

    double area(){
        return side1*side2;
    }

    @Override
    public void resize(double percent) {
        this.side2*=percent;
        this.side1*=percent;
    }

    @Override
    public String toString() {
        return "A Rectangle with side1: "+side1+", side2: "+side2+", area: "+area();
    }

}
