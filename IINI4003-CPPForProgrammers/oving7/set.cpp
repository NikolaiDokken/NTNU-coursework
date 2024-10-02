#include "set.hpp"
#include <vector>

using namespace std;

Set::Set() {
  numbers = vector<int>();
};

Set::Set(vector<int> numbers_) {
  numbers = numbers_;
};

Set Set::operator+(const Set &other) const {
  Set nyttSett = *this;
  nyttSett.numbers.insert(nyttSett.numbers.end(), other.numbers.begin(), other.numbers.end());

  sort(nyttSett.numbers.begin(), nyttSett.numbers.end());
  nyttSett.numbers.erase(unique(nyttSett.numbers.begin(), nyttSett.numbers.end()), nyttSett.numbers.end());
  return nyttSett;
}

Set Set::operator+(int integer) const {
  Set nyttsett = *this;
  for (int x : nyttsett.numbers) {
    if (x == integer) {
      return nyttsett;
    }
  }
  nyttsett.numbers.emplace_back(integer);
  return nyttsett;
}

Set Set::operator=(const Set &other) const {
  Set nyttsett = *this;
  nyttsett.numbers.clear();
  for (int x : other.numbers) {
    nyttsett.numbers.emplace_back(x);
  }
  return nyttsett;
}
