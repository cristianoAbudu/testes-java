package teste;

/**
 * Escreva um algoritmo eficiente, para encontrar “K-Complementary Pairs”. Dado
 * um array A, e um inteiro K, o par (i, j) é um K-Complementary se K = A[i] +
 * A[J]. Um plus será informar o Big-O do algoritmo;
 * 
 * @author cristianoalmeida
 *
 */
public class KComplementary {
	
	public static void main(String[] args) {
		
		testeSemNenhumKComplementary();
		
		testeTodosKComplementary();
		
		testeKComplementaryPosicoes01e29();
		
		compararTempoBruteForceVsAPI();
		
	}

	private static void testeSemNenhumKComplementary() {
		// Teste sem nenhum k complementary
		Integer[][] nenhumKComplementary = bruteForce(new int[] {9,18,27,36,45,54,63,72,81,90},0);
		
		for(int i = 0; i<10; i++ ) {
			for(int j=i+1; j<10; j++) {
				if(nenhumKComplementary[i][j] != null) {
					throw new RuntimeException("bruteForce retornou errado para posicao ("+i+","+j+")");
				}
			}
		}
	}

	private static void testeTodosKComplementary() {
		// Teste com todos k complementaries
		
		Integer[][] kComplementary = bruteForce(new int[] {0,0,0,0,0,0,0,0,0,0},0);
		
		for(int i = 0; i<10; i++ ) {
			for(int j=i+1; j<10; j++) {
				if(kComplementary[i][j] == null) {
					throw new RuntimeException("bruteForce retornou errado para posicao ("+i+","+j+")");
				}
			}
		}
	}

	private static void testeKComplementaryPosicoes01e29() {
		// Teste com k complementary nas posicoes (0,1) e (2,9)
		
		Integer[][] kComplementary01and39 = bruteForce(new int[] {1,3,2,0,0,0,0,0,0,2},4);
		
		for(int i = 0; i<10; i++ ) {
			for(int j=i+1; j<10; j++) {
				if(!(i==0 && j==1 || i==2 && j==9) && kComplementary01and39[i][j] != null ) {
					throw new RuntimeException("bruteForce retornou errado para posicao ("+i+","+j+")");
				}
			}
		}
	}

	private static void compararTempoBruteForceVsAPI() {
		// Comparando tempos de resposta entre minha implementacao (brute force) 
		// e outra extraida da internet usando a API do Java
		
		int[] array = new int[] {9,18,27,36,45,54,63,72,81,90, 942,442,432,432,432,423};
		com.marcosbarbero.demo.KComplementary kComplementaryAPI = new com.marcosbarbero.demo.KComplementary();

		long startMillisBruteForce = System.currentTimeMillis();
		bruteForce(array,0);
		long endMillisBruteForce = System.currentTimeMillis();
		
		long timeBruteForce = endMillisBruteForce - startMillisBruteForce;
		
		
		long startMillisAPI = System.currentTimeMillis();
		kComplementaryAPI.complementaryPairs(0, array);
		long endMillisAPI = System.currentTimeMillis();

		long timeAPI = endMillisAPI = startMillisAPI;
		
		if(timeAPI > timeBruteForce) {
			System.out.println("Brute force mais rapido que API");
		}else {
			System.out.println("API mais rapido que brute force");
		}
	}

	/**
	 * * Solução "brute force" para o problema, complexidade O(n) onde n é o tamanho
	 * do array pair(i,j) é um k-complementary quando retorno dessa funçao em (i,j)
	 * for diferente de null
	 * 
	 * @param array
	 * @param k
	 * @return
	 */

	private static Integer[][] bruteForce(int[] array, int k) {

		Integer[][] retorno = new Integer[array.length][array.length];

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == k) {
					retorno[i][j] = k;
				}
			}
		}

		return retorno;
	}
	
	

}
