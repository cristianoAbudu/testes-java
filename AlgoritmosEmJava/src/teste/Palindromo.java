package teste;

/**
 * Faça um algoritmo em Java que verifique se uma String é Palindromo, ou seja,
 * se a String “ao contrário” é igual. Ex: OVO, 1221. Um plus é receber um
 * argumento se deseja que a comparação seja case sensitive ou não e se deve
 * ignorar os espaços;
 * 
 * @author cristianoalmeida
 */
public class Palindromo {

	/**
	 * Executa o método com alguns casos para teste
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// Testando com alguns palíndromos caso simples:

		for (String palindromo : buildPalindromos()) {
			if (!isPalindromo(palindromo, false, false)) {
				throw new RuntimeException("Funcao isPalindromo retornou errado para palindromo: " + palindromo);
			}
		}

		// Testando com nao palindromos caso simples:
		for (String palindromo : buildNaoPalindromos()) {
			if (isPalindromo(palindromo, false, false)) {
				throw new RuntimeException("Funcao isPalindromo retornou errado para nao palindromo: " + palindromo);
			}
		}

		// Testando para palindromo case insensitive
		for (String palindromo : buildPalindromosCaseInsensitive()) {
			if (isPalindromo(palindromo, true, false)) {
				throw new RuntimeException(
						"Funcao isPalindromo retornou errado para palindromo com case insensitives: " + palindromo);
			}
		}

		// Testando para palindromo case sensitive
		for (String palindromo : buildPalindromosCaseInsensitive()) {
			if (!isPalindromo(palindromo, false, false)) {
				throw new RuntimeException(
						"Funcao isPalindromo retornou errado para palindromo ignorando case sensitive: " + palindromo);
			}
		}

		// Testando palindromos com espaco ignorando espaco:
		for (String palindromo : buildPalindromosComEspaco()) {
			if (!isPalindromo(palindromo, false, true)) {
				throw new RuntimeException(
						"Funcao isPalindromo ignorando espaço retornou errado para palindromo com espaco: "
								+ palindromo);
			}
		}

		// Testando palindromos com edspaco sem ignorar espaco:
		for (String palindromo : buildPalindromosComEspaco()) {
			if (isPalindromo(palindromo, false, false)) {
				throw new RuntimeException(
						"Funcao isPalindromo sem ignorar espaço retornou errado para palindromo com espaco: "
								+ palindromo);
			}
		}

	}

	/**
	 * Recebe uma palavra como parâmetro e descobre de acordo com os parâmetros
	 * caseSensitive e ignoreSpaces se a palavra é um palíndromo.
	 * 
	 * @param palavra
	 * @param caseSensitive
	 * @param ignoreSpaces
	 * @return
	 */
	private static boolean isPalindromo(String palavra, boolean caseSensitive, boolean ignoreSpaces) {
		if (ignoreSpaces) {
			// Limpar espaco em branco
			palavra = palavra.replace(" ", "");
		}
		// Criar string ao contrario a partir da String passada

		String invertida = new StringBuilder(palavra).reverse().toString();

		if (caseSensitive) {
			// Comparacao case sensitive
			return palavra.equals(invertida);
		} else {

			// Comparacao ignorando case
			return palavra.equalsIgnoreCase(invertida);

		}
	}

	/**
	 * Gera uma lista de nao palindromos aleatorios
	 * 
	 * @return
	 */
	private static String[] buildNaoPalindromos() {
		String[] palindromos = new String[31];

		int i = 0;
		palindromos[i++] = "biscoito";
		palindromos[i++] = "bolacha";
		palindromos[i++] = "raquete";
		palindromos[i++] = "estímulo";
		palindromos[i++] = "roger";
		palindromos[i++] = "vermelho";
		palindromos[i++] = "abudu";
		palindromos[i++] = "escore";
		palindromos[i++] = "estado";
		palindromos[i++] = "roubo";
		palindromos[i++] = "imposto";
		palindromos[i++] = "pavarotti";
		palindromos[i++] = "celular";
		palindromos[i++] = "escudo";
		palindromos[i++] = "tática";
		palindromos[i++] = "tácito";
		palindromos[i++] = "Thais";
		palindromos[i++] = "ditador";
		palindromos[i++] = "escoria";
		palindromos[i++] = "estrume";
		palindromos[i++] = "asterisco";
		palindromos[i++] = "esbornia";
		palindromos[i++] = "livro";
		palindromos[i++] = "fanta";
		palindromos[i++] = "literatura";
		palindromos[i++] = "lionize";
		palindromos[i++] = "yoga";
		palindromos[i++] = "academia";
		palindromos[i++] = "budismo";
		palindromos[i++] = "musica";
		palindromos[i++] = "acorde";

		return palindromos;
	}

