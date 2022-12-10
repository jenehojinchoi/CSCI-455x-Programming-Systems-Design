// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CS 455 PA3
// Fall 2022

/**
 VisibleField class
 This is the data that's being displayed at any one point in the game (i.e., visible field, because it's what the
 user can see about the minefield). Client can call getStatus(row, col) for any square.
 It actually has data about the whole current state of the game, including
 the underlying mine field (getMineField()).  Other accessors related to game status: numMinesLeft(), isGameOver().
 It also has mutators related to actions the player could do (resetGameDisplay(), cycleGuess(), uncover()),
 and changes the game state accordingly.

 It, along with the MineField (accessible in mineField instance variable), forms
 the Model for the game application, whereas GameBoardPanel is the View and Controller in the MVC design pattern.
 It contains the MineField that it's partially displaying.  That MineField can be accessed (or modified) from
 outside this class via the getMineField accessor.
 */
public class VisibleField {
   // ----------------------------------------------------------
   // The following public constants (plus numbers mentioned in comments below) are the possible states of one
   // location (a "square") in the visible field (all are values that can be returned by public method
   // getStatus(row, col)).

   // The following are the covered states (all negative values):
   public static final int COVERED = -1;   // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // The following are the uncovered states (all non-negative values):

   // values in the range [0,8] corresponds to number of mines adjacent to this opened square

   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------

   // <put instance variables here>
   private MineField mineField;
   private int numRows;
   private int numCols;
   private int numMines;
   private boolean isGameOver;
   private boolean gameOverBylosing;

   private int[][] states;
   private static final int EMPTY = 0; // uncovered square with nothing in it

   /**
    Create a visible field that has the given underlying mineField.
    The initial state will have all the locations covered, no mines guessed, and the game
    not over.
    @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.mineField = mineField;
      numRows = mineField.numRows();
      numCols = mineField.numCols();
      numMines = mineField.numMines();
      states = new int[numRows][numCols];
      resetGameDisplay();
   }


   /**
    Reset the object to its initial state (see constructor comments), using the same underlying
    MineField.
    */
   public void resetGameDisplay() {
      for (int i = 0; i < states.length; i++) {
         for (int j = 0; j < states[0].length; j++) {
            states[i][j] = COVERED;
         }
      }
      isGameOver = false;
   }


   /**
    Returns a reference to the mineField that this VisibleField "covers"
    @return the minefield
    */
   public MineField getMineField() {
      return mineField;
   }


   /**
    Returns the visible status of the square indicated.
    @param row  row of the square
    @param col  col of the square
    @return the status of the square at location (row, col).  See the public constants at the beginning of the class
    for the possible values that may be returned, and their meanings.
    PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      return states[row][col];
   }


   /**
    Returns the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
    or not.  Just gives the user an indication of how many more mines the user might want to guess.  This value will
    be negative if they have guessed more than the number of mines in the minefield.
    @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      int numGuessedMines = 0;
      for (int i = 0; i < states.length; i++) {
         for (int j = 0; j < states[0].length; j++) {
            if (states[i][j] == MINE_GUESS) {
               numGuessedMines++;
            }
         }
      }
      return (numMines - numGuessedMines);
   }


   /**
    Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
    changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
    changes it to COVERED again; call on an uncovered square has no effect.
    @param row  row of the square
    @param col  col of the square
    PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
      // check if row, col are in range of minefield
      assert getMineField().inRange(row, col);

      // COVERED --> MINE_GUESS --> QUESTION --> COVERED
      if (getStatus(row, col) == COVERED) {
         states[row][col] = MINE_GUESS;
      }
      else if (getStatus(row, col) == MINE_GUESS) {
         states[row][col] = QUESTION;
      }
      else if (getStatus(row, col) == QUESTION) {
         states[row][col] = COVERED;
      }
   }


   /**
    Uncovers this square and returns false iff you uncover a mine here.
    If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in
    the neighboring area that are also not next to any mines, possibly uncovering a large region.
    Any mine-adjacent squares you reach will also be uncovered, and form
    (possibly along with parts of the edge of the whole field) the boundary of this region.
    Does not uncover, or keep searching through, squares that have the status MINE_GUESS.
    Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
    or a loss (opened a mine).
    @param row  of the square
    @param col  of the square
    @return false   iff you uncover a mine at (row, col)
    PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      //when mine exploded
      if (mineField.hasMine(row, col)) {
         isGameOver = true;
         gameOverBylosing = true;
         states[row][col] = EXPLODED_MINE;
         return false;
      }
      else {
         // call recursive function to reveal adjacent spots
         dfs(row, col);
         return true;
      }
   }


   /**
    Returns whether the game is over.
    (Note: This is not a mutator.)
    @return whether game has ended
    */
   public boolean isGameOver() {
      // if already game over
      if (isGameOver) {
         gameIsOver(gameOverBylosing);
         return true;
      }

      // if there is a place without mines that is uncovered, it means the game is not over yet
      int numUncovered = 0;
      int numFreeMineSpots = numRows * numCols - numMines;
      for (int i = 0; i < states.length; i++) {
         for (int j = 0; j < states[0].length; j++) {
            if (isUncovered(i, j)) {
               numUncovered ++;
            }
         }
      }

      // if all spots without mines are uncovered, the player won, and the game is over.
      if (numUncovered == numFreeMineSpots) {
         gameOverBylosing = false;
         gameIsOver(gameOverBylosing);
         return true;
      } else {
         return false;
      }
   }


