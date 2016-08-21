package lambda;

import java.util.function.UnaryOperator;

public class Recursive<I> {
	
 public void factorial(int n) {
	 UnaryOperator<Integer>[] fac = new UnaryOperator[1];
     fac[0] = i -> i == 0 ? 1 : i * fac[0].apply( i - 1);

     UnaryOperator<Integer> factorial = fac[0];
     
     System.out.println("Factorial de -> "+Integer.toString(n)+" es:");
     System.out.println(factorial.apply(n));
	}
}

