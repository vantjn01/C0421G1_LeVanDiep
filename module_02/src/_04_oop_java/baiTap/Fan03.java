package _04_oop_java.baiTap;

public class Fan03 {
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public Fan03(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    private final int SLOW() {
        return this.speed = 1;
    }
    private final int MEDIUM() {
        return this.speed = 2;
    }
    private final int FAST() {
        return this.speed = 3;
    }
    public Fan03() {
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean isOn() {
        return on;
    }
    public void setOn(boolean on) {
        this.on = on;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        if (isOn()) {
            return "Fan is on {" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan is off {" +
                    "radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Fan03 newFan1 = new Fan03(3, true, 10, "yellow");
        newFan1.MEDIUM();
        String fan1 = newFan1.toString();
        System.out.println(fan1);
        Fan03 newFan2 = new Fan03(2, false, 5, "blue");
        String fan2 = newFan2.toString();
        System.out.println(fan2);
    }
}