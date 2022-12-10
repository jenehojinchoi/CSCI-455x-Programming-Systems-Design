import java.util.Scanner;
import java.util.GregorianCalendar;

/**
   Compute time to wake up from a nap.
   Error-checks that the elapsed time entered is non-negative.
   
   Version showing repeated prompt-read solution to loop-and-a-half problem.
   See Section 6.5 and Special topic 6.3 in text for more information about
   loop-and-a-half.

*/
public class NapCalcWhile {
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      // sets nap to the current time
      GregorianCalendar nap = new GregorianCalendar(); 

      boolean validated = false;
      
      System.out.print("How long of a nap do you want to take (min)? ");
      int elapsedMin = in.nextInt();

      while (elapsedMin < 0) {  // enter loop if error condition
         
         System.out.println("ERROR: minutes must be non-negative.");
  
         // prompt and read right before the loop test
         System.out.print("How long of a nap do you want to take (min)? ");
         elapsedMin = in.nextInt();

      }
	
      nap.add(GregorianCalendar.MINUTE, elapsedMin);

      System.out.print("You will have to wake up at ");
      System.out.print(nap.get(GregorianCalendar.HOUR) + ":");
      System.out.println(nap.get(GregorianCalendar.MINUTE));
   }
}
