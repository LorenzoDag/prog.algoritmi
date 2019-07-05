import net.objecthunter.exp4j.*;

public class Evaluator {
	private Expression function;
	Evaluator(String f){
		function=new ExpressionBuilder(f).variable("x").build();
	}
	
	Evaluator(){
		function=new ExpressionBuilder("0").build();
	}
	
	public void setFunction(String f) {
		function=new ExpressionBuilder(f).variable("x").build();
	}
	
	public double f(double x) {
		function.setVariable("x", x);
		return function.evaluate();
	}
	
	public double integralRect(double a, double b, int n) {
		
		double x = a;
		double h = (b-a)/n;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum+= f(x);
			x += h;
		}
		
		return sum*h;
	}
	
	public double integralTrap(double a, double b, int n) {
		
		double h = (b-a)/n;
		double sum = (f(a)+f(b))/2;
		double x = a + h;
		for (int i = 1; i < n; i++) {
			sum += f(x);
			x += h;
		}
		
		return sum*h;
	}
	
	
	public double integralSimpson(double a, double b, int n, double prec, int nmax) {
		
		if (n%2 != 0) n++; 
		
		double h = (b-a)/n;
		double sp = 0;
		double sd = 0;
		double x = a;
		for (int i = 1; i <= (n-2)/2; i++) {
			x += h;
			sd += f(x);
			x += h;
			sp += f(x);
		}
		x += h;
		sd += f(x);
		double FAB = f(a) + f(b);
		double area = (FAB + 4*sd + 2*sp)*h/3;
		double area1, diff;
		do {
			sp += sd;
			sd = 0;
			x = a + h/2;
			for(int i = 1; i <= n; i++) {
				sd += f(x);
				x += h;
			}
			area1 = (FAB +4*sd + 2*sp)*h/6;
			diff = Math.abs(area1-area);
			h = h/2;
			n = n*2;
		} while(diff > prec && n < nmax);
		
		return area;
	}
	
	public double integralSimpson(double a, double b, int n) {
		
		return integralSimpson(a, b, n, 0.0001, (int)10E6);
		
	}

	public double integralMontecarlo( double a, double b, int n) {

		double Max = this.f(a);
		double h = (b-a)/n;
		double x = a+h;
		while (x <= b) {
			if(f(x) > Max) { Max = f(x); }
			x += h;
		}

		Max = Math.ceil(Max) + 0.5;

		int m = 0;
		double y = 0;

		for(int i = 0; i < n; i++) {
			// genera un valore casuale compreso tra 0 ed 1
			x = (b-a)*Math.random() + a;
			y = Max*Math.random();
			if (y < this.f(x)) m++;
		}
		double INT = (b-a)*Max*m/n;
		return INT;
	}

}
