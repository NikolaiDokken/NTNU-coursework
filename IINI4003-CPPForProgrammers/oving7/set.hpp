//
// set.hpp
//
#pragma once
#include <vector>

using namespace std;

class Set {
public:
  vector<int> numbers;

  Set();
  Set(vector<int> numbers);
  Set operator+(const Set &other) const;
  Set operator+(int integer) const;
  Set operator=(const Set &other) const;
};