	/**
	 * 
	 * Gera uma lista de 30 palindromos em portugues
	 * 
	 * @see <a href=
	 *      "https://www.soportugues.com.br/secoes/palindromos/palindromos1.php">https://www.soportugues.com.br/secoes/palindromos/palindromos1.php</a>
	 * 
	 * @return
	 */
	private static String[] buildPalindromos() {
		String[] palindromos = new String[31];

		int i = 0;
		palindromos[i++] = "asa";
		palindromos[i++] = "ata";
		palindromos[i++] = "ele";
		palindromos[i++] = "mamam";
		palindromos[i++] = "matam";
		palindromos[i++] = "metem";
		palindromos[i++] = "mirim";
		palindromos[i++] = "mussum";
		palindromos[i++] = "oco";
		palindromos[i++] = "Omo";
		palindromos[i++] = "osso";
		palindromos[i++] = "ovo";
		palindromos[i++] = "racificar";
		palindromos[i++] = "radar";
		palindromos[i++] = "reger";
		palindromos[i++] = "raiar";
		palindromos[i++] = "ralar";
		palindromos[i++] = "ramar";
		palindromos[i++] = "rapar";
		palindromos[i++] = "rasar";
		palindromos[i++] = "reler";
		palindromos[i++] = "reter";
		palindromos[i++] = "rever";
		palindromos[i++] = "reviver";
		palindromos[i++] = "rir";
		palindromos[i++] = "rodador";
		palindromos[i++] = "sacas";
		palindromos[i++] = "saias";
		palindromos[i++] = "salas";
		palindromos[i++] = "sanas";
		palindromos[i++] = "socos";

		return palindromos;
	}

	/**
	 * 
	 * Gera uma lista de 30 palindromos em portugues com algumas letras em maiusculo
	 * 
	 * @see <a href=
	 *      "https://www.soportugues.com.br/secoes/palindromos/palindromos1.php">https://www.soportugues.com.br/secoes/palindromos/palindromos1.php</a>
	 * 
	 * @return
	 */

	private static String[] buildPalindromosCaseInsensitive() {
		String[] palindromos = new String[31];

		int i = 0;
		palindromos[i++] = "asA";
		palindromos[i++] = "Ata";
		palindromos[i++] = "elE";
		palindromos[i++] = "mAmam";
		palindromos[i++] = "mAtam";
		palindromos[i++] = "mEtem";
		palindromos[i++] = "mIrim";
		palindromos[i++] = "musSum";
		palindromos[i++] = "Oco";
		palindromos[i++] = "Omo";
		palindromos[i++] = "Osso";
		palindromos[i++] = "Ovo";
		palindromos[i++] = "Racificar";
		palindromos[i++] = "Radar";
		palindromos[i++] = "Reger";
		palindromos[i++] = "Raiar";
		palindromos[i++] = "Ralar";
		palindromos[i++] = "Ramar";
		palindromos[i++] = "Rapar";
		palindromos[i++] = "Rasar";
		palindromos[i++] = "Reler";
		palindromos[i++] = "Reter";
		palindromos[i++] = "Rever";
		palindromos[i++] = "Reviver";
		palindromos[i++] = "Rir";
		palindromos[i++] = "Rodador";
		palindromos[i++] = "Sacas";
		palindromos[i++] = "Saias";
		palindromos[i++] = "Salas";
		palindromos[i++] = "Sanas";
		palindromos[i++] = "Socos";

		return palindromos;
	}

	/**
	 * 
	 * Gera uma lista de 30 palindromos em portugues com espaços entre as letras
	 * 
	 * @see <a href=
	 *      "https://www.soportugues.com.br/secoes/palindromos/palindromos1.php">https://www.soportugues.com.br/secoes/palindromos/palindromos1.php</a>
	 * 
	 * @return
	 */

	private static String[] buildPalindromosComEspaco() {
		String[] palindromos = new String[31];

		int i = 0;
		palindromos[i++] = "a sa";
		palindromos[i++] = "a ta";
		palindromos[i++] = "e le";
		palindromos[i++] = "m amam";
		palindromos[i++] = "m atam";
		palindromos[i++] = "m etem";
		palindromos[i++] = "m irim";
		palindromos[i++] = "m ussum";
		palindromos[i++] = "o co";
		palindromos[i++] = "O mo";
		palindromos[i++] = "o sso";
		palindromos[i++] = "o vo";
		palindromos[i++] = "r acificar";
		palindromos[i++] = "r adar";
		palindromos[i++] = "r eger";
		palindromos[i++] = "r aiar";
		palindromos[i++] = "r alar";
		palindromos[i++] = "r amar";
		palindromos[i++] = "r apar";
		palindromos[i++] = "r asar";
		palindromos[i++] = "r eler";
		palindromos[i++] = "r eter";
		palindromos[i++] = "r ever";
		palindromos[i++] = "r eviver";
		palindromos[i++] = "r ir";
		palindromos[i++] = "r odador";
		palindromos[i++] = "s acas";
		palindromos[i++] = "s aias";
		palindromos[i++] = "s alas";
		palindromos[i++] = "s anas";
		palindromos[i++] = "s ocos";

		return palindromos;
	}

}
