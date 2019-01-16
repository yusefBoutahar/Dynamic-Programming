package teclado_Numerico;

import java.math.BigInteger;

public class Tabulation {
	
	public static String getCount(char Keypad[][], int n) {
		
	    if (Keypad.length < 0 || n <= 0) return "0";
	    if (n == 1) return "10"; 
	    
	    // left, up, right, down move from current location 
	    int row[] = {0, 0, -1, 0, 1}; 
	    int col[] = {0, -1, 0, 1, 0}; 
	  
	    // taking n+1 for simplicity - count[i][j] will store 
	    // number count starting with digit i and length j 
	    String[][] count = new String [10][n+1]; 
	    int i=0, j=0, k=0, move=0, ro=0, co=0, num = 0; 
	    int nextNum=0;
	    String totalCount = "0"; 
	  
	    // count numbers starting with digit i and of lengths 0 and 1 
	    for (i=0; i<=9; i++) 
	    { 
	        count[i][0] = "0"; 
	        count[i][1] = "1"; 
	    }
		
	    // Bottom up - Get number count of length 2, 3, 4, ... , n 
	    for (k=2; k<=n; k++) 
	    { 
	        for (i=0; i<4; i++)  // Loop on keypad row 
	        { 
	            for (j=0; j<3; j++)   // Loop on keypad column 
	            { 
	                // Process for 0 to 9 digits 
	                if (Keypad[i][j] != '*' && Keypad[i][j] != '#') 
	                { 
	                    // Here we are counting the numbers starting with 
	                    // digit keypad[i][j] and of length k keypad[i][j] 
	                    // will become 1st digit, and we need to look for 
	                    // (k-1) more digits 
	                    num = Keypad[i][j] - '0'; 
	                    count[num][k] = "0"; 
	  
	                    // move left, up, right, down from current location 
	                    // and if new location is valid, then get number 
	                    // count of length (k-1) from that new digit and 
	                    // add in count we found so far 
	                    for (move=0; move<5; move++) 
	                    { 
	                        ro = i + row[move]; 
	                        co = j + col[move]; 
	                        if (ro >= 0 && ro <= 3 && co >=0 && co <= 2 && 
	                        	Keypad[ro][co] != '*' && Keypad[ro][co] != '#') 
	                        { 
	                            nextNum = Keypad[ro][co] - '0'; 
	                            count[num][k] =new BigInteger(count[num][k]).add(new BigInteger(count[nextNum][k-1])).toString(); 
	                        } 
	                    } 
	                } 
	            } 
	        } 
	    }
	    
	    // Get count of all possible numbers of length "n" starting 
	    // with digit 0, 1, 2, ..., 9 
	    for (i=0; i<=9; i++) 
	    totalCount = (new BigInteger(totalCount).add(new BigInteger(count[i][n]))).toString();
	    return totalCount; 
	    
	}

}
