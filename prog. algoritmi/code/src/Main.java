import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);

		char choise;

		System.out.println("___________________________________");
		System.out.println("|            BENVENUTO            |");
		System.out.println("|                                 |");
		System.out.println("| quest' app inplementa algoritmi |");
		System.out.println("|     per la risoluzione di       |");
		System.out.println("|        integrali  definiti.     |");
		System.out.println("|_________________________________|");

		while(true) {
			System.out.println("\n \n");
			System.out.println("___________________________________");
			System.out.println("|             OPZIONI             |");
			System.out.println("|                                 |");
			System.out.println("| Metodo dei rettangoli :       R |");
			System.out.println("| Metodo dei Trapezi    :       T |");
			System.out.println("| Metodo di Simpson     :       S |");
			System.out.println("| Metodo Montecarlo     :       M |");
			System.out.println("|                                 |");
			System.out.println("| ESCI                  :       E |");
			System.out.println("|_________________________________|");


			System.out.print(" choise : ");
			choise = input.next().charAt(0);
//			System.out.print(" Inserisci f(x) = ");
//			//String F = "";
//					//F = input.nextLine();
//			e.setFunction( input.nextLine());

			switch (choise) {
				case 'R':
				case 'r': {
                    Evaluator e = new Evaluator();
					System.out.print("Inserisci f(x) = ");
					String F = input.nextLine();
					F = input.nextLine();
					e.setFunction(F);
					System.out.print("Inserisci intervallo : a = ");
					double a = input.nextDouble();
					System.out.print("Inserisci intervallo : b = ");
					double b = input.nextDouble();
					System.out.print("Inserisci numero di sotto-intervalli : n = ");
					int n = input.nextInt();
					System.out.println("L' integrale di " + F + " nell'intervallo [" + a + "," + b + "] calcolato con il metodo dei RETTANGOLI vale : " + e.integralRect(a, b, n));
				} break;
				case 't' :
				case 'T' : {
                    Evaluator e = new Evaluator();
					System.out.print("Inserisci f(x) = ");
					String F =  input.nextLine();
					F = input.nextLine();
					e.setFunction(F);
					System.out.print("Inserisci intervallo : a = ");
					double a = input.nextDouble();
					System.out.print("Inserisci intervallo : b = ");
					double b = input.nextDouble();
					System.out.print("Inserisci numero di sotto-intervalli : n = ");
					int n = input.nextInt();
					System.out.println("L' integrale di " + F + " nell'intervallo [" + a + "," + b + "] calcolato con il metodo dei TRAPEZI vale : " + e.integralTrap(a, b, n));
				} break;
				case 's' :
				case 'S' : {
                    Evaluator e = new Evaluator();
					System.out.print("Inserisci f(x) = ");
					String F =  input.nextLine();
					F = input.nextLine();
					e.setFunction(F);
					System.out.print("Inserisci intervallo : a = ");
					double a = input.nextDouble();
					System.out.print("Inserisci intervallo : b = ");
					double b = input.nextDouble();
					System.out.print("Inserisci numero di sotto-intervalli : n = ");
					int n = input.nextInt();
					System.out.print("Inserisci precisione desiderata : prec = (es: 0.000001) ");
					double prec = input.nextDouble();
					System.out.print("Inserisci numero massimo di iterazioni : Nmax = ");
					int Nmax = input.nextInt();
					System.out.println("L' integrale di " + F + " nell'intervallo [" + a + "," + b + "] calcolato con il metodo di SIMPSON vale : " + e.integralSimpson(a, b, n, prec, Nmax));
				} break;
				case 'm' :
				case 'M' : {
                    Evaluator e = new Evaluator();
					System.out.print("Inserisci f(x) = ");
					String F = input.nextLine();
					F = input.nextLine();
					e.setFunction(F);
					System.out.print("Inserisci intervallo : a = ");
					double a = input.nextDouble();
					System.out.print("Inserisci intervallo : b = ");
					double b = input.nextDouble();
					System.out.print("Inserisci numero di sotto-intervalli : n = ");
					int n = input.nextInt();
					System.out.println("L' integrale di " + F + " nell'intervallo [" + a + "," + b + "] calcolato con il metodo MONTECARLO vale : " + e.integralMontecarlo(a, b, n));
				} break;
				case 'e' :
				case 'E' : {
					System.out.println("Sei sicuro di voler uscire? Y || N");
					choise = input.next().charAt(0);
					if (choise == 'Y' || choise == 'y') {
						input.close();
						return;
					} else continue;
				}
				default: {
					System.out.println("\n OPS : pare tu abbia inserito un carattere non valido !");
					continue;
				}
			}

		}

	}

}
