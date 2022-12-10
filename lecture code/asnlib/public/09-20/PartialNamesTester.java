/**
   Test Names class with hard-coded data.  

   After in-class work, "Partial" version tests constructor, numNames,
   printNames, lookup and remove.
*/
public class PartialNamesTester {


   public static void main(String[] args) {

      Names empty = new Names();

      System.out.println("Names in empty list [exp: <empty>]: ");
      empty.printNames();
      System.out.println("Length of empty list [exp: 0]: "
                         + empty.numNames());	
      System.out.println();           
      
      Names names = new Names();

      names.loadNames();
      System.out.println("Names in pre-loaded list [exp: Ann Bob Carol Don Ed]: ");
      names.printNames();
      System.out.println("Length of pre-loaded list [exp: 5]: "
                         + names.numNames());	
      System.out.println();
      
      testLookup(empty, names);  
      testRemove();
      
   }
   
   
   private static void testLookup(Names empty, Names names) {
      System.out.println("Testing lookup method...");
  
      doOneLookup(empty, "Kevin", false);
      doOneLookup(names, "Carol", true);
      doOneLookup(names, "anne", false);
      doOneLookup(names, "", false);
      doOneLookup(names, "Victor", false);
      doOneLookup(names, "Anne", true);
      doOneLookup(names, "Ed", true);
      
   }
   
   
   

   /**
      Calls lookup and prints result, or failure message if actual result doesn't match 
      expected result. 
      @param names the object to do lookup on
      @param target the name to look up
      @param expectedResult expected return value of calling lookup with names and target
   */
   private static void doOneLookup(Names names, String target, boolean expectedResult) {
      System.out.print("Is " + target + " in the list? . . . ");
      if (names.lookup(target) != expectedResult) {
         System.out.println("FAILED: expected lookup to return " + expectedResult);
      }
      else {
         System.out.println(expectedResult);
      }
   }
    
   
   /**
      Tests remove method
      (on empty names object, and one with names from loadNames())
   */
   private static void testRemove() {

      System.out.println("Testing remove method...");

      Names names = new Names();
      names.loadNames();       // uses the hardcoded names

      System.out.println("Testing on empty list: ");

      doOneRemove(new Names(), "Matthew", "<empty>", 0);

      System.out.println("Testing on non-empty list: ");
      System.out.println("Original list: ");
      names.printNames();
      System.out.println();
      
      // test cases from last lecture
      doOneRemove(names, "Bob", "Anne Carol Don Ed", 4);
      doOneRemove(names, "Kevin", "Anne Carol Don Ed", 4);
      doOneRemove(names, "Anne", "Carol Don Ed", 3);
      doOneRemove(names, "Carole", "Carol Don Ed", 3);
      doOneRemove(names, "Anne", "Carol Don Ed", 3);
      doOneRemove(names, "Ed", "Carol Don", 2);
      doOneRemove(names, "Ed", "Carol Don", 2);
      doOneRemove(names, "Don", "Carol", 1);
      doOneRemove(names, "Carol", "Carol", 0);
                              // attempt removes after becomes empty
      doOneRemove(names, "Aditi", "<empty>", 0);

   }


   /**
      Test remove of goner on names, and prints actual and expected results.
      @param names the names object we are testing
      @param goner the element to remove from names
      @param expectedResult a space-separated string values expectd in names after 
      remove is done (e.g., "Anne Bob Ed")
      @param expectedSize: expected value for names.numNames() after remove is done
   */
   private static void doOneRemove(Names names, 
                                   String goner, 
                                   String expectedResult,
                                   int expectedSize) {
      System.out.println("Attempt remove: " + goner);

      boolean removed = names.remove(goner);

      if (!removed) {
         System.out.println(goner + " was not present");
      }

      System.out.println("Names in list [exp: " + expectedResult + "]: ");
      names.printNames();
      System.out.println("Number of names in list [exp: "
                         + expectedSize + "]: " +
                         names.numNames());	
      System.out.println();
   }



}
