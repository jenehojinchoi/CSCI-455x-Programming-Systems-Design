// Name: Hojin Choi
// USC NetID: hojincho
// CS 455 PA4
// Fall 2022

/** ScoreTable
    A score table about Scrabble scores for scrabble letters and words
    It has information about how much each word is worth
    The length of ScoreTable is 26, the number of alphabet letters.
 */

public class ScoreTable {
    private final static int ALPHABET_COUNT = 26;
    private int[] scoreTable;

    /**
     * Constructor of score table
     */
    public ScoreTable(){
        scoreTable = new int[ALPHABET_COUNT];

        // iterate through alphabets
        for (char c = 'a'; c <= 'z'; ++c) {
            if (c == 'd' || c == 'g') {
                scoreTable[c - 'a'] = 2;
            }
            else if (c == 'b' || c == 'c' || c == 'm' || c == 'p') {
                scoreTable[c - 'a'] = 3;
            }
            else if (c == 'f' || c == 'h' || c == 'v' || c == 'w' || c == 'y') {
                scoreTable[c - 'a'] = 4;
            }
            else if (c == 'k') {
                scoreTable[c - 'a'] = 5;
            }
            else if (c == 'j' || c == 'x') {
                scoreTable[c - 'a'] = 8;
            }
            else if (c == 'q' || c == 'z') {
                scoreTable[c - 'a'] = 10;
            }
            else {
                scoreTable[c - 'a'] = 1;
            }
        }
    }

    /**
     * Get score of given string
     * @param str string that we need to calculate score for
     * @return total score of the given string
     */
    public int getScore(String str) {
        // Lower all characters in string. Both lower case and upper case get the same score
        str = str.toLowerCase();
        int score = 0;

        for (int i = 0; i < str.length(); i++) {
            // calculate the index by character - 'a'
            score += scoreTable[str.charAt(i) - 'a'];
        }
        return score;
    }
}

