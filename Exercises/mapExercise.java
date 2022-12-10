import java.util.*;

public class mapExercise {
    public static void createMap() {
        Map<String, Integer> m = new TreeMap<String, Integer>();

        m.put("C", 23);
        m.put("D", 12);
        m.put("A", 24);
        m.put("B", 29);
        m.put("E", 8);

//        Iterator<Map.Entry<String, Integer>> iter = m.entrySet().iterator();
//        while (iter.hasNext()){
//            Map.Entry<String, Integer> curr = iter.next();
//            System.out.println(curr.getKey() + " " + curr.getValue());
//        }

        Comparator<Map.Entry<String,Integer>> comp = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
                return entry1.getValue() - entry2.getValue();
            }
        };

        ArrayList<Map.Entry<String,Integer>> l = new ArrayList<>(m.entrySet());
        Collections.sort(l, comp);

        for(Map.Entry<String,Integer> curr : l){
            System.out.println(curr.getKey() + " " + curr.getValue());
        }

        Iterator<Map.Entry<String, Integer>> iter = m.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, Integer> curr = iter.next();
            System.out.println(curr.getKey() + " " + curr.getValue());
        }
    }

    public static void main (String[] args) {
        createMap();
    }
}