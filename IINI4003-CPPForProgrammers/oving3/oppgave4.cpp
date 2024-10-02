#include <iostream>
#include <string>

using namespace std;

int main() {
  // a
  string word1 = "nikoer";
  string word2 = "ieran";
  string word3 = "kasper";

  cout << "Les inn ord 1:" << endl;
  cin >> word1;
  cout << "Les inn ord 2:" << endl;
  cin >> word2;
  cout << "Les inn ord 3:" << endl;
  cin >> word3;

  // b
  string sentence = word1 + " " + word2 + " " + word3 + ".";
  cout << "Sentence: " << endl << sentence << endl;

  // c
  cout << "Lengde ord1: " + to_string(word1.length()) << endl;
  cout << "Lengde ord2: " + to_string(word2.length()) << endl;
  cout << "Lengde ord3: " + to_string(word3.length()) << endl;
  cout << "Lengde sentence: " + to_string(sentence.length()) << endl;

  // d
  string sentence2 = sentence;
  if (sentence.length() >= 12) {
    sentence2[9] = 'x';
    sentence2[10] = 'x';
    sentence2[11] = 'x';

  }
  cout << sentence << endl;
  cout << sentence2 << endl;

  // f
  if (sentence.length() >= 5) {
    string sentence_start = sentence.substr(0,5);
    cout << sentence << endl;
    cout << sentence_start << endl;
  }

  // g
  size_t funnet = sentence.find("hallo");
  if (funnet!=string::npos) {
    cout << "hallo finnes i ordet" << endl;
  } else {
    cout << "hallo finnes ikke i ordet" << endl;
  }

  // h
  for (int i = 0; i < sentence.length()-1; i++) {
    if (sentence[i] == 'e' && sentence[i+1] == 'r') {
      cout << "\"er\" finnes på plass " + to_string(i) << endl;
    }
  }

}
