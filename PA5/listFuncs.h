// Name: Hojin Choi
// USC NetID: hojincho
// CSCI 455 PA5
// Fall 2022


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to *not* put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

#include <string>


struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.


/* 
* Insert the key (target) and value (val) in front of the list
* If the pair already exists, then nothing changes
* @param list, target, val
* @return true if the insertion is successful else false
*/
bool listInsertFront(ListType &list, std::string target, int val); 


/* 
* Update value of the target (key) to newVal
* @param list, target, newVal
* @return true if the update is successful else false
*/
bool updateList(ListType &list, std::string target, int newVal); 


/* 
* Remove the corresponding key-value pair
* @param list, target
* @return true if the removal is successful else false
*/
bool removeNode(ListType &list, std::string target); 


/* 
* Find a pointer to the corresponding node with key-value
* @param list, target
* @return true if the pointer is found else false
*/
int * findNode(ListType list, std::string target);


/*
* Print every entry in the list
* @param list
*/
void printList(ListType list);


/*
* Return the number of entries in the list, which is the size of the list
* @param list
* @return the size of the list
*/
int sizeOfList(ListType list);


/*
* Check if the key exists in the list
* @param list, target
* @return true if key exists else false
*/
bool containsKey(ListType list, std::string target);

// keep the following line at the end of the file
#endif
