package egg_Dropping_Puzzle;

import java.util.HashMap;

public class Memoization {
	
	private static HashMap<String,Integer> tabla = new HashMap<>();
	
	static int max(int a, int b) { return (a > b)? a: b; } 
	
	/**
	 * 
	 * @param n: huevos, filas
	 * @param k: pisos, columnas
	 * @return
	 */
	static int eggDrop(int n, int k) {
		
		// si tenemos el valor de la coordenada no la volvemos a resolver
		if(tabla.containsKey(n+"-"+k)) return tabla.get(n+"-"+k);
		

	    if (k == 0) {
	    	tabla.put(n+"-"+k, 0);
	    	return 0; 
	    }
	    
	    if (k == 1) {
	    	tabla.put(n+"-"+k, 1);
	    	return 1; 
	    }
	  
	    if (n == 1) {
	    	tabla.put(n+"-"+k, k);
	    	return k;
	    }
	    
		
		int min = Integer.MAX_VALUE, x, res;
		
		// Consider all droppings from 1st floor to kth floor and 
	    // return the minimum of these values plus 1. 
	    for (x = 1; x <= k; x++) 
	    {
	        res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x)); 
	        if (res < min) {
	        	min = res;
	        }
	    }
	    tabla.put(n+"-"+k, min+1);
	    return min+1;
        
	}

}
