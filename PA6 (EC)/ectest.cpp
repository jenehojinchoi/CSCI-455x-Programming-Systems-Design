/*  Name: Hojin Choi
 *  USC NetID: hojincho
 *  CS 455 Fall 2022
 *  Extra credit assignment
 *
 *  ectest.cpp
 *
 *  a non-interactive test program to test the functions described in ecListFuncs.h
 *
 *    to run it use the command:   ectest
 *
 *  Note: this uses separate compilation.  You put your list code ecListFuncs.cpp
 *  Code in this file should call those functions.
 */


#include <iostream>
#include <string>

// for istringstream used in buildList (defined below)
#include <sstream>

#include "ecListFuncs.h"

using namespace std;


// You may use the following two utility functions that will make it easier to
// test your list functions on hard-coded list data and compare it to expected
// output:
// (function definitions for them appear at the bottom of this file)

int numAdjDupes(ListType list);

void removeDiv(ListType & list, int k);

void clearList(ListType &list);

void printList(ListType list);

void splitAtLoc(ListType &list, int index, ListType &a, ListType &b);

/*
 * listToString
 *
 * PRE: list is a well-formed list.
 *
 * converts the list to a string form that has the following format shown by example.
 * the list is unchanged by the function.
 *
 *   string format:
 *
 *   "()"        an empty list
 *   "(3)        a list with one element, 3
 *   "(3 4 5)"   a list with multiple elements: 3 followed by 4 followed by 5
 *
 */
string listToString(ListType list);


/*
 * buildList
 * 
 * PRE: listString only contains numbers (valid integer format) and spaces
 *
 * creates and returns a linked list from a string of space separated numbers
 * 
 *
 * Examples:
 *  listString         return value of buildList(listString)
 *
 *    ""               ()
 *    "-32"            (-32)
 *    "     -32   "    (-32)
 *    "1 3 2"          (1 3 2)
 *    "  1 3 2"        (1 3 2)
 *
 */
ListType buildList(const string & listString);

bool readCommand(ListType &theList);


// non-interactive program
// int main ()
// {
//    ListType list;

//    cout << "============= Test 1: numAdjDupes =============" << endl;
//    list = buildList("");
//    cout << "Test 1-1: ";
//    printList(list);
//    assert(numAdjDupes(list) == 0);
//    clearList(list);

//    list = buildList("2 8 3");
//    cout << "Test 1-2: ";
//    printList(list);
//    assert(numAdjDupes(list) == 0);
//    clearList(list);

//    list = buildList("4 4 7 3");
//    cout << "Test 1-3: ";
//    printList(list);
//    assert(numAdjDupes(list) == 1);
//    clearList(list);

//    list = buildList("5 5 7 5 5 5 5");
//    cout << "Test 1-4: ";
//    printList(list);
//    assert(numAdjDupes(list) == 2);
//    clearList(list);

//    list = buildList("5 7 5 7");
//    cout << "Test 1-5: ";
//    printList(list);
//    assert(numAdjDupes(list) == 0);
//    clearList(list);

//    list = buildList("5 5 5 3 3 3 4 4 4 4");
//    cout << "Test 1-6: ";
//    printList(list);
//    assert(numAdjDupes(list) == 3);
//    clearList(list);

//    cout << "================= Test 1 PASSED ==================" << endl;

//    cout << "============= Test 2: removeDiv =============" << endl;
//    list = buildList("");
//    cout << "Test 2-1: ";
//    printList(list);
//    removeDiv(list, 3);
//    assert(listToString(list) == "()");
//    clearList(list);

//    list = buildList("7 10");
//    cout << "Test 2-2: ";
//    printList(list);
//    removeDiv(list, 3);
//    assert(listToString(list) == "(7 10)");
//    clearList(list);

//    list = buildList("24 12 6 9");
//    cout << "Test 2-3: ";
//    printList(list);
//    removeDiv(list, 4);
//    assert(listToString(list) == "(6 9)");
//    clearList(list);

//    list = buildList("24 12 6 9");
//    cout << "Test 2-4: ";
//    printList(list);
//    removeDiv(list, 3);
//    assert(listToString(list) == "()");
//    clearList(list);

//    list = buildList("3 2 8 4 7");
//    cout << "Test 2-5: ";
//    printList(list);
//    removeDiv(list, 2);
//    assert(listToString(list) == "(3 7)");
//    clearList(list);

//    list = buildList("1 2 3 4 5");
//    cout << "Test 2-6: ";
//    printList(list);
//    removeDiv(list, 1);
//    assert(listToString(list) == "()");
//    clearList(list);

//    cout << "================= Test 2 PASSED ==================" << endl;

