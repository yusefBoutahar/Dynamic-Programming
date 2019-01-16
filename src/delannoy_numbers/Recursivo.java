package delannoy_numbers;

public class Recursivo {
	
	//  Classic recursive implementation

	/**
	 * Metodo que calcula el numero dealnnoy de las coordenadas pasadas
	 * por parametro.
	 * 
	 * @param n: Columna
	 * @param m: Fila
	 * @return el numero resultante dealnnoy
	 */
	public static int dealnnoy(int n, int m) {
		
		if(m == 0 || n == 0) return 1;
		
		return dealnnoy(m-1,n)+
				dealnnoy(m-1,n-1)+
				dealnnoy(m,n-1);
	}


}
