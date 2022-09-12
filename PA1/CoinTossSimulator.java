// Name: Jene (Hojin) Choi
// USC NetId: 6640002284
// CSCI 455 PA1
// Fall 2022


/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;

public class CoinTossSimulator {
   private static int HEADS = 0;
   private static int TAILS = 1;

   private int totalTrials;
   private int numTwoHeads;
   private int numTwoTails;
   private int numOneHeadOneTail;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      totalTrials = 0;
      numTwoHeads = 0;
      numTwoTails = 0;
      numOneHeadOneTail = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      // generate random number
      Random randomNum = new Random();

      // until i reaches numTrials-1, toss 2 coins
      for (int i=0; i < numTrials; i++) {
         // num1, num2 is either 0 or 1
         int num1 = randomNum.nextInt(2);
         int num2 = randomNum.nextInt(2);

         if (num1 == HEADS && num2 == HEADS) {
            numTwoHeads += 1;
         } else if (num1 == TAILS && num2 == TAILS) {
            numTwoTails += 1;
         } else {
            numOneHeadOneTail += 1;
         }
      }
      totalTrials += numTrials;
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return totalTrials;
   }

   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
      return numTwoHeads;
   }

   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return numTwoTails;
   }

   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getOneHeadOneTail() {
      return numOneHeadOneTail;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      // get everything back to 0
      totalTrials = 0;
      numTwoHeads = 0;
      numTwoTails = 0;
      numOneHeadOneTail = 0;
   }
}
