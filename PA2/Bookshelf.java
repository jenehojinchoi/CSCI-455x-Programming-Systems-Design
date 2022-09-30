// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CSCI455 PA2
// Fall 2022

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

import java.util.ArrayList;

public class Bookshelf {

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */

   private ArrayList<Integer> bookList;

   public Bookshelf() {
      bookList = new ArrayList<Integer>();
      assert isValidBookshelf();
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      bookList = new ArrayList<Integer>();
      for (int i = 0; i < pileOfBooks.size(); i++) {
         int bookHeight = pileOfBooks.get(i);
         bookList.add(bookHeight);
      }
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      bookList.add(0, height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      bookList.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    *
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      int book = bookList.remove(0);
      assert isValidBookshelf();
      return book;
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      int book = bookList.remove(bookList.size()-1);
      assert isValidBookshelf();
      return book;
   }

   /**
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      int height = bookList.get(position);
      assert isValidBookshelf();
      return height;
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      return bookList.size();
   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      String string = "[";
      for (int i = 0; i < bookList.size(); i++) {
         if (i == bookList.size()-1){
            string += bookList.get(i);
         }
         else{
            string += bookList.get(i) + ", ";
         }
      }
      return string + "]";
   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      for (int i = 0; i < bookList.size() - 1; i++) {
         if (bookList.get(i + 1) < bookList.get(i)){
            return false;
         }
      }
      return true;
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf()  {
      for (int i = 0; i < bookList.size(); i++){
         if (bookList.get(i) <= 0){
            return false;
         }
      }
      return true;
   }
}
