// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CS 455 PA3
// Fall 2022

import java.util.Random;

/**
 MineField
 class with locations of mines for a game.
 This class is mutable, because we sometimes need to change it once it's created.
 mutators: populateMineField, resetEmpty
 includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {

   // <put instance variables here>
   private boolean[][] mines;
   private int numRows;
   private int numCols;
   private int numMines;

   /**
    Create a minefield with same dimensions as the given array, and populate it with the mines in the array
    such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
    this minefield will corresponds to the number of 'true' values in mineData.
    @param mineData  the data for the mines; must have at least one row and one col,
    and must be rectangular (i.e., every row is the same length)
    */
   public MineField(boolean[][] mineData) {
      assert isValidMineField(mineData);

      numRows = mineData.length;
      numCols = mineData[0].length;
      mines = new boolean[numRows][numCols];

      numMines = 0;
      for (int i = 0; i < numRows; i++) {
         for (int j = 0; j < numCols; j++) {
            if (mineData[i][j]) {
               numMines++;
               mines[i][j] = true;
            }
         }
      }
   }


   /**
    Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once
    populateMineField is called on this object).  Until populateMineField is called on such a MineField,
    numMines() will not correspond to the number of mines currently in the MineField.
    @param numRows  number of rows this minefield will have, must be positive
    @param numCols  number of columns this minefield will have, must be positive
    @param numMines   number of mines this minefield will have,  once we populate it.
    PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations).
    */
   public MineField(int numRows, int numCols, int numMines) {
      assert isValidRowsCols(numRows, numCols);
      int numTotalField = numRows * numCols;
      assert isValidNumMines(numMines, numTotalField);
      this.numRows = numRows;
      this.numCols = numCols;
      this.numMines = numMines;

      mines = new boolean[this.numRows][this.numCols];
   }


   /**
    Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
    ensuring that no mine is placed at (row, col).
    @param row the row of the location to avoid placing a mine
    @param col the column of the location to avoid placing a mine
    PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
    */
   public void populateMineField(int row, int col) {
      assert inRange(row, col);

      // Removes any current mines on the minefield
      resetEmpty();

      Random random = new Random();
      int numNewMines = 0;

      while (numNewMines < numMines) {
         int randRow = random.nextInt(numRows);
         int randCol = random.nextInt(numCols);

         // If the generated position has a mine already OR is at (row, col) => loop again to generate a new random position
         // Otherwise => put a new mine there
         if (hasMine(randRow, randCol) || (randRow == row && randCol == col)) {
            continue;
         } else {
            mines[randRow][randCol] = true;
            numNewMines++;
         }
      }
   }


   /**
    Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
    Thus, after this call, the actual number of mines in the minefield does not match numMines().
    Note: This is the state a minefield created with the three-arg constructor is in
    at the beginning of a game.
    */
   public void resetEmpty() {
      mines = new boolean[numRows][numCols];
   }


   /**
    Returns the number of mines adjacent to the specified mine location (not counting a possible
    mine at (row, col) itself).
    Diagonals are also considered adjacent, so the return value will be in the range [0,8]
    @param row  row of the location to check
    @param col  column of the location to check
    @return  the number of mines adjacent to the square at (row, col)
    PRE: inRange(row, col)
    */
   public int numAdjacentMines(int row, int col) {
      assert inRange(row, col);
      int numAdjMines = 0;

      for (int i = row-1; i <= row+1; i++) {
         for (int j = col-1; j <= col+1; j++) {
            if (i == row && j == col || inRange(i, j) == false) {
               continue;
            }
            if (hasMine(i, j)) {
               numAdjMines++;
            }
         }
      }
      return numAdjMines;
   }


   /**
    Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
    start from 0.
    @param row  row of the location to consider
    @param col  column of the location to consider
    @return whether (row, col) is a valid field location
    */
   public boolean inRange(int row, int col) {
      if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
         return false;
      } else {
         return true;
      }
   }


   /**
    Returns the number of rows in the field.
    @return number of rows in the field
    */
   public int numRows() {
      return numRows;
   }


   /**
    Returns the number of columns in the field.
    @return number of columns in the field
    */
   public int numCols() {
      return numCols;
   }


   /**
    Returns whether there is a mine in this square
    @param row  row of the location to check
    @param col  column of the location to check
    @return whether there is a mine in this square
    PRE: inRange(row, col)
    */
   public boolean hasMine(int row, int col) {
      assert inRange(row, col);
      return mines[row][col];
   }


   /**
    Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
    some of the time this value does not match the actual number of mines currently on the field.  See doc for that
    constructor, resetEmpty, and populateMineField for more details.
    * @return number of mines
    */
   public int numMines() {
      return numMines;
   }


   /**
    Returns true if input mineData is valid, else false
    * @return whether mineData is valid
    */
   private boolean isValidMineField(boolean[][] mineData) {
      if (mineData.length >= 1 && mineData[0].length >= 1) {
         return true;
      } else {
         return false;
      }
   }

   /**
    Returns true if numRows and numCols are positive numbers
    * @return whether numRows and numCols are all valid
    */
   private boolean isValidRowsCols(int numRows, int numCols) {
      if (numRows > 0 && numCols > 0) {
         return true;
      } else {
         return false;
      }
   }

   /**
    Returns true if number of mines is within valid range [0, totalField/3]
    * @return whether number of mines is valid
    */
   private boolean isValidNumMines(int numMines, int numTotalField) {
      double limit = numTotalField / 3.0;
      if (0 <= numMines && numMines < limit) {
         return true;
      } else {
         return false;
      }
   }
}

