#include <cmath>
#include <iostream>

using namespace std;

template <typename Type>
bool equal(Type a, Type b) {
  cout << "Bruker template funksjonen: ";
  return a == b;
}

bool equal(double a, double b) {
  cout << "Bruker spesialutgaven: ";
  return abs(b - a) < 0.00001;
}

int main() {
  cout << equal("helo", "hello") << endl;
  cout << equal(2.20001, 2.200012) << endl;
}
