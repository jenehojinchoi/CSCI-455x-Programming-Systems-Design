// Name: Hojin Choi
// USC NetID: hojincho
// CS 455 PA4
// Fall 2022

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;


/** WordFinder
    main class for the Scrabble program.
    When given letters that could comprise a Scrabble rack,
    creates a list of all legal words that can be formed from the letters on that rack.
 */
public class WordFinder {
    public static void main(String[] args) {
        // Gets the input dictionary.
        // Default: sowpods.txt; otherwise, users can input a dictionary they want.
        String inFile = chooseInFile(args);

        Scanner in = new Scanner(System.in);

        try {
            AnagramDictionary dict = new AnagramDictionary(inFile);
            startScrabble(in, dict);
        }
        catch (FileNotFoundException e) {
            // If input dictionary file is not found, the program exits.
            System.out.println("ERROR: Dictionary file \"" + inFile + "\" does not exist.");
            in.close();
        }
        catch (IllegalDictionaryException e) {
            System.out.println(e.getMessage());
            in.close();
        }
    }

    /**
     Choose a dictionary file by processing the command-line user input
     @param args String user inputs
     @return sowpods.txt if args.length == 0 else args[0]
     */
    private static String chooseInFile(String[] args) {
        if (args.length != 0) {
            return args[0];
        } else {
            return "sowpods.txt";
        }
    }

    /**
     Once an AnagramDictionary object is constructed successfully without errors, the scrabble starts.
     @param in the Scanner object to get rack user inputs
     @param dict the AnagramDictionary object which we use to get valid words' scores.
     */
    private static void startScrabble(Scanner in, AnagramDictionary dict) {
        System.out.println("Type . to quit.");

        while (true) {
            System.out.print("Rack? ");
            String userInput = in.nextLine();

            // If user's input is ".", the scrabble exits.
            if (userInput.equals(".")) {
                in.close();
                break;
            }

            // construct a scoresBoard and print it
            Map<String, Integer> scoresBoard = getScoresBoard(userInput, dict);
            printScoresBoard(scoresBoard, userInput);
        }
    }

    /**
     Gets the board of score of valid word(s) in all anagrams of the words.
     The subsets are created based on the rack, which is constructed based on the userInput (word).
     @param userInput the valid user input
     @param dict the anagram dictionary
     @return the map which represents the board of score(s)
     */
    private static Map<String, Integer> getScoresBoard(String userInput, AnagramDictionary dict) {
        Rack rack = new Rack(userInput);
        ArrayList<String> allSubsets = rack.getAllSubsets();
        Map<String, Integer> scoresBoard = new TreeMap<>();

        ScoreTable scoreTable = new ScoreTable();

        // iterate through all subsets
        for (int i = 0 ; i < allSubsets.size() ; i ++) {
            ArrayList<String> allAnagrams = dict.getAnagramsOf(allSubsets.get(i));
            if (allAnagrams != null) {
                // get score of an anagram
                for (int j = 0 ; j < allAnagrams.size() ; j ++) {
                    String validWord = allAnagrams.get(j);
                    scoresBoard.put(validWord, scoreTable.getScore(validWord));
                }
            }
        }
        return scoresBoard;
    }

    /**
     Displays all valid words, with the corresponding Scrabble score for each word, in decreasing order by score.
     For words with the same scrabble score, the words appear in alphabetical order.
     @param scoresBoard the final board of scores of all valid words.
     @param userInput the valid user input
     */
    private static void printScoresBoard(Map<String, Integer> scoresBoard, String userInput) {
        // Prints related message including how many words we get, and the valid rack
        System.out.println("We can make " + scoresBoard.size() + " words from \"" + userInput + "\"");

        // If there is no valid word, we do nothing
        if (scoresBoard.size() != 0) {
            System.out.println("All of the words with their scores (sorted by score):");

            // sort words by their scores
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(scoresBoard.entrySet());
            Collections.sort(list, new ScoreComparator());

            // Prints all valid words and their scores
            for (Map.Entry<String, Integer> curr : list) {
                System.out.println(curr.getValue() + ": " + curr.getKey());
            }
        }
    }

    /**
     class ScoreComparator
     This class is only used to provide a sorting rule: all valid words will be sorted in decreasing order by score. If
     words have the same scrabble score, they appear in alphabetical order(TreeMap).
     */
    static class ScoreComparator implements Comparator<Map.Entry<String, Integer>>{
        public int compare(Map.Entry<String, Integer> item1, Map.Entry<String, Integer> item2){
            return Integer.compare(item2.getValue(), item1.getValue());
        }
    }
}