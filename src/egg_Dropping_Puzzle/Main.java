package egg_Dropping_Puzzle;

public class Main {
	
    public static void  main(String args[] ) 
    { 
        
        int n = Integer.parseInt(args[0]);// number of eggs
        int k = Integer.parseInt(args[1]);// number of floors
		long time1,time2,time3,time4;
		
		System.out.println("Computing...");
        
        
		switch (args[2]){
		case "-tab":	time1 = System.currentTimeMillis();				
				        System.out.println("\n Tabulation \nMinimum number of trials in worst case with:\n" +n+ " "
				        		+ "eggs\n" +k+ " floors \nis: "+Tabulation.eggDrop(n, k)); 
		 				time2 = System.currentTimeMillis();
		 				System.out.println("Time Tabulation: " + (time2-time1));
		 				break;
		 				
		case "-mem": 	time1 = System.currentTimeMillis();	
						System.out.println("\n Memoization \nMinimum number of trials in worst case with:\n" +n+ " "
				        		+ "eggs\n" +k+ " floors \nis: "+Memoization.eggDrop(n, k)); 						
						time2 = System.currentTimeMillis();
		 				System.out.println("Time Memoization: " + (time2-time1));
						break;
						
		case "-rec": 	time1 = System.currentTimeMillis();	
						System.out.println("\n Recursivo \nMinimum number of trials in worst case with:\n" +n+ " "
				        		+ "eggs\n" +k+ " floors \nis: "+Recursivo.eggDrop(n, k));
						time2 = System.currentTimeMillis();
		 				System.out.println("Time Recursive: " + (time2-time1));
						break;
						
		case "-t": 		time1 = System.currentTimeMillis();
						System.out.println("\n Tabulation \nMinimum number of trials in worst case with:\n" +n+ " "
				        		+ "eggs\n" +k+ " floors \nis: "+Tabulation.eggDrop(n, k)); 
						time2 = System.currentTimeMillis();
						System.out.println("DP Tab Time = " + (time2 - time1)+" ms");
						
						System.out.println("\n Memoization \nMinimum number of trials in worst case with:\n" +n+ " "
				        		+ "eggs\n" +k+ " floors \nis: "+Memoization.eggDrop(n, k)); 	
						time3 = System.currentTimeMillis();
						System.out.println("DP Mem Time = "   + (time3 - time2)+" ms");
				
						System.out.println("\n Recursivo \nMinimum number of trials in worst case with:\n" +n+ " "
				        		+ "eggs\n" +k+ " floors \nis: "+Recursivo.eggDrop(n, k));
						time4 = System.currentTimeMillis();
						System.out.println("Rec Time = " 	  + (time4 - time3)+" ms");	
						break;
	}
	
	System.out.println("\nFinish");
		

    } 
}
