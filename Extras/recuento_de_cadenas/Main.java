package recuento_de_cadenas;

import java.math.BigInteger;

public class Main {
	
	public static void main (String[] args) 
	{ 
	    int n = 5; // Total number of characters 
	    BigInteger n1 = new BigInteger("5");
	    
	    System.out.println(((n1.multiply(new BigInteger("2"))).add(new BigInteger("1")).add((n1.multiply((n1.multiply(n1))).add(
	    		new BigInteger("-1"))).divide(new BigInteger("2")))));
	    		
	    		
	    		//ecuacion alternativa que resuelve el problema
	    
	    System.out.println(Memoization.countStr(n, 1, 2)); 
	    //System.out.println(Recursivo.countStr(n, 1, 2));
	    
	    Memoization.show(n, 1, 2); // muestra las combinaciones
	    

	}

}
