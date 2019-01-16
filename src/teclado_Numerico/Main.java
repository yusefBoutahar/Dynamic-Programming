package teclado_Numerico;

public class Main {

	public static void main(String[] args) {
		
		char[][] Keypad = {{'1','2','3'}, 
			                {'4','5','6'}, 
			                {'7','8','9'}, 
			                {'*','0','#'}};
		
		int n = Integer.parseInt(args[0]);// length of nunbers
		long time1,time2,time3,time4;
		
		System.out.println("Computing...");
		
		switch (args[1]){
			case "-tab":	time1 = System.currentTimeMillis();				
			 				System.out.println("\nTABULATION\nCount for numbers of length "+n+": "+Tabulation.getCount(Keypad, n));
			 				time2 = System.currentTimeMillis();
			 				System.out.println("Time Tabulation: " + (time2-time1));
			 				break;
			 				
			case "-mem": 	time1 = System.currentTimeMillis();	
							System.out.println("\nMEMOIZATION\nCount for numbers of length "+n+": "+Memoization.getCount(Keypad, n));
							time2 = System.currentTimeMillis();
			 				System.out.println("Time Memoization: " + (time2-time1));
							break;
							
			case "-rec": 	time1 = System.currentTimeMillis();	
							System.out.println("\nRECURSIVE\nCount for numbers of length "+n+": "+Recursivo.getCount(Keypad, n));
							time2 = System.currentTimeMillis();
			 				System.out.println("Time Recursive: " + (time2-time1));
							break;
							
			case "-t": 		time1 = System.currentTimeMillis();
							System.out.println("\nTABULATION\nCount for numbers of length "+n+": "+Tabulation.getCount(Keypad, n));
							time2 = System.currentTimeMillis();
							System.out.println("DP Tab Time = " + (time2 - time1)+" ms");
							
							System.out.println("\nMEMOIZATION\nCount for numbers of length "+n+": "+Memoization.getCount(Keypad, n));
							time3 = System.currentTimeMillis();
							System.out.println("DP Mem Time = "   + (time3 - time2)+" ms");
					
							System.out.println("\nRECURSIVE\nCount for numbers of length "+n+": "+Recursivo.getCount(Keypad, n));
							time4 = System.currentTimeMillis();
							System.out.println("Rec Time = " 	  + (time4 - time3)+" ms");	
							break;
		}
		
		System.out.println("\nFinish");

		

	}

}
