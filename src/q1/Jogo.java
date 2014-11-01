//Barbara Camila C. Goncalves
package q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Jogo {

	Queue<Puzzle> fila;
	List<Puzzle> listaVisitados;

	public Jogo(Puzzle puzzle) {
		this.fila = new LinkedList<Puzzle>();
		this.fila.add(puzzle);
		this.listaVisitados = new ArrayList<Puzzle>();

	}

	// Fila - Armazena filhos do elemento checado no momento
	/**
	 * M�todo que gera os filhos a partir dos movimentos das pecas do Puzzle.
	 * @param puzzle - Puzzle inicial.
	 * @return lista de filhos ja visitados.
	 */
	public List<Puzzle> gerarFilhos(Puzzle puzzle) {

		int[][] aux = new int[3][3];
		int linha = -1, coluna = -1;
		int[] posicoes;
		int troca;
		Puzzle novo;

		posicoes = puzzle.checarPosicao();
		linha = posicoes[0];
		coluna = posicoes[1];
		List<Puzzle> filhosGerados = new ArrayList<Puzzle>();

		// movendo-se para cima
		if (linha >= 1) {
			aux = this.copiarMatriz(puzzle.getTabuleiro());
			troca = aux[linha - 1][coluna];
			aux[linha - 1][coluna] = 0;
			aux[linha][coluna] = troca;

			novo = new Puzzle(aux, puzzle);

				filhosGerados.add(novo);

		}

		// movendo-se para baixo
		if (linha <= 1) {
			aux = this.copiarMatriz(puzzle.getTabuleiro());
			troca = aux[linha + 1][coluna];
			aux[linha + 1][coluna] = 0;
			aux[linha][coluna] = troca;

			novo = new Puzzle(aux, puzzle);

				filhosGerados.add(novo);

		}


		// movendo-se para esquerda
		if (coluna >= 1) {
			aux = this.copiarMatriz(puzzle.getTabuleiro());
			troca = aux[linha][coluna - 1];
			aux[linha][coluna - 1] = 0;
			aux[linha][coluna] = troca;

			novo = new Puzzle(aux, puzzle);

				filhosGerados.add(novo);

		}

		// movendo-se para direita
		if (coluna <= 1) {
			aux = this.copiarMatriz(puzzle.getTabuleiro());
			troca = aux[linha][coluna + 1];
			aux[linha][coluna + 1] = 0;
			aux[linha][coluna] = troca;

			novo = new Puzzle(aux, puzzle);

				filhosGerados.add(novo);

		}
		return filhosGerados;
	}

	// Copiar a matriz
	/**
	 *Metodo para realizar a copia da matriz para auxiliar no movimento das pecas
	 * @param matriz
	 * @return matriz copia
	 */
	private int[][] copiarMatriz(int[][] matriz) {
		int[][] aux = new int[3][3];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				aux[i][j] = matriz[i][j];
			}
		}
		return aux;
	}

	public void teste(Puzzle teste) {
		this.gerarFilhos(teste);
		Puzzle puzzleTeste;

		System.out.println("Fila:");
		while (!this.fila.isEmpty()) {
			puzzleTeste = this.fila.remove();

			puzzleTeste.imprimir(puzzleTeste);
			System.out.println("--------");
		}
	}
	
	/**
	 * Metodo principal para a logica do jogo - Busca a solucao.
	 *eh utilizada a poda ao adicionar os filhos gerados;
	 * @param puzzleIdeal
	 */
	public void jogo(Puzzle puzzleIdeal) {
		Puzzle aux = null;
		boolean achou = false;

		do {
			aux = this.fila.remove();
			if (aux.equals(puzzleIdeal)) {
				achou = true;
				break;
			}
			if (!this.listaVisitados.contains(aux)) {
				this.listaVisitados.add(aux);
				this.fila.addAll(this.gerarFilhos(aux));
			}

		} while (!this.fila.isEmpty() && !achou);
		if (achou) {
			Stack<Puzzle> pilhaSolucao = new Stack<Puzzle>();
			while (aux != null) {
				pilhaSolucao.push(aux);
				aux = aux.getPai();
			}
			System.out.println("Numero de passos para a solucao: " + pilhaSolucao.size());
			while (!pilhaSolucao.isEmpty()) {
				aux = pilhaSolucao.pop();
				System.out.println(aux.toString());
			}

		} else {
			System.out.println("Nao ha solucao!! ");
		}
	}

	public Queue<Puzzle> getFila() {
		return fila;
	}

	public void setFila(Queue<Puzzle> fila) {
		this.fila = fila;
	}

	public List<Puzzle> getLista() {
		return listaVisitados;
	}

	public void setLista(List<Puzzle> lista) {
		this.listaVisitados = lista;
	}

	public String toString() {

		StringBuilder builder = new StringBuilder(" ");
		builder.append("[");
		for (int i = 0; i < this.listaVisitados.size(); i++) {
			builder.append(listaVisitados);
		}
		builder.append("]");

		return builder.toString();
	}

	public boolean contains(Puzzle puzzle) {
		boolean contem = false;

		for (Puzzle p : this.listaVisitados) {
			if (p.equals(puzzle)) {
				contem = true;
				break;
			}
		}
		return contem;

	}

}
