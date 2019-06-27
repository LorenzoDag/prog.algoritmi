#include <time.h>
#include <iostream>
#include <cstdio>
#include <string>
#include <stdio.h>
#include <stdlib.h>


using namespace std;


double integralRect(double a, double b, int n, string func) {

		double x = a;
		double h = (b-a)/n;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum+= f.value();
			x += h;
		}

		return sum*h;
}

double integralTrap(double a, double b, int n, string func) {

        double h = (b-a)/n;
        double x = a;

        double sum = f.value();
        x = b;
        sum += f.value();

		sum = (sum)/2;
		x = a + h;
		for (int i = 1; i < n; i++) {
			sum += f.value();
			x += h;
		}

		return sum*h;
}

double integralSimpson(double a, double b, int n, double prec, int nmax, string func) {

        double x = a;

        double FAB = f.value();
        x = b;
        FAB += f.value();

        x = a;

		if (n%2 != 0) n++;

		double h = (b-a)/n;
		double sp = 0;
		double sd = 0;
		for (int i = 1; i <= (n-2)/2; i++) {
			x += h;
			sd += f.value();
			x += h;
			sp += f.value();
		}
		x += h;
		sd += f.value();
		double area = (FAB + 4*sd + 2*sp)*h/3;
		double area1, diff;
		do {
			sp += sd;
			sd = 0;
			x = a + h/2;
			for(int i = 1; i <= n; i++) {
				sd += f.value();
				x += h;
			}
			area1 = (FAB +4*sd + 2*sp)*h/6;
			diff = abs(area1-area);
			h = h/2;
			n = n*2;
		} while(diff > prec && n < nmax);

		return area;
}

double integralMontecarlo(int n, double a, double b, double M, string func) {

   double x = 0;

    int m = 0;
    double rnd = 0;
    double y = 0;
    srand((unsigned)time(NULL));
    for(int i = 0; i < n; i++) {
        // genera un valore casuale compreso tra 0 ed 1
        rnd = (double) rand()/RAND_MAX;
        x = (b-a)*rnd + a;
        y = M*rnd;
        if (y < f.value()) m++;
    }
    double INT = (b-a)*M*m/n;
    return INT;
}
