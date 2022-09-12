// Name: Jene (Hojin) Choi
// USC NetId: 6640002284
// CSCI 455 PA1
// Fall 2022

import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer
{
    // gets valid user input and return the number of trials
    public static int getNumTrials()
    {
        Scanner in = new Scanner(System.in);
        int numTrials = 0;

        // loop until it returns numTrials
        while (true) {
            System.out.print("Enter number of trials: ");
            numTrials = in.nextInt();

            if (numTrials >= 1)  {
                // if valid return numTrials
                return numTrials;
            } else {
                // if not valid return error message
                System.out.println("ERROR: Number entered must be greater than 0.");
            }
        }
    }

    private static void generateGraphics(int numTrials)
    {
        // creates JFrame component
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // uses CoinSimComponent for creating frame
        CoinSimComponent component = new CoinSimComponent(numTrials);
        frame.add(component);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        int numTrials = getNumTrials();
        generateGraphics(numTrials);
    }
}
