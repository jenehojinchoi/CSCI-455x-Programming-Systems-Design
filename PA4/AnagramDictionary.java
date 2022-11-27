// Name: Hojin Choi   
// USC NetID: hojincho
// CS 455 PA4
// Fall 2022

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/** AnagramDictionary
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {
   private Map<String, ArrayList<String>> dictionary;
   private HashSet<String> words;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {
      dictionary = new HashMap<String, ArrayList<String>>();
      words = new HashSet<String>();

      File file = new File(fileName);
      Scanner in = new Scanner(file);

      while (in.hasNextLine()) {
         String word = in.nextLine();

         if (words.contains(word)) {
            throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + word);
         }
         else {
            words.add(word);
            // Figure out if anagram of given word already in the dictionary, we compare its sorted version
            String key = getSortedWord(word);

            if (dictionary.containsKey(key)) {
               // If anagram of given word already exits, add the word to the dictionary
               dictionary.get(key).add(word);
            }
            else {
               // If anagram of given word is not in the dictionary,
               // create a new array list to store the word
               ArrayList<String> anagramArray = new ArrayList<String>();
               anagramArray.add(word);
               dictionary.put(key, anagramArray);
            }
         }
      }
      in.close();
   }
   
   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param string string to process
      @return a list of the anagrams of string
    */
   public ArrayList<String> getAnagramsOf(String string) {
      // key is a sorted word
      String key = getSortedWord(string);

      // If dictionary has anagrams of s, return its anagrams; if not, return an empty arrayList
      if (dictionary.containsKey(key)) {
         return dictionary.get(key);
      } else {
         return new ArrayList<String>();
      }
   }

   /**
    * Sort the given word in alphabetical order
    * E.g. input: 'anagram', output: 'aaagmnr'
    * @param word unsorted word from file
    * @return new sorted word in alphabetical order of the given word
    */
   private String getSortedWord(String word) {
      char[] charWord = word.toCharArray();
      // Arrays.sort(char chars[]) method sorts words characters based on their ASCII value
      Arrays.sort(charWord);

      return new String(charWord);
   }
}
