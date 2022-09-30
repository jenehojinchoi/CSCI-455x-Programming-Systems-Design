// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CSCI455 PA2
// Fall 2022

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class  BookshelfKeeper {

   /**
    Representation invariant:
    The books in a BookshelfKeeper object are always stored in non-decreasing order.
    */

   Bookshelf sortedBookList;
   Bookshelf tempBookList;
   private int totalNumCalls;
   private int lastNumCalls;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      sortedBookList = new Bookshelf();
      tempBookList = new Bookshelf();
      totalNumCalls = 0;
      lastNumCalls = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      assert sortedBookshelf.isSorted();
      sortedBookList = sortedBookshelf;
      tempBookList = new Bookshelf();
      totalNumCalls = 0;
      lastNumCalls = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted
    * after picking up the book.
    *
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    *
    * PRE: position must be in the range [0, getNumBooks()).
    */
   public int pickPos(int position) {
      int numCalls = 0;

      // compare the position with the middle element to determine whether to start from front or end
      // start from front
      if (position < sortedBookList.size() / 2) {
         numCalls = removeBookFromFront(position);
         sortedBookList.removeFront();
         numCalls += addBookFromFront();
      }
      // start from end
      else {
         numCalls = removeBookFromEnd(position);
         sortedBookList.removeLast();
         numCalls += addBookFromEnd();
      }

      numCalls += 1;
      totalNumCalls += numCalls;
      lastNumCalls = numCalls;

      assert isValidBookshelfKeeper();

      return numCalls;
   }


   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted
    * after the insertion.
    *
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    *
    * PRE: height > 0
    */
   public int putHeight(int height) {
      int numCalls = 0;
      int mid = sortedBookList.size() / 2;

      // find position where height can be inserted into
      int position = findPositionToInsert(height);
      System.out.println(position);

      // conditionals
      if (position == sortedBookList.size()) {
         sortedBookList.addLast(height);
      } else if (position == 0) {
         sortedBookList.addFront(height);
      } else {
         if (position <= mid) {
            int temp = 0;
            while (temp != position) {
               numCalls += 1;
               int element = sortedBookList.removeFront();
               tempBookList.addLast(element);
               temp ++;
            }
            sortedBookList.addFront(height);
            numCalls += addBookFromFront();
         } else {
            int temp = sortedBookList.size();
            while (temp != position) {
               numCalls += 1;
               int element = sortedBookList.removeLast();
               tempBookList.addFront(element);
               temp --;
            }
            sortedBookList.addLast(height);
            numCalls += addBookFromEnd();
         }
      }
      numCalls += 1;
      totalNumCalls += numCalls;
      lastNumCalls = numCalls;
      assert isValidBookshelfKeeper();
      return numCalls;
   }


   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      return totalNumCalls;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      return sortedBookList.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed
    * by the number of bookshelf mutator calls made to perform the last pick or put operation,
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    *
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    *
    */
   public String toString() {
      return sortedBookList.toString() + " " + lastNumCalls + " " + totalNumCalls;
   }
   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      return sortedBookList.isSorted();
   }

   /**
    * Helper method to add element from left-end using temporary book list
    * @return the number of calls to mutator functions.
    */
   private int addBookFromFront(){
      int numCalls = 0;
      while (tempBookList.size() > 0){
         int elementToAdd = tempBookList.removeLast();
         sortedBookList.addFront(elementToAdd);
         numCalls += 1;
      }
      return numCalls;
   }

   /**
    * Helper method to add element from right-end using temporary book list
    * @return the number of calls to mutator functions.
    */
   private int addBookFromEnd(){
      int numCalls = 0;
      while (tempBookList.size() > 0){
         int elementToAdd = tempBookList.removeFront();
         sortedBookList.addLast(elementToAdd);
         numCalls += 1;
      }
      return numCalls;
   }

   /**
    * Helper method to remove element from left-end using temporary book list to store elements
    * @param pos position until which books are removed.
    * @return the number of calls to mutator functions.
    */
   private int removeBookFromFront(int pos){
      int numCalls = 0;
      for (int i=0; i < pos; i++){
         numCalls += 1;
         int element = sortedBookList.removeFront();
         tempBookList.addLast(element);
      }
      return numCalls;
   }

   /**
    * Helper method to remove element from right-end using temporary book list to store elements
    * @param pos position until which books are removed.
    * @return the number of calls to mutator functions.
    */
   private int removeBookFromEnd(int pos){
      int numCalls = 0;
      for (int i = sortedBookList.size()-1; i > pos; i--){
         numCalls += 1;
         int element = sortedBookList.removeLast();
         tempBookList.addFront(element);
      }
      return numCalls;
   }

   /**
    * Helper method to find a position where height can be inserted to.
    * @param height to add to the bookshelf
    * @return int position to insert
    */
   private int findPositionToInsert(int height) {
      // find a position to insert height starting from front.
      int insertPosition = searchInsert(height);

      int firstOccurrence = findOccurrence(height, true);

      // if there is no duplicate height in sortedBookPile
      if (firstOccurrence == -1) {
         return insertPosition;
      }

      // if there is first occurrence, find last occurrence
      int lastOccurrence = findOccurrence(height, false);

      if (firstOccurrence > sortedBookList.size()-1-lastOccurrence) {
         return lastOccurrence + 1;
      } else {
         return firstOccurrence;
      }
   }

   /**
    * Helper method to find first or last occurrence of height in sortedBookPile
    * @param height, isFirstOccurrence. isFirstOccurrence is true when looking for first occurrence.
    * @return int index
    */
   private int findOccurrence(int height, boolean isFirstOccurrence) {
      int N = sortedBookList.size();
      int begin = 0, end = N - 1;

      while (begin <= end) {
         int mid = (begin + end) / 2;
         if (sortedBookList.getHeight(mid) == height) {
            if (isFirstOccurrence) {
               if (mid == begin || sortedBookList.getHeight(mid+1) != height) {
                  return mid;
               }
               end = mid - 1;
            } else {
               if (mid == end || sortedBookList.getHeight(mid+1) != height) {
                  return mid;
               }
               begin = mid + 1;
            }
         } else if (sortedBookList.getHeight(mid) > height) {
            end = mid - 1;
         } else {
            begin = mid + 1;
         }
      }
      return -1;
   }

   /**
    * Helper method to find an insert position
    * @param height to add to sortedBookPile
    * @return int index
    */
   public int searchInsert(int height) {
      int mid = 0;
      int left = 0, right = sortedBookList.size() - 1;

      while (left <= right) {
         mid = left + (right - left) / 2;
         if (sortedBookList.getHeight(mid) == height) {
            return mid;
         }
         if (height < sortedBookList.getHeight(mid)) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return left;
   }
}