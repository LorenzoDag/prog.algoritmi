#include <iostream>
#include <cstdio>
#include <string>

#include "integral.h"

using namespace std;

int main() {

    string expression_str = NULL;
    double a, b;
    char select;


    cout << "Inserisci funzione da valutare : ";
    cin >> expression_str;

    cout << endl  << "inserisci estremi di integrazione : " << endl;
    cout << "a = ";
    cin >> a;
    cout << endl << "b = ";
    cin >> b;
    cout << endl << "quale metodo vuoi utilizzare? : " << endl;
    cout << "___________________________" << endl;
    cout << "| Metodo dei rettangoli   :            a |"<< endl;
    cout << "| Metodo dei trapezi       :            b |" << endl;
    cout << "| Metodo di  Simpson     :            c |" << endl;
    cout << "| Metodo di Montecarlo  :            d |" << endl;
    cout << "|__________________________|" << endl;
    cin >> select;

    switch (select) {

        case ('a') : {
            int n;
            cout << "inserisci numero di intervalli : ";
            cin >> n;
            cout << endl;
            cout << integralRect(a, b, n, expression_str)<< endl;
        } break;

        case('b') : {
            int n;
            cout << "inserisci numero di intervalli : ";
            cin >> n;
            cout << endl;
            cout << integralTrap(a, b, n, expression_str)<< endl;
        } break;

        case ('c') : {
            int n, nmax;
            double prec;
            cout << "inserisci numero di intervalli : ";
            cin >> n;
            cout << endl << "inserisci numero massimo di iterazioni : ";
            cin >> nmax;
            cout << endl << "inserisci precisione voluta : " ;
            cin >> prec;
            cout << endl << integralSimpson(a, b, n, prec, nmax, expression_str);
        } break;

        case ('d') : {
            int n;
            double MAX;
            cout << "inserisci numero di intervalli : ";
            cin >> n;
            cout << endl << "inserisci il massimo valore della funzione nell' intervallo : ";
            cin >> MAX;
            cout << endl ;
            cout << endl << integralMontecarlo(n, a, b, MAX, expression_str);
        } break;

        default :
            cout << "errore inserimento" << endl;
    }



    return 0;
}