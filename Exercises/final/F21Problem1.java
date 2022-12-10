import java.util.*;

public class F21Problem1 {
    public static void main(String[] args) {
        Names theNames = new Names();
        theNames.insert("Joe");
        theNames.insert("Bob");
        theNames.insert("Sally");
        System.out.println(theNames.numNames());
        ArrayList<String> temp = theNames.getNames();
        temp.add("Sally");
        System.out.println(theNames.numNames());
    }
}