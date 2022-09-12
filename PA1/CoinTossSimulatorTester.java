// Name: Jene (Hojin) Choi
// USC NetId: 6640002284
// CSCI 455 PA1
// Fall 2022

import java.util.Scanner;

public class CoinTossSimulatorTester {
   public static void main(String[] args) {
      CoinTossSimulator toss = new CoinTossSimulator();

      // test 1: After constructor
      System.out.println("\nAfter constructor:");
      System.out.println("Number of trials [exp:0]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses " + toss.getOneHeadOneTail());

      // test 2: After run 1
      toss.run(1);
      System.out.println("\nAfter run(1):");
      System.out.println("Number of trials [exp:1]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + toss.getOneHeadOneTail());
      System.out.println("Tosses add up correctly? " + (toss.getTwoHeads() + toss.getTwoTails()
              + toss.getOneHeadOneTail() == toss.getNumTrials()));

      // test 3: After run 10
      toss.run(10);
      System.out.println("\nAfter run(10):");
      System.out.println("Number of trials [exp:10]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + toss.getOneHeadOneTail());
      System.out.println("Tosses add up correctly? " + (toss.getTwoHeads() + toss.getTwoTails()
              + toss.getOneHeadOneTail() == toss.getNumTrials()));

      // test 4: After run 100
      toss.run(100);
      System.out.println("\nAfter run(100):");
      System.out.println("Number of trials [exp:100]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + toss.getOneHeadOneTail());
      System.out.println("Tosses add up correctly? " + (toss.getTwoHeads() + toss.getTwoTails()
              + toss.getOneHeadOneTail() == toss.getNumTrials()));

      // test 5: After run 999
      toss.run(999);
      System.out.println("\nAfter run(999):");
      System.out.println("Number of trials [exp:999]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + toss.getOneHeadOneTail());
      System.out.println("Tosses add up correctly? " + (toss.getTwoHeads() + toss.getTwoTails()
              + toss.getOneHeadOneTail() == toss.getNumTrials()));

      // test 6: After reset
      toss.reset();
      System.out.println("\nAfter reset:");
      System.out.println("Number of trials [exp:0]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + toss.getOneHeadOneTail());
      System.out.println("Tosses add up correctly? " + (toss.getTwoHeads() + toss.getTwoTails()
              + toss.getOneHeadOneTail() == toss.getNumTrials()));

      // test 7: After run 1000
      toss.run(1000);
      System.out.println("\nAfter run(1000):");
      System.out.println("Number of trials [exp:1000]: " + toss.getNumTrials());
      System.out.println("Two-head tosses: " + toss.getTwoHeads());
      System.out.println("Two-tail tosses: " + toss.getTwoTails());
      System.out.println("One-head one-tail tosses: " + toss.getOneHeadOneTail());
      System.out.println("Tosses add up correctly? " + (toss.getTwoHeads() + toss.getTwoTails()
              + toss.getOneHeadOneTail() == toss.getNumTrials()));

   }
}