import java.io.*;

public class DiceDisplay extends Display {
    private int numSides;
    public DiceDisplay(int numSides) { this.numSides = numSides; }
    public void display(PrintStream ps, int size) { ps.println("Bar!"); }
    public void display(PrintStream ps) { ps.println("Blob!"); }
    public void display(int size) { System.out.println("Zap!"); }
    public int getNumSides() { return numSides; }
}