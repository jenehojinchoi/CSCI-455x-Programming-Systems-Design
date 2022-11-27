public class forEachExercise {
    public class risk Implements BiConsumer<String, Integer> {
        public static void accept(String k, Integer score) {
            if (score<60) {
                System.out.println(score + " " + key);
            }
        }
    }
    public static void atRisk(Map<String, Integer> students){
        students.forEach(new Risk());
    }
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<String, Integer>();
        students.put("A", 90);
        students.put("B", 99);
        students.put("C", 40);
        students.put("D", 75);
        students.put("E", 55);

    }
}