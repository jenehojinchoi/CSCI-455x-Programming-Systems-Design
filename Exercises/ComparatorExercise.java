import java.util.*;
import java.util.Collections;
public class ComparatorExercise {
    Comparator<Map.Entry<String,ArrayList<Integer>>> comparator = new Comparator<Map.Entry<String,ArrayList<Integer>>>() {
        @Override
        public int compare(Map.Entry<String,ArrayList<Integer>> obj1, Map.Entry<String,ArrayList<Integer>> obj2){
            return obj2.getValue().size() - obj1.getValue().size();
        }
    };

    public static void printList(ArrayList<Integer> arr){
        String s = "";
        for (int el: arr) {
            s += el + " ";
        }
        System.out.println(s);
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> m = new HashMap<String, ArrayList<Integer>>();

        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,2,3,5));
        ArrayList<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(1,2,3,10,11));
        ArrayList<Integer> arr4 = new ArrayList<Integer>(Arrays.asList(1));

        String[] keys = {"A", "B", "C", "D"};

        m.put(keys[0], arr1);
        m.put(keys[1], arr2);
        m.put(keys[2], arr3);
        m.put(keys[3], arr4);

        for (Map.Entry<String, ArrayList<Integer>> curr : m.entrySet()) {
            System.out.println(curr.getKey() + " " + curr.getValue().size());
            printList(curr.getValue());
        }

        List<String, ArrayList<Integer>> mSet = new ArrayList<>(map.entrySet());
        Collections.sort(mSet, comparator);

        for (Map.Entry<String, ArrayList<Integer>> curr : m.entrySet()) {
            System.out.println(curr.getKey() + " " + curr.getValue().size());
            printList(curr.getValue());
        }
    }
}