import java.awt.*;
import java.util.*;

public class problem2 {
    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList<>();
        Point myPoint = new Point(1,1);
        list.add(myPoint);
        myPoint.translate(2,2);
        System.out.println(list.get(0) + " " + myPoint);
        myPoint = new Point(10,10);
        System.out.println(list.get(0) + " " + myPoint);
    }
}