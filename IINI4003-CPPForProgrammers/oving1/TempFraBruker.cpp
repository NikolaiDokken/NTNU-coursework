#include <cctype>   // char-behandling
#include <cstring>  // strengbehandling
#include <iostream> // innlesing/utskrift

using namespace std; // bruker standard navnerom

int main()
{
    const int length = 5;

    int antUnder10 = 0;
    int antOver10 = 0;
    int antOver20 = 0;

    for (int i = 0; i < length; i++)
    {
        double tempTemp = 0; //;)
        cout << "Les inn temp " << i + 1 << endl;
        cin >> tempTemp;

        if (tempTemp < 10)
            antUnder10++;
        else if (tempTemp > 20)
            antOver20++;
        else
            antOver10++;
    }

    cout << "Antall under 10 er: " << antUnder10 << endl;
    cout << "Antall mellom 10 og 20 er: " << antOver10 << endl;
    cout << "Antall over 20 er: " << antOver20 << endl;
}