//
// fraction/main.cpp
//
#include "fraction.hpp"
#include <iostream>
#include <string>

using namespace std;

void print(const string &text, const Fraction &broek) {
  cout << text << broek.numerator << " / " << broek.denominator << endl;
}

int main() {
  Fraction a(10, 20);
  Fraction b(3, 4);
  Fraction c;
  c.set(5);
  Fraction d = a / b;

  print("a = ", a);
  print("b = ", b);
  print("c = ", c);
  print("d = ", d);

  b += a;
  ++c;
  d *= d;

  print("b = ", b);
  print("c = ", c);
  print("d = ", d);

  c = a + b - d * a;
  c = -c;

  print("c = ", c);

  if (a + b != c + d)
    cout << "a + b != c + d" << endl;
  else
    cout << " a + b == c + d" << endl;
  while (b > a)
    b -= a;
  print("b = ", b);

  // Oppgave 1a
  Fraction f(3, 2);
  print("f = ", f);
  Fraction g = f - 1;
  print("g = ", g);
  Fraction h = 1 - g;
  print("h = ", h);

  Fraction fraction1(10, 9);
  Fraction fraction2(4, 3);

  // 5 - 3 - fraction1 - 7 - fraction2 blir regnet venstreassosiativt. Vi bruker operatoren - mellom heltall
  // Deretter brukes operatoren - mellom heltall og brøk. Så bruker vi - mellom brøk og heltall, og til slutt - mellom to brøker.
}
