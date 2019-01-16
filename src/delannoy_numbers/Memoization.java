package delannoy_numbers;

import java.math.BigInteger;
import java.util.HashMap;

public class Memoization {
	
	//  Dynamic Programming implementation (memoization technique)

	private static HashMap<String, String> tabla = new HashMap<>(); 

	/**
	 * Metodo que calcula el numero dealnnoy de las coordenadas pasadas
	 * por parametro.
	 * 
	 * @param n: Columna
	 * @param m: Fila
	 * @return el numero resultante dealnnoy
	 */
	public static String dealnnoy(int n, int m) {
		
		if(tabla.containsKey(n+"-"+m)) return (String) tabla.get(n+"-"+m);
		
		BigInteger aux;
		if(n == 0 || m == 0) {// inicialiazmos la tabla
			aux = new BigInteger("1");
			tabla.put(n+"-"+m, aux.toString());
			
		} else {

			aux = new BigInteger(dealnnoy(m-1,n)).add(
					new BigInteger(dealnnoy(m-1,n-1))).add(
					new BigInteger(dealnnoy(m,n-1)));
			
			tabla.put(n+"-"+m, aux.toString());// añadimos el nuevo a la tabla
		}
		return aux.toString();
		
		
		
	}


}
