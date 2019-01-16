package delannoy_numbers;

import java.math.BigInteger;

public class Tabulation {

	//  Dynamic Programming implementation (tabulation technique)
	private static boolean show = false;
	
	/**
	 * Metodo que calcula el numero dealnnoy de las coordenadas pasadas
	 * por parametro.
	 * 
	 * @param n: Columna
	 * @param m: Fila
	 * @return el numero resultante dealnnoy
	 */
	public static String dealnnoy (int n, int m) {
		
		String[][]dp = new String[m+1][n+1];
		
		// inicializamos la tabla con la primera fila y columna a 1
		for(int i = 0; i <= m; i++) dp[i][0] = "1";
		for(int i = 0; i <= n; i++) dp[0][i] = "1";
		
		// comenzamos 
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++)
				dp[i][j] = new BigInteger(dp[i-1][j]).add(
							new BigInteger(dp[i-1][j-1])).add(
								new BigInteger(dp[i][j-1])).toString();			
		
		
		if(show) out(n,m,dp);// ver los resultados
		
		return dp[m][n].toString();
	}
	
	
	/**
	 * Imprime por consola los resultados de la tabla dealnnoy
	 */
	private static void out(int n, int m, String[][]dp) {
		for(int i = 0; i <= m; i++) {
			System.out.println("");
			for(int j = 0; j <= n; j++) {
				System.out.print(dp[i][j]+" ");
			}
		}
	}
	
	
	public static void runOut(int n, int m) {
		show = true;
		dealnnoy(n, m);
	}
	


}
