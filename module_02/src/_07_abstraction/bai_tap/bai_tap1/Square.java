package _07_abstraction.bai_tap.bai_tap1;

public class Square implements Resizeable{
    private double side;

    Square(){
    }

    Square(double side){
        this.side=side;
    }

    @Override
    public void resize(double percent) {
        this.side*=percent;
    }

    double area(){
        return side*side;
    }

    @Override
    public String toString() {
        return "A Square with side: "+side+", area: "+area();
    }
}
