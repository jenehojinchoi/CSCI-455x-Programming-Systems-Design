import java.util.*;

public class linkedListExercise {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        ListIterator<String> iter = list.listIterator();

        while (iter.hasNext()) {
            String word = iter.next();
            System.out.println(word);
        }
    }
}