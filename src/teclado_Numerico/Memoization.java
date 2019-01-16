package teclado_Numerico;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * 	El limite del algoritmo radica en el integer.
 *  En Java, el número "Int" es de 32 bits, 
 *  y varía entre -2,147,483,648 y +2,147,483,647.
 *  Por lo que numero mayores haran que de resultados erroneos, llegando
 *  a dar valores negativos.
 *  Abajo esta el intento de modificacion sustituyendo int por BigInteger.
 */
public class Memoization {
	
	// left, up, right, down move from current location
	private static int[] row = {0,0,-1,0,1};
	private static int[] col = {0,-1,0,1,0};
	
	
	private static HashMap<String,Integer> tabla = new HashMap<>();
	
	// Return count of all possible numbers of length n 
	// in a given numeric keyboard 
	public static int getCount(char[][] Keypad, int n) {
	    // Base cases 
	    if (Keypad.length < 0 || n <= 0) return 0;
	    if (n == 1) return 10; 
	  
	    
	    int i=0, j=0, totalCount = 0; 
	    for (i=0; i<4; i++) { // Loop on keypad row 
	        for (j=0; j<3; j++){  // Loop on keypad column 
	        	
	            // Process for 0 to 9 digits 
	            if (Keypad[i][j] != '*' && Keypad[i][j] != '#') {
	            	
	                // Get count when number is starting from key 
	                // position (i, j) and add in count obtained so far 
	                totalCount += getCountUtil(Keypad, i, j, n);   
	            }
	        }
	    }
	    return totalCount; 
	}
	
	// Returns count of numbers of length n starting from key position 
	// (i, j) in a numeric keyboard.
	private static int getCountUtil(char[][] Keypad, int i, int j, int n) {
		
		if(tabla.containsKey((Keypad[i][j] - '0')+"-"+n)) return tabla.get((Keypad[i][j] - '0')+"-"+n);
		
		if(n <= 0) return 0;
		
	    if (n == 1) {
	    	tabla.put((Keypad[i][j] - '0')+"-"+n, 1);
	    	return 1; // From a given key, only one number is possible of length 1 
	    }
	    
	    int move=0, ro=0, co=0, totalCount = 0; 

	    // move left, up, right, down from current location and if 
	    // new location is valid, then get number count of length 
	    // (n-1) from that new position and add in count obtained so far
	    for (move=0; move<5; move++) {
	        ro = i + row[move]; 
	        co = j + col[move]; 
	        if (ro >= 0 && ro <= 3 && co >=0 && co <= 2 && 
	        	Keypad[ro][co] != '*' && Keypad[ro][co] != '#')
	        {
	        	
	            totalCount += getCountUtil(Keypad, ro, co, n-1);
	            
	        }
	    }
	  
	    tabla.put((Keypad[i][j] - '0')+"-"+n, totalCount);
	    return totalCount; 
	}

}










/**
 *  INTENTO DE AUNMENTAR LA CAPACIDAD DEL ALGORITMO SUSTITUYENDO INT POR BIGINTEGER, PERO NOSE PORQUE
 * 	DA ERROR
 
package teclado_Numerico;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Memoization {
	
	// left, up, right, down move from current location
	private static int[] row = {0,0,-1,0,1};
	private static int[] col = {0,-1,0,1,0};
	
	
	private static HashMap<String,BigInteger> tabla = new HashMap<>();
	
	// Return count of all possible numbers of length n 
	// in a given numeric keyboard 
	public static String getCount(char[][] Keypad, int n) {
	    // Base cases 
	    if (Keypad.length < 0 || n <= 0) return "0";
	    if (n == 1) return "10"; 
	  
	    
	    int i=0, j=0;
	    //String totalCount = "";
	    BigInteger totalCount = null;
	    for (i=0; i<4; i++) { // Loop on keypad row 
	        for (j=0; j<3; j++){  // Loop on keypad column 
	            // Process for 0 to 9 digits 
	            if (Keypad[i][j] != '*' && Keypad[i][j] != '#') {
	            	
	                // Get count when number is starting from key 
	                // position (i, j) and add in count obtained so far 
	                //totalCount += getCountUtil(Keypad, i, j, n);   
	            	totalCount = getCountUtil(Keypad,i,j,n).add(totalCount);
	            }
	        }
	    }
	    return totalCount.toString(); 
	}
	
	// Returns count of numbers of length n starting from key position 
	// (i, j) in a numeric keyboard.
	private static BigInteger getCountUtil(char[][] Keypad, int i, int j, int n) {
		
		if(tabla.containsKey((Keypad[i][j] - '0')+"-"+n)) return tabla.get((Keypad[i][j] - '0')+"-"+n);
		
		if(Keypad.length < 0 || n <= 0) {
			tabla.put((Keypad[i][j] - '0')+"-"+n, new BigInteger("0"));
			return new BigInteger("0");
		}
	    if (n == 1) {
	    	tabla.put((Keypad[i][j] - '0')+"-"+n, new BigInteger("1"));
	    	return new BigInteger("1"); // From a given key, only one number is possible of length 1 
	    }
	    
	    int move=0, ro=0, co=0;
	    //String totalCount = ""; 
	    BigInteger totalCount = null;
	    
	    // move left, up, right, down from current location and if 
	    // new location is valid, then get number count of length 
	    // (n-1) from that new position and add in count obtained so far
	    for (move=0; move<5; move++) {
	        ro = i + row[move]; 
	        co = j + col[move]; 
	        if (ro >= 0 && ro <= 3 && co >=0 && co <= 2 && 
	        	Keypad[ro][co] != '*' && Keypad[ro][co] != '#')
	        {
	        	
	        	totalCount = getCountUtil(Keypad, ro, co, n-1).add(totalCount);
	            
	        }
	    }
	  
	    //IntStream.range(0, n)
        //.forEach( (p) -> {
        //	aux2 = aux1.add(new BigInteger(aux[p]));
        // }); 
	    //
	    tabla.put((Keypad[i][j] - '0')+"-"+n, totalCount);
	    return totalCount; 
	}

}
 
 */
