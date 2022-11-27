// Name: Hojin Choi
// USC NetID: hojincho
// CS 455 PA4
// Fall 2022

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/** Rack
   A Rack of Scrabble tiles
 */

public class Rack {
   private String word;

   public Rack(String word) {
      this.word = word;
   }

   /**
    Create a list of all subset words from the word
    @return subsets
    */
   public ArrayList<String> getAllSubsets() {
      // create a map of characters and its frequencies
      Map<Character, Integer> letterFreqMap = createLetterFreqMap(word);
      String unique = "";

      int[] mult = new int[letterFreqMap.size()];
      int k = 0;

      int i = 0;
      for (Map.Entry<Character, Integer> entry : letterFreqMap.entrySet()) {
         // combine all unique characters into a string
         unique += entry.getKey();
         mult[i] = entry.getValue();
         i++;
      }

      // Call helper function to get all subsets
      ArrayList<String> subsets = allSubsets(unique, mult, k);

      // Remove the empty string
      for (int j = 0; j < subsets.size(); j++) {
         if ("".equals(subsets.get(j))) {
            subsets.remove(j);
         }
      }
      return subsets;
   }



   /**
    Finds all subsets of the multiset starting at position k in unique and mult.
    unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    unique.charAt(i).
    PRE: mult.length must be at least as big as unique.length()
    0 <= k <= unique.length()
    @param unique a string of unique letters
    @param mult the multiplicity of each letter from unique.
    @param k the smallest index of unique and mult to consider.
    @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
    each subset is represented as a String that can have repeated characters in it.
    @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();

      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }

      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);

      // prepend all possible numbers of the first char (i.e., the one at position k)
      // to the front of each string in restCombos.  Suppose that char is 'a'...

      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets
            // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }

      return allCombos;
   }


   /**
    * A map which takes unique characters in a word as keys and frequency of each unique characters as values
    * @param word a word from which we want to extract its unique characters
    * @return a map stored unique characters and corresponding frequency
    */
   private Map<Character, Integer> createLetterFreqMap(String word) {
      Map<Character, Integer> letterFreqMap = new TreeMap<>();
      for (int i = 0; i < word.length(); i++) {
         char currWord = word.charAt(i);
         // if current word already exists in the map, increment the frequency
         if (letterFreqMap.containsKey(currWord)) {
            letterFreqMap.put(currWord, letterFreqMap.get(currWord) + 1);
         }
         // if current word does not exist in the map, set the frequency as 1
         else {
            letterFreqMap.put(currWord, 1);
         }
      }
      return letterFreqMap;
   }
}
