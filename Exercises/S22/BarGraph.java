import java.io.PrintStream;

public class BarGraph extends Graph {
    private int numBars;
    public BarGraph (int numBars) {
        this.numBars = numBars;
    }
    public void show (PrintStream ps, int size) {
        ps.println("Littlefinger");
    }
    public void show (PrintStream ps) {
        ps.println("Tyrion");
    }
    public void show (int size){
        System.out.println("Arya");
    }
    public int getNumBars() {
        return numBars;
    }

    public static void main(String[] args){
//        Graph graph1 = new BarGraph(5);
//        graph1.show(System.out);
//
//        Graph graph2 = new Graph();
//        graph2.show(System.out);

//        Graph graph3 = new BarGraph(5);
//        System.out.println(graph3.getNumBars());

//        BarGraph graph4 = new BarGraph(5);
//        graph4.show(System.out);

//        Graph graph5 = new BarGraph();
//        graph5.show(32);

//        BarGraph graph6 = new BarGraph(5);
//        System.out.println(graph6.getNumBars());

//        // bonus
//        BarGraph graph7 = new BarGraph(5);
//        graph7.show(System.out, 10);
//
//        // bonus
        Graph graph8 = new BarGraph(5);

        Graph graph9 = new BarGraph(5);
        System.out.println(graph8.equals(graph9));
        System.out.println(graph8 == graph9);
    }
}