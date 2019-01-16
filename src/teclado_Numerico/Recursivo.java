package teclado_Numerico;

public class Recursivo {
	
	private static int[] row = {0,0,-1,0,1};
	private static int[] col = {0,-1,0,1,0};


	private static int getCountUtil(char[][] Keypad, int i, int j, int n) {
		if (n <= 0) return 0;
	    if (n == 1) return 1; 
	    
	    int move=0, ro=0, co=0, totalCount = 0; 

	    for (move=0; move<5; move++) 
	    {
	        ro = i + row[move]; 
	        co = j + col[move]; 
	        if (ro >= 0 && ro <= 3 && co >=0 && co <= 2 && 
	        	Keypad[ro][co] != '*' && Keypad[ro][co] != '#')
	        {
	            totalCount += getCountUtil(Keypad, ro, co, n-1); 
	        } 
	    }
	  
	    return totalCount; 
	}
	

	public static int getCount(char[][] Keypad, int n) 
	{ 
	    if (Keypad.length < 0 || n <= 0) return 0;
	    if (n == 1) return 10; 
	    
	    int i=0, j=0, totalCount = 0; 
	    for (i=0; i<4; i++)  // Loop on keypad row 
	    { 
	        for (j=0; j<3; j++)   // Loop on keypad column 
	        { 
	            if (Keypad[i][j] != '*' && Keypad[i][j] != '#') 
	            { 
	                totalCount += getCountUtil(Keypad, i, j, n); 
	            } 
	        } 
	    } 
	    return totalCount; 
	}
	

}
