#include "set.hpp"
#include <iostream>
#include <string>

using namespace std;

void print(Set &set) {
  cout << "{";
  for (int x : set.numbers) {
    cout << to_string(x) + (x == set.numbers.back() ? "" : ",");
  }
  cout << "}" << endl;
}

int main() {
  vector<int> tabellA = {3, 4, 10};
  vector<int> tabellB = {1, 4, 5};
  Set a;
  Set b(tabellB);
  Set c = a + b;
  print(c);      // finne unionen av to mengder
  Set d = a + 1; // legge til 1 i mengden til a
  print(d);
  Set g = c;
  print(g);
  // b = a; // setter en mengde lik en annen
  // print(b);
  // cout << "A = " << b << endl;
}