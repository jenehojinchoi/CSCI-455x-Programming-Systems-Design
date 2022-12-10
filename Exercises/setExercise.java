import java.util.*;
import java.awt.Point;

public class setExercise {
    public static void uniqueWords(String[] words) {
        Set<String> s = new HashSet<String>();

        int i = 0;
        while (i < words.length) {
            String a = words[i];
            s.add(a);
            i++;
        }

        Iterator<String> iter = s.iterator();
        while (iter.hasNext()) {
            String word = iter.next();
            System.out.println(word);
        }
    }

    public static void tryThis() {
        Set<Point> setOfPoints = new HashSet<Point>();
        Point p = new Point(3, 5);
        setOfPoints.add(p);
        p.translate(10, 20);

        Iterator<Point> iter = setOfPoints.iterator();
        while (iter.hasNext()) {
            Point pp = iter.next();
            System.out.println(pp);
        }
    }

}