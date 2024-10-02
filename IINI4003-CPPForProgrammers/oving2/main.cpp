#include <iostream> // innlesing/utskrift
#include <stdio.h>
#include <string.h>

using namespace std; // bruker standard navnerom

int find_sum(const int *table, int length);

int main() {
  // Oppgave 1
  int i = 3;
  int j = 5;
  int *p = &i;
  int *q = &j;

  cout << "Innholdet til i: " << i << ". Adressen til i: " << &i << endl;
  cout << "Innholdet til j: " << j << ". Adressen til j: " << &j << endl;
  cout << "Innholdet til p: " << p << ". Adressen til p: " << &p << endl;
  cout << "Innholdet til q: " << q << ". Adressen til q: " << &q << endl;

  *p = 7;                          // det som p peker til (i) settes lik 7
  *q += 4;                         // det som q peker til (j) settes lik j + 4
  *q = *p + 1;                     // det som q peker på (j) settes lik det som p peker på(i) + 1
  p = q;                           // p peker nå på den samme variabelen som q (j)
  cout << *p << " " << *q << endl; // Her skrives det ut 8 8 fordi det p peker på, nå er det samme som det q peker på

  // Oppgave 4
  int a = 5;  // endret ingenting
  int &b = a; // kan ikke ha en referanse uten å deklarere hva den referer til, feks at vi referer til a
  int *c;     // ingen endring
  c = &b;     // pekeren c peker på b.
  a = b + *c; // a eller b er ikke en peker, så fjerner * fra disse
  b = 2;      // kan ikke endre hva en referanse referer til. fjerner &

  // Oppgave 5
  double number;
  double *numberPointer = &number;
  double &numberRef = number;

  number = 1;
  *numberPointer = 2;
  numberRef = 3;

  // Oppgave 6
  int twentyNumbers[20];
  for (int i = 0; i < 20; i++) {
    twentyNumbers[i] = i + 1;
  }
  cout << find_sum(twentyNumbers, 10) << endl;
  cout << find_sum(&twentyNumbers[10], 5) << endl;
  cout << find_sum(&twentyNumbers[15], 5) << endl;
}

int find_sum(const int *table, int length) {
  int sum = 0;
  for (int i = 0; i < length; i++) {
    sum += *table;
    table++;
  }
  return sum;
}
