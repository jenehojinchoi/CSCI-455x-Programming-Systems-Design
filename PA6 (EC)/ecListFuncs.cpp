/*  Name: Hojin Choi
 *  USC NetID: hojincho
 *  CS 455 Fall 2022
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <string>
#include <cassert>

#include "ecListFuncs.h"

void printList(ListType list);

using namespace std;

// *********************************************************
// Node constructors: do not change
Node::Node(int item) { 
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}
// *********************************************************


void triSum(ListType &list) {
   ListType curr = list;

   while (list != NULL) {
      ListType first = list;
      ListType second = list->next;
      ListType third = list->next->next;
      list->data = first->data + second->data + third->data;
      list->next = list->next->next->next;
      list = list->next;
      delete second;
      delete third;
   }
   list = curr;
}

void tribble(ListType &list, int val) {
   Node * tmpList = list;
   // list = NULL;
   Node * newOne = new Node(val);
   newOne->next = tmpList;
   tmpList = newOne;
}

void clearAfter(ListType &list) {
   Node *next = list->next;
   list->next = NULL;
   delete next;
}

void foo(ListType & list, int newVal) {
 if (list == NULL) { return; }
 while (list->next != NULL) {
 list = list->next;
 }
 list->data = newVal;
}

int longestSequenceOfRepeats(ListType list) {
   int prev = list->data;
   int curr = 1;
   int ans = 1;

   if (list->next != NULL) {
      list = list->next;
      while (list != NULL) {
         if (prev != list->data) {
            prev = list->data;
            curr = 1;
         } else {
            curr += 1;
         }
         ans = max(ans, curr);
         list = list->next;
      }
      return ans;
   } else {
      return ans;
   }
}

ListType reverse(ListType list) {
   if (list == NULL) {
      return NULL; 
   } 
   ListType prev = NULL;
   ListType next = list->next;

   while (next != NULL) {
      list->next = prev;
      prev = list;
      list = next;
      next = list->next;
   }
   list->next = prev;
   return list;
}

void func1(ListType list) {
   list = NULL;
}

void insert0Between(ListType & list) {
   if (list == NULL || list->next == NULL) {
      return;
   }

   Node* curr = list;
   while (curr->next != NULL) {
      Node* n = new Node(0);
      ListType next = curr->next;
      curr->next = n;
      curr->next->next = next;
      curr = curr->next->next;
   }
}

char * makeName(const char* first, const char* middle, const char* last) {
   int len = strlen(first) + strlen(middle) + strlen(last);
   char* result = new char[len+3];
   strcpy(result, first);
   strcat(result, " ");
   strcat(result, middle);
   strcat(result, " ");
   strcat(result, last);
   return result;
}

int numAdjDupes(ListType list) {
   int count = 0;
   if (list != NULL) {
      while (list != NULL) {
         int length = 0;
         while (list->next != NULL && list->next->data == list->data) {
               list = list->next;
               length++;
         }
         if (length > 0) {
               count++;
         } else {
               list = list->next;
         }
      }
   }
   return count;
}


void removeUntil7 (ListType& list) {
   while (list != NULL) {
      if (list->data == 7) {
         break;
      }
      ListType temp = list->next;
      delete list;
      list = temp;
   }
}


void removeDiv(ListType & list, int k) {
   while (list != NULL && list->data % k == 0) {
      Node *next = list->next;
      delete list;
      list = next;
   }

   Node *prev = NULL;
   Node* curr = list;
   while (curr != NULL) {
      if (curr->data % k == 0) {
         curr = curr->next;
         prev->next = curr;
         curr = curr->next;
      }
      else {      
         prev = curr;
         curr = curr->next;
      }
   }
}



void splitAtLoc(ListType &list, int loc, ListType &a, ListType &b) {
   // if list is NULL, return immediately
   if (list == NULL) {
      return;
   }

   // if list is not NULL, compute its length
   ListType temp = list;
   int lengthOfList = 0;
   while (temp != NULL) {
      temp = temp->next;
      lengthOfList++;
   }

   // divide into 4 conditions
   if (loc > lengthOfList) {
      a = list;
      list = NULL;
      return;
   } 
   else if (loc < 0) {
      b = list;
      list = NULL;
      return;
   }
   else if (loc == 0) {
      Node *listNext = list->next;
      delete list;
      list = listNext;
      b = list;
      list = NULL;
      return;
   }
   else {
      a = list;
      Node* pa = a;
      while (loc > 0) {
         pa = list;
         list = list->next;
         loc -= 1;
         if (loc == 0) {
            pa->next = NULL;
            break;
         }
         pa = pa->next;
      }

      if (list == NULL) {
         b = NULL;
         return;
      }

      list = list->next;
      b = list;
      Node* pb = b;
      while (list != NULL) {
         pb = list;  
         list = list->next;
         pb = pb->next;
      }
   }
}

