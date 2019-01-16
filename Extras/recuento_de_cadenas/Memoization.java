package recuento_de_cadenas;

import java.util.HashMap;

public class Memoization {
	
	private static HashMap<String,Integer> tabla = new HashMap<>();
	
	static int countStr(int n, int bCount, int cCount) {
		
		if(tabla.containsKey(n+"-"+bCount+"-"+cCount)) return tabla.get(n+"-"+bCount+"-"+cCount);
		
		// Base cases 
		if (bCount < 0 || cCount < 0) return 0; 
		if (n == 0) return 1; 
		if (bCount == 0 && cCount == 0) return 1; 
		
		// Three cases, we choose, a or b or c 
		// In all three cases n decreases by 1. 
		int res = countStr(n - 1, bCount, cCount); 
		tabla.put(n+"-"+bCount+"-"+cCount, res);
		res += countStr(n - 1, bCount - 1, cCount); 
		tabla.put(n+"-"+bCount+"-"+cCount, res);
		res += countStr(n - 1, bCount, cCount - 1); 
		tabla.put(n+"-"+bCount+"-"+cCount, res);
		
		return res; 
	}
	
	public static void show(int n, int bCount, int cCount) {
		countStr(n, bCount, cCount);
		tabla.forEach((k,v)->{
			System.out.println("ID: "+ k + "  Combination: " + v);
		});
		
	}

}
