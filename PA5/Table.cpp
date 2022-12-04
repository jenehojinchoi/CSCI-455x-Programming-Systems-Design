// Name: Hojin Choi
// USC NetID: hojincho
// CSCI 455 PA5
// Fall 2022

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

// for hash function called in private hashCode method defined below
#include <functional>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

/* 
* Constructor of Table class using default table size
* initializes all pointers as null and number of entries as 0
*/
Table::Table() {
   hashSize = HASH_SIZE;
   table = new ListType[hashSize];
   for(int i = 0; i < hashSize; i++){
      table[i] = NULL;
   }
   numOfEntries = 0;
}


/* 
* Constructor of Table class using user input table size
* initializes all pointers as null and number of entries as 0
*/
Table::Table(unsigned int hSize) {
   hashSize = hSize;
   table = new ListType[hashSize];
   for(int i = 0; i < hashSize; i++){
      table[i] = NULL;
   }
   numOfEntries = 0;
}


/* 
* Look up value of a given key in the table
* @param key: key of the entry
* @return: pointer to the value of the key
*/
int *Table::lookup(const string &key) {
   unsigned int hashIndex = hashCode(key);
   return findNode(table[hashIndex], key);
}


/* 
* Remove a key-value pair corresponding to a given key
* @param key: key of the entry
* @return: true if the removal is successfully done, else false
*/
bool Table::remove(const string &key) {
   unsigned int hashIndex = hashCode(key);
   if (removeNode(table[hashIndex], key)) {
      numOfEntries--;
      return true;
   }
   return false;
}


/* 
* Insert a key-value pair into the table
* @param key: key of the entry
* @return: true if the insertion is successful, else false
*/
bool Table::insert(const string &key, int value) {
   unsigned int hashIndex = hashCode(key);
   if (listInsertFront(table[hashIndex], key, value)) {
      numOfEntries++;
      return true;
   }
   return false;
}


/* 
* Return the number of entries in the table
* @return: the number of entries
*/
int Table::numEntries() const {
   return numOfEntries;
}


/* 
* Print all the entries in the table
*/
void Table::printAll() const {
   for (int i = 0; i < hashSize; i++) {
      ListType list = table[i];
      printList(list);
   }
}


/* 
* Print statistics of hash table
* The number of buckets, the number of entries, the number of non-empty buckets, and the longest chain
*/
void Table::hashStats(ostream &out) const {
   out << "number of buckets: " << hashSize << endl;
   out << "number of entries: " << numEntries() << endl;
   out << "number of non-empty buckets: " << numNonEmptyBucket() << endl;
   out << "longest chain: " << longestChain() << endl;

}


// hash function for a string
// (we defined it for you)
// returns a value in the range [0, hashSize)
unsigned int Table::hashCode(const string &word) const {

   // Note: calls a std library hash function for string (it uses the good hash
   //   algorithm for strings that we discussed in lecture).
   return hash<string>()(word) % hashSize;
}


// add definitions for your private methods here

/* 
* Return the number of non empty buckets
* @return: the number of non empty buckets
*/
int Table::numNonEmptyBucket() const {
   int numNonEmpty = 0;
   for (int i = 0; i < hashSize; i++) {
      if (sizeOfList(table[i]) != 0) {
         numNonEmpty++;
      }
   }
   return numNonEmpty;
}


/* 
* Return the longest chain in the table
* @return: the longest chain in the table
*/
int Table::longestChain() const {
   // initialize longest chain as 0
   int longest = 0;
   for (int i = 0; i < hashSize; i++) {
      // if the size of the chain is longer than the longest chain, update it
      if (sizeOfList(table[i]) > longest) {
         longest = sizeOfList(table[i]);
      }
   }
   return longest;
}