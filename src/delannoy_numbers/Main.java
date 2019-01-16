package delannoy_numbers;

public class Main {
	
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);// 1 parametro COLUMNAS
		int m = Integer.parseInt(args[1]);// 2 parametro FILAS
		long time1,time2,time3,time4;
		
		System.out.println("Computing...");
		
		
		switch (args[2]){
			case "-tab": 	time1 = System.currentTimeMillis();
							System.out.println("\nTabulacion Columnas:  " + n + " Filas: " + m +" = "+ Tabulation.dealnnoy(n,m));
							time2 = System.currentTimeMillis();
							System.out.println("\nDP Tab Time = " + (time2 - time1)+" ms");
							break;
							
			case "-mem": 	time1 = System.currentTimeMillis();
							System.out.println("Memoization Columnas: " + n + " Filas: " + m +" = "+ Memoization.dealnnoy(n,m));
							time2 = System.currentTimeMillis();
							System.out.println("DP Mem Time = "   + (time2 - time1)+" ms");
							break;
							
							
			case "-rec": 	time1 = System.currentTimeMillis();
							System.out.println("Recursivo  Columnas:  " + n + " Filas: " + m +" = "+ Recursivo.dealnnoy(n,m));
							time2 = System.currentTimeMillis();
							System.out.println("Rec Time = " 	  + (time2 - time1)+" ms");	
							break;
							
			case "-t": 		time1 = System.currentTimeMillis();
							System.out.println("\nTabulacion Columnas:  " + n + " Filas: " + m +" = "+ Tabulation.dealnnoy(n,m));
							time2 = System.currentTimeMillis();
							System.out.println("DP Tab Time = " + (time2 - time1)+" ms");
							
							System.out.println("\nMemoization Columnas: " + n + " Filas: " + m +" = "+ Memoization.dealnnoy(n,m));
							time3 = System.currentTimeMillis();
							System.out.println("DP Mem Time = "   + (time3 - time2)+" ms");
					
							System.out.println("\nRecursivo  Columnas:  " + n + " Filas: " + m +" = "+ Recursivo.dealnnoy(n,m));
							time4 = System.currentTimeMillis();
							System.out.println("Rec Time = " 	  + (time4 - time3)+" ms");	
							break;
							
			case "-m":		Tabulation.runOut(n, m);// muestra la tabla por consola
		}
		
		
		System.out.println("\nFinish");

	}
	

}
