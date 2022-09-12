// Name: Jene (Hojin) Choi
// USC NetId: 6640002284
// CSCI 455 PA1
// Fall 2022

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
public class CoinSimComponent extends JComponent
{
    // number of trials, number of each occurrence
    private int totalTrials;
    private int numTwoHeads;
    private int numOneHeadOneTail;
    private int numTwoTails;

    // fixed colors
    private static final Color TWO_HEADS_COLOR = Color.RED;
    private static final Color ONE_HEAD_ONE_TAIL_COLOR = Color.GREEN;
    private static final Color TWO_TAILS_COLOR = Color.BLUE;

    // fixed values
    private static final int BAR_WIDTH = 50;
    private static final int VERTICAL_BUFFER = 25;

    // constructs CoinSimComponent with the number of trials and results
    public CoinSimComponent(int numTrials)
    {
        CoinTossSimulator toss = new CoinTossSimulator();
        toss.run(numTrials);

        this.totalTrials = toss.getNumTrials();
        this.numTwoHeads = toss.getTwoHeads();
        this.numOneHeadOneTail = toss.getOneHeadOneTail();
        this.numTwoTails = toss.getTwoTails();
    }

    public void paintComponent(Graphics g)
    {
        // Recover Graphics2D. g2 becomes an enhanced version of g
        Graphics2D g2 = (Graphics2D) g;

        // necessary variables for constructing Bar:
        // int bottom, int left, int width, int applicationHeight, double scale, Color color, String label

        // bottom, width, scale are the same for all bars
        int bottom = getHeight() - VERTICAL_BUFFER;
        int width = BAR_WIDTH;
        // cast double for correct calculation
        double scale = (double) (getHeight() - 2 * VERTICAL_BUFFER) / totalTrials;

        // left: X coordinates of each bar
        // Calculate width between each bar given BAR_WIDTH
        int twoHeadsLeft = (getWidth() - 3 * BAR_WIDTH) / 4;
        int oneHeadTwoTailLeft = (getWidth() - 3 * BAR_WIDTH) / 4 * 2 + BAR_WIDTH;
        int twoTailsLeft = (getWidth() - 3 * BAR_WIDTH) / 4 * 3 + 2 * BAR_WIDTH;

        // Calculate percentages
        int percentOfTwoHeads = (int) Math.round(numTwoHeads * 100.0 / totalTrials);
        int percentOfOneHeadOneTail = (int) Math.round(numOneHeadOneTail * 100.0 / totalTrials);
        int percentOfTwoTails = (int) Math.round(numTwoTails * 100.0 / totalTrials);

        // Labels of each bar
        String labelOfTwoHeads = "Two Heads: " + numTwoHeads + " (" + percentOfTwoHeads + "%)";
        String labelOfOneHeadOneTail = "A Head and a tail: " + numOneHeadOneTail + " (" + percentOfOneHeadOneTail + "%)";
        String labelOfTwoTails = "Two Tails: " + numTwoTails + " (" + percentOfTwoTails + "%)";

        // Construct bars
        Bar barOfTwoHeads = new Bar(bottom, twoHeadsLeft, width, numTwoHeads, scale, TWO_HEADS_COLOR, labelOfTwoHeads);
        Bar barOfOneHeadOneTail = new Bar(bottom, oneHeadTwoTailLeft, width, numOneHeadOneTail, scale, ONE_HEAD_ONE_TAIL_COLOR, labelOfOneHeadOneTail);
        Bar barOfTwoTails = new Bar(bottom, twoTailsLeft, width, numTwoTails, scale, TWO_TAILS_COLOR, labelOfTwoTails);

        // draw bars
        barOfTwoHeads.draw(g2);
        barOfOneHeadOneTail.draw(g2);
        barOfTwoTails.draw(g2);
    }
}