//    cout << "============= Test 3: splitAtLoc =============" << endl;
//    ListType a = buildList("");
//    ListType b = buildList("");

//    list = buildList("7 4 4 3 9");
//    cout << "Test 3-1: ";
//    printList(list);
//    splitAtLoc(list, 2, a, b);
//    assert(listToString(a) == "(7 4)");
   
//    assert(listToString(b) == "(3 9)");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("7 4 2 3 9");
//    cout << "Test 3-2: ";
//    printList(list);
//    splitAtLoc(list, 0, a, b);
//    assert(listToString(a) == "()");
//    assert(listToString(b) == "(4 2 3 9)");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("1 2 3 3 2");
//    cout << "Test 3-3: ";
//    printList(list);
//    splitAtLoc(list, 4, a, b);
//    assert(listToString(a) == "(1 2 3 3)");
//    assert(listToString(b) == "()");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("");
//    cout << "Test 3-4: ";
//    printList(list);
//    splitAtLoc(list, 3, a, b);
//    assert(listToString(a) == "()");
//    assert(listToString(b) == "()");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);


//    a = buildList("");
//    b = buildList("");

//    list = buildList("8 2 5");
//    cout << "Test 3-5: ";
//    printList(list);
//    splitAtLoc(list, 2, a, b);
//    assert(listToString(a) == "(8 2)");
//    assert(listToString(b) == "()");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("8 2 5");
//    cout << "Test 3-6: ";
//    printList(list);
//    splitAtLoc(list, 3, a, b);
//    assert(listToString(a) == "(8 2 5)");
//    assert(listToString(b) == "()");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("8 2 5");
//    cout << "Test 3-7: ";
//    printList(list);
//    splitAtLoc(list, -3, a, b);
//    assert(listToString(a) == "()");
//    assert(listToString(b) == "(8 2 5)");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("3");
//    cout << "Test 3-8: ";
//    printList(list);
//    splitAtLoc(list, 0, a, b);
//    assert(listToString(a) == "()");
//    assert(listToString(b) == "()");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("3 5");
//    cout << "Test 3-9: ";
//    printList(list);
//    splitAtLoc(list, 0, a, b);
//    assert(listToString(a) == "()");
//    assert(listToString(b) == "(5)");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);

//    a = buildList("");
//    b = buildList("");

//    list = buildList("3 5");
//    cout << "Test 3-10: ";
//    printList(list);
//    splitAtLoc(list, 1, a, b);
//    assert(listToString(a) == "(3)");
//    assert(listToString(b) == "()");
//    assert(listToString(list) == "()");

//    clearList(list);
//    clearList(a);
//    clearList(b);


//    cout << "================= Test 3 PASSED ==================" << endl;

//    cout << "============= Test 4: triSum =============" << endl;
//    list = buildList("4 4 4");
//    cout << "Test 4-1: ";
//    printList(list);
//    triSum(list);
//    printList(list);
//    assert(listToString(list) == "(12)");

//    cout << "================= Test 4 PASSED ==================" << endl;
// }


int main() {
   // ListType l = buildList("12 5 0 1 7 9");
   // removeUntil7(l);
   // printList(l);

   // ListType l2 = buildList("0 0 0");
   // removeUntil7(l2);
   // printList(l2);

   // const char* f = "Joe";
   // const char* m = "P.";
   // const char* ll = "Blow";
   // cout << makeName(f, m, ll) << endl;
   int* a;
   *a = 10;
   cout << *a << endl;
}


/*********************************************************
 * Utility function definitions
 *
 */

string listToString(ListType list) {

   string listString = "(";

   if (list == NULL) {
      listString += ")";
      return listString;
   }

   Node *p = list;
   while (p->next != NULL) {
      listString += to_string(p->data) + " ";
      p = p->next;
   }

   // print last one with no trailing space
   listString += to_string(p->data) + ")";

   return listString;
}   


ListType buildList(const string & listString) {

   ListType nums = NULL;

   istringstream istr(listString);  // similar to a Java Scanner over a String

   int num;

   if (istr >> num) { // is there one value there?
      // cout << "num: " << num << endl;
      nums = new Node(num);
   }
   else {
      return NULL;
   }

   Node *last = nums;

   while (istr >> num) { 
      last->next = new Node(num);
      last = last->next;
   }

   return nums;
}


void printList(ListType list) {
   if (list == NULL) {
      cout << "<empty>";
   }

   Node *p = list;
   while (p != NULL) {
      cout << p->data << " ";
      p = p->next;
   }
   cout << endl;
}

void clearList(ListType &list) {

   Node *rest = list;

   while (list != NULL) {
      rest = list->next;  // rest is all but the first element
      delete list;  // reclaims one node only
      list = rest;
   }

}
