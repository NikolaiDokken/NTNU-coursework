#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {

  vector<double> numbers;

  numbers.emplace_back(2.0);
  numbers.emplace_back(4.9);
  numbers.emplace_back(3.7);
  numbers.emplace_back(9.1);
  numbers.emplace_back(7.8);

  cout << "Første nummer: " + to_string(numbers.front()) << endl;
  cout << "Bakerste nummer: " + to_string(numbers.back()) << endl;

  numbers.emplace(numbers.begin() + 1, 3.33);
  cout << "Førse nummer etter emplace: " + to_string(numbers.front()) << endl;

  auto search = find(numbers.begin(), numbers.end(), 3.7);
  if (search != numbers.end()) {
    cout << "Søk fant: " + to_string(*search) << endl;
  } else {
    cout << "Søket var mislykket" << endl;
  }
}
