// Name: Hojin Choi
// USC NetID: hojincho
// CSCI 455 PA5
// Fall 2022

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {
   ListType node1 = new Node("Jene", 100);
   ListType node2 = new Node("A", 80);
   ListType node3 = new Node("B", 60);
   ListType node4 = new Node("C", 50);

   node1->next = node2;
   node2->next = node3;
   node3->next = node4;
   ListType list = node1;

   // Case 0. Print original list
   cout << "==================================================" << endl;
   cout << "Testing with linked list: " << endl;
   printList(list);

   // Case 1. Test sizeOfList
   cout << "================ Test 1: sizeOfList ================" << endl;
   assert(sizeOfList(list) == 4);
   cout << "================    Passed   =================" << endl;

   // Case 2. Test findNode
   cout << "================ Test 2: findNode ================" << endl;
   assert((* findNode(list, "Jene")) == 100);
   assert(findNode(list, "J") == NULL);
   cout << "================    Passed   =================" << endl;

   // Case 3. Test update
   cout << "================ Test 3: updateList ================" << endl;
   assert((* findNode(list, "C")) == 50);
   updateList(list, "C", 90);
   assert((* findNode(list, "C")) == 90);
   cout << "================    Passed   =================" << endl;

   // Case 4. Test listInsertFront
   cout << "================ Test 4: listInsertFront ================" << endl;
   assert(findNode(list, "D") == NULL);
   listInsertFront(list, "D", 55);
   assert(findNode(list, "D") != NULL);
   cout << "================    Passed   =================" << endl;


   // Case 5. Test removeNode
   cout << "================ Test 5: removeNode ================" << endl;
   printList(list);

   assert(findNode(list, "B") != NULL);
   removeNode(list, "B");
   assert(findNode(list, "B") == NULL);

   assert(findNode(list, "Jene") != NULL);
   removeNode(list, "Jene");
   assert(findNode(list, "Jene") == NULL);
   cout << "================    Passed   =================" << endl;

   return 0;
}
