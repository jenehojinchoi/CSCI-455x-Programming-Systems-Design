import java.util.Scanner;
import java.util.GregorianCalendar;

/**
   Compute time to wake up from a nap.
   
   Task: Add code using a loop to error-check that the number entered is positive.
*/
public class NapCalc {
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      // sets nap to the current time
      GregorianCalendar nap = new GregorianCalendar(); 

      System.out.print("How long of a nap do you want to take (min)? ");
      int elapsedMin = in.nextInt();
	
      nap.add(GregorianCalendar.MINUTE, elapsedMin);

      System.out.print("You will have to wake up at ");
      System.out.print(nap.get(GregorianCalendar.HOUR) + ":");
      System.out.println(nap.get(GregorianCalendar.MINUTE));
   }
}
