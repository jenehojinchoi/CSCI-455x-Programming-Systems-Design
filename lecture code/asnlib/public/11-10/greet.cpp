/*
 * To compile it:
 *    g++ -ggdb -Wall greet.cpp
 *
 * To run it:
 *    a.out
 */


// needed to do IO
#include <iostream>

#include <string>

using namespace std;

int main() {
   
   string name;

   cout << "What's your name? ";
   
   cin >> name;
   
   cout << "Hello, " << name << " how are you?" << endl;

   return 0;
}
