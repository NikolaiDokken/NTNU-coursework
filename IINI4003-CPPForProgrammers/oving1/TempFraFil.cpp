#include <cctype>   // char-behandling
#include <cstring>  // strengbehandling
#include <iostream> // innlesing/utskrift
#include <fstream>

using namespace std; // bruker standard navnerom

void read_temperatures(double temperatures[], int length);

int main()
{
    const int length = 5;

    int antUnder10 = 0;
    int antOver10 = 0;
    int antOver20 = 0;
    double temperaturer[5];
    read_temperatures(temperaturer, length);

    for (int i = 0; i < length; i++)
    {
        cout << temperaturer[i];
        if (temperaturer[i] < 10)
            antUnder10++;
        else if (temperaturer[i] > 20)
            antOver20++;
        else
            antOver10++;
    }

    cout << "Antall under 10 er: " << antUnder10 << endl;
    cout << "Antall mellom 10 og 20 er: " << antOver10 << endl;
    cout << "Antall over 20 er: " << antOver20 << endl;
}

void read_temperatures(double temperatures[], int length)
{
    const char filename[] = "temperaturer.dat";
    ifstream file;       // definerer filvariabel
    file.open(filename); // åpner filen
    if (!file)
    { // innfil kan brukes som et logisk uttrykk
        cout << "Feil ved åpning av innfil." << endl;
        exit(EXIT_FAILURE); // uthopp fra programmet
    }

    double tempTemp;
    for (int i = 0; i < length; i++)
    {
        file >> tempTemp;
        temperatures[i] = tempTemp;
    }
    file.close();
}