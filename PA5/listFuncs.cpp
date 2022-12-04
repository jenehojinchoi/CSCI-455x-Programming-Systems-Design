// Name: Hojin Choi
// USC NetID: hojincho
// CSCI 455 PA5
// Fall 2022


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

/* 
* Insert the key (target) and value (val) in front of the list
* If the pair already exists, then nothing changes
* @param list, target, val
* @return true if the insertion is successful else false
*/
bool listInsertFront(ListType &list, std::string target, int val) {
   if (!containsKey(list, target)) {
      Node *insertedNode = new Node(target, val, list);
      list = insertedNode;
      return true;
   }
   else {
      return false;
   }
}


/* 
* Update value of the target (key) to newVal
* @param list, target, newVal
* @return true if the update is successful else false
*/
bool updateList(ListType &list, std::string target, int newVal) {
   Node *temp = list;
   if (containsKey(list, target)) {
      while (temp != NULL) {
         if (temp->key == target) {
            temp->value = newVal;
            return true;
         }
         temp = temp->next;
      }
      // added to remove the warning sign for edge case
      return false;
   } 
   else {
      return false;
   }
}


/* 
* Remove the corresponding key-value pair
* @param list, target
* @return true if the removal is successful else false
*/
bool removeNode(ListType &list, std::string target) {
   // empty list
   if (list == NULL) {
      return false;
   }

   Node *curr = list; 
   Node *prev = NULL; 

   if (containsKey(list, target)) {
      while (curr != NULL) {
         if (list->key == target) {
            list = list->next;
            return true;
         }
         if (curr->key == target) {
            prev->next = curr->next;
            curr = NULL;
            return true;
         }
         prev = curr;
         curr = curr->next;
      }
      // added to remove the warning sign for edge case
      return false;
   }
   else {
      return false;
   }
}


/* 
* Find a pointer to the corresponding node with key-value
* @param list, target
* @return true if the pointer is found else false
*/
int *findNode(ListType list, std::string target) {
   if (containsKey(list, target)) {
      while (list != NULL) {
         if (list->key == target) {
            return &(list->value);
         }
         list = list->next;
      }
      // added to remove the warning sign for edge case
      return NULL;
   } 
   else {
      return NULL;
   }
}


/*
* Print every entry in the list
* @param list
*/
void printList(ListType list) {
   if (list != NULL) {
      while (list != NULL) {
         cout << list->key << " " << list->value << endl;
         list = list->next;
      }
   }
}


/*
* Return the number of entries in the list, which is the size of the list
* @param list
* @return the size of the list
*/
int sizeOfList(ListType list) {
   int size = 0;
   while (list != NULL) {
      size++;
      list = list->next;
   }
   return size;
}


/*
* Check if the key exists in the list
* @param list, target
* @return true if key exists else false
*/
bool containsKey(ListType list, std::string target) {
   if (list != NULL) {
      while (list != NULL) {
         if (list->key == target) {
            return true;
         }
         list = list->next;
      }
      // added to remove the warning sign for edge case
      return false;
   } 
   else {
      return false;
   }
}