   /**
    * Returns whether this square has been uncovered.  (i.e., is in any one of the uncovered states,
    * vs. any one of the covered states).
    *
    * @param row of the square
    * @param col of the square
    * @return whether the square is uncovered
    * PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      return getStatus(row, col) >= 0;
   }


   // <put private methods here>
   /**
    * Helper function dfs
    * Executes depth first search by recursively calling uncover
    * @param row of the coordinate
    * @param col of the coordinate
    */
   private void dfs(int row, int col) {
      // if out of range, already uncovered, or MINE_GUESS, return immediately
      if (!mineField.inRange(row, col) || isUncovered(row, col) || states[row][col] == MINE_GUESS) {
         return;
      }
      // If there are no mines adjacent to an covered square, it displays no number
      // And then recursively do the same search for adjacent 8 cells
      if (mineField.numAdjacentMines(row, col) == 0 && states[row][col] == COVERED) {
         states[row][col] = EMPTY; // mark it as uncovered, free-mine spot

         // Recursively call dfs for adjacent 8 cells
         dfs(row - 1, col - 1);
         dfs(row - 1, col);
         dfs(row - 1, col + 1);
         dfs(row, col - 1);
         dfs(row, col + 1);
         dfs(row + 1, col - 1);
         dfs(row + 1, col);
         dfs(row + 1, col + 1);
         dfs(row + 1, col + 1);
      }

      // If a cell has adjacent mines, the cell will display the number of adjacent hidden mines
      else if (mineField.numAdjacentMines(row, col) > 0 && states[row][col] == COVERED) {
         states[row][col] = mineField.numAdjacentMines(row, col);
         return;
      }
   }

   /**
    * Updates the final status of each square when game is over.
    * @param gameOverBylosing whether game is over because we lost
    */
   private void gameIsOver(boolean gameOverBylosing) {
      // Game is over because the player won.
      if (!gameOverBylosing) {
         for (int i = 0 ; i < mineField.numRows() ; i ++) {
            for (int j = 0 ; j < mineField.numCols() ; j ++) {
               if (mineField.hasMine(i, j) && states[i][j] != MINE_GUESS) {
                  states[i][j] = MINE_GUESS;
               }
            }
         }
      }

      // Game is over because the player lost
      // 1. The square has a mine, and it is not uncovered yet.
      //	If its state is not MINE_GUESS, updates status to MINE.
      // 2. The square does not have a mine or already uncovered.
      // If its state is MINE_GUESS, it means that it is incorrectly guessed.
      if (gameOverBylosing) {
         for (int i = 0 ; i < mineField.numRows() ; i ++) {
            for (int j = 0 ; j < mineField.numCols() ; j ++) {
               if (mineField.hasMine(i, j)) {
                  if (states[i][j] != EXPLODED_MINE && states[i][j] != MINE_GUESS) {
                     states[i][j] = MINE;
                  }
               } else {
                  if (states[i][j] == MINE_GUESS) {
                     states[i][j] = INCORRECT_GUESS;
                  }
               }
            }
         }
      }
   }
}
