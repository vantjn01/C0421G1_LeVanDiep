package _07_abstraction.thuc_hanh.Thuchanh3;
import _07_abstraction.thuc_hanh.Thuchanh2.Circle;

import java.util.Comparator;
public class CircleCoparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }

}
