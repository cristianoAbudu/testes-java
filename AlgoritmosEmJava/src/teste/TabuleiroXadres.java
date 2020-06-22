package teste;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TabuleiroXadres {
	
	public static void main(String[] args) {
		
		
		// Montar o tabuleiro
		Integer[][] tabuleiro = new Integer[8][8];
		
		
		for(int linha=0; linha<8; linha++) {
			for(int coluna=0; coluna<8; coluna++) {
				tabuleiro[linha][coluna] = 8*linha + coluna+1;
				
			}			
		}
		
		List<Point> disponiveis = pegarDisponiveis(tabuleiro, null);
	
		List<Peca> pecaArray = new ArrayList<Peca>();
		
		// 8 rainhas
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		pecaArray.add(new Peca());
		
		List<Peca> pecasJaColocadas = new ArrayList<Peca>();
		
		for(Peca peca : pecaArray) {
			// Inserir  peça
		
			Point maiorScore = encontrarMaiorScore(tabuleiro, disponiveis);
			
			colocarPeca(tabuleiro, peca, maiorScore);
			
			pecasJaColocadas.add(peca);
			
			disponiveis = pegarDisponiveis(tabuleiro, pecasJaColocadas);
		
		}
		
		for(Peca peca : pecaArray) {
			
		}		
	
	}
	
	private static Point encontrarMaiorScore(Integer[][] tabuleiro, ) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Point> pegarDisponiveis(Integer [][] tabuleiro, Peca[] pecas) {
		List<Point> disponiveis = new ArrayList<Point>();
		
		for(int linha=0; linha<8; linha++) {
			for(int coluna=0; coluna<8; coluna++) {
				if(estaIndiponivel(linha,coluna, tabuleiro, pecas)) {
					disponiveis.add(new Point(linha, coluna));
				}
			}			
		}
		return disponiveis;
	}

	private boolean estaIndiponivel(int linha, int coluna, Integer[][] tabuleiro, Peca[] pecas) {
		return true;
	}
	
}

