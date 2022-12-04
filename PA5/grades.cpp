// Name: Hojin Choi
// USC NetID: hojincho
// CSCI 455 PA5
// Fall 2022

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

// Print command summary
void printHelp() {
   cout << "The following is the command summary: " << endl;
   cout << "<insert> name score: Insert name and score in the grade table" << endl;
   cout << "<change> name newscore: Change the score for the student" << endl;
   cout << "<lookup> name: Look up the name and print the score" << endl;
   cout << "<remove> name: Remove the student from the table" << endl;
   cout << "<print>: Print all names and scores in the table" << endl;
   cout << "<size>: Print out the number of entries in the table" << endl;
   cout << "<stats>: Print out statistics about the grade table" << endl;
   cout << "<help>: Print out a brief command summary" << endl;
   cout << "<quit>: Exits the program" << endl;
}


int main(int argc, char * argv[]) {
   // gets the hash table size from the command line
   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
                     // different constructors depending on input from the user.
   
   // optionally gets the hash table size from the command line
   if (argc > 1) {
      int hashSize = atoi(argv[1]);  // atoi converts c-string to int
      
      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
            << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*

   // initialize variables
   string command;
   bool continuing = true;
   string name;
   int score;

   // tell user what valid commands are
   cout << endl << "Valid commands are <insert> <change> <lookup> <remove> <print> <size> <stats> <help> <quit>. " << endl;

   // get user inputs while continuing is true
   while (continuing) {
      cout << "cmd> " << endl;
      cin >> command;

      // when input stream is not successful, quit
      if (cin.fail()) {
         cout << "ERROR: input stream failed." << endl;
         continuing = false;
      } 

      // when input stream is successful
      else {
         if (command == "insert") {
            cin >> name;
            cin >> score;
            // no duplicate names are allowed
            if (!grades->insert(name, score)) {
               cout << "Warning: a student with the same name is already in the table. No duplicates are allowed. " << endl;
            }
         }
         else if (command == "change") {
            cin >> name;
            cin >> score;

            if (grades->lookup(name) != NULL) {
               *grades->lookup(name) = score;
            } else {
               cout << "Warning: student's name was not found." << endl;
            }
         }
         else if (command == "lookup") {
            cin >> name;
            if (grades->lookup(name) != NULL) {
               cout << name << "'s score is " << *grades->lookup(name) << endl;
            } else {
               cout << "Warning: student's name is not found." << endl;
            }
         }
         else if (command == "remove") {
            cin >> name;
            if (!grades->remove(name)) {
               cout << "Warning: student's name is not found." << endl;
            }
         }
         else if (command == "print") {
            grades->printAll();
         }
         else if (command == "size") {
            cout << "There are " << grades->numEntries() << " student(s)' data in the table." << endl;
         }
         else if (command == "stats") {
            grades->hashStats(cout);
         }
         else if (command == "help") {
            printHelp();
         }
         else if (command == "quit") {
            continuing = false;
         }
         else { 
            cout << "ERROR: invalid command" << endl;
         }
      }
   } 

   return 0;
}
