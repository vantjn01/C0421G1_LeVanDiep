package _08_cleanCode.thuc_hanh.thuc_hanh3;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }
    private static  double getBaseArea(int radius){
        return 2 * Math.PI * radius * radius;
    }

    private static  double getPerimeter(int radius){
        return 2 * Math.PI * radius;
    }
}
