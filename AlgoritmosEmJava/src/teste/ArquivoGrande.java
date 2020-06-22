package teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Dado um arquivo texto muito grande, que não caiba na memória – exemplo: 10Gb,
 * encontre as 50 mil frases mais frequentes. O formato do arquivo são linhas
 * com até 50 frases divididas por pipe ( “|” ).
 * 
 * @author cristianoalmeida
 *
 */
public class ArquivoGrande {

	public static void main (String args[]) throws IOException {
		for(String frase:frasesQueMaisAparecem()) {
			System.out.println(frase);
		}
	}
	
	private static List<String> frasesQueMaisAparecem() throws IOException{
		Map<String, Integer> fraseQuantidade = new HashMap<String, Integer>();

		 
		BufferedReader lerArq =new BufferedReader(new InputStreamReader(
                new ArquivoGrande().getClass().getResourceAsStream("testfile.txt")));

		String linha = lerArq.readLine(); // lê a primeira linha
		// a variável "linha" recebe o valor "null" quando o processo
		// de repetição atingir o final do arquivo texto
		while (linha != null) {
			// Para cada linha do arquivo

			for (String frase : linha.split("\\|")) {
				Integer existentes = fraseQuantidade.get(frase);
				if (existentes == null) {
					existentes = 0;
				}
				fraseQuantidade.put(frase, existentes + 1);
			}

			linha = lerArq.readLine(); // lê da segunda até a última linha
		}


		// Reorganiza frases por quantidade
		Map<String, Integer> frasesOrdenadasPelaQuantidade = sortByValueReverseOrder(fraseQuantidade);

		// Extrai as 50 mil frases que mais aparecem
		List<String> retorno = new ArrayList<String>();
		Set<String> keySet = frasesOrdenadasPelaQuantidade.keySet();
		int i = 0;
		for (String frase : keySet) {
			if (i < 50000) {
				retorno.add(frase);
			} else {
				break;
			}
		}

		// retorna
		return retorno;

	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueReverseOrder(Map<K, V> map) {
		List<Entry<K, V>> list = new ArrayList<>(map.entrySet());

		list.sort(Entry.comparingByValue(Comparator.reverseOrder()));

		Map<K, V> result = new LinkedHashMap<>();
		for (Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}
}
