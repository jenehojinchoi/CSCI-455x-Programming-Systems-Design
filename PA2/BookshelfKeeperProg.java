// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CSCI455 PA2
// Fall 2022

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main program that prompts for input from user.
 * Calls the corresponding methods in Bookshelf and BookshelfKeeper class to maintain books.
 * Allows only valid operations to be performed on the Bookshelf.
 */
public class BookshelfKeeperProg {
   public static void main(String[] args) {
      System.out.println("Please enter initial arrangement of books followed by newline:");

      Scanner in = new Scanner(System.in);
      ArrayList<Integer> initialBookList = new ArrayList<Integer>();
      initialBookList = getInitialBookList(in);

      if (!isValidBookshelf(initialBookList)) {
         return;
      }

      Bookshelf bookList = new Bookshelf(initialBookList);
      BookshelfKeeper bookKeeper = new BookshelfKeeper(bookList);

      System.out.println(bookKeeper.toString());
      System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");

      processOperations(in, bookKeeper);
      System.out.println("Exiting Program.");
   }



   /**
    * Helper method to process operations pick, put, and end.
    * Includes checking for validity of operations, input numbers.
    * @param in the scanner object to get input.
    * @param bookKeeper the BookshelfKeeper object upon which the above operations are performed.
    */
   private static void processOperations(Scanner in, BookshelfKeeper bookKeeper){
      String operation;
      Scanner stringScanner;

      while (true) {
         operation = in.nextLine();
         stringScanner = new Scanner(operation);
         operation = stringScanner.next();

         if (!isValidOperation(operation) || operation.equals("end")) {
            return;
         }

         int n = stringScanner.nextInt();

         if (operation.equals("put")) {
            if (!isValidHeight(n)) {
               return;
            } else {
               bookKeeper.putHeight(n);
            }
         } else { // operation.equals("pick")
            if (!isValidPosition(n, bookKeeper)) {
               return;
            } else {
               bookKeeper.pickPos(n);
            }
         }
         System.out.println(bookKeeper.toString());
      }
   }

   /**
    * Static method to create a temporary book pile with the input of book height lists
    * @param in - the scanner object to receive input from console.
    * @return - ArrayList of Integers (book heights).
    */
   private static ArrayList<Integer> getInitialBookList(Scanner in){
      String inputLine = in.nextLine();
      Scanner stringScanner = new Scanner(inputLine);
      ArrayList<Integer> initialBookList = new ArrayList<Integer>();

      while (stringScanner.hasNextInt()){
         initialBookList.add(stringScanner.nextInt());
      }
      return initialBookList;
   }

   /**
    * Helper method to check validity of initial input of book array entered.
    * @param initialBookList the books entered.
    * @return true if the configuration is valid else false.
    */
   private static boolean isValidBookshelf(ArrayList<Integer> initialBookList) {
      for (int i = 0; i < initialBookList.size(); i++){
         if (initialBookList.get(i) <= 0){
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return false;
         }
      }
      for (int i = 0; i < initialBookList.size() - 1; i++) {
         if (initialBookList.get(i + 1) < initialBookList.get(i)){
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
            System.out.println("Exiting Program.");
            return false;
         }
      }
      return true;
   }

   /**
    * Helper method to check validity of operation
    * Operation should either be pick, put, or end to be valid
    * @param operation
    * @return true if the operation is valid else false.
    */
   private static boolean isValidOperation(String operation) {
      if (!operation.equals("pick") && !operation.equals("put") && !operation.equals("end")) {
         System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
         return false;
      }
      return true;
   }

   /**
    * Helper method to check validity of height to add to the book pile
    * Height should be positive integer.
    * @param height
    * @return true if the operation is valid else false.
    */
   private static boolean isValidHeight(int height) {
      if (height <= 0){
         System.out.println("ERROR: Height of a book must be positive.");
         return false;
      }
      return true;
   }

   /**
    * Helper method to check validity of position to pick
    * Position should be within [0, size of bookshelf]
    * @param position, bookShelf
    * @return true if the position is valid else false.
    */
   private static boolean isValidPosition(int position, BookshelfKeeper bookKeeper) {
      if (position < 0 || position >= bookKeeper.getNumBooks()){
         System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
         return false;
      }
      return true;
   }
}