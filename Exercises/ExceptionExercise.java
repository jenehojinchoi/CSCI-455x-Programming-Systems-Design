import java.io.*;
import java.util.*;

public class ExceptionExercise {
    public static void main(String[] args) {
        int num = 10;
        try {
            System.out.println("Opening file...");
            Scanner inFile = new Scanner(new File("data.txt"));
            int inVal = inFile.nextInt();
            num += inVal;
        }
        catch (NoSuchElementException exc) {
            System.out.println("Problem with file");
        }
        catch (FileNotFoundException exc) {
            System.out.println("File not found");
        }
        System.out.println(num);
        System.out.println("Exiting program");
    }
}