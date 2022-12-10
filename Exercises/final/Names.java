import java.util.*;

public class Names {
 private ArrayList<String> namesArr;
 // representation invariant:
 // a. namesArr stores numNames() names
 // b. names are in alphabetical order, with smallest in namesArr.get(0),
 // and largest in namesArr.get(names.Arr.size()-1).
 // c. names are unique

 // Creates an empty names object
 public Names() { namesArr = new ArrayList<String>(); }
 // Returns the number of names in the list
 public int numNames() {
   return namesArr.size();
 }
 // Returns true iff target is present in names
 // Removes target from names, and returns true. If target wasn't present
 // in names, returns false and no change made to names.
 // Inserts newName into alphabetical names list, and returns true.
 // Returns false and no change is made to names if newName was already
 // present in names.
 public boolean insert(String newName) {
  this.namesArr.add(newName);
  return true;
 }
 // Returns arraylist of all the names in alphabetical order
 public ArrayList<String> getNames() { return namesArr; }
}
