//Barbara Camila C. Gon�alves
package q1;

public class Main {

	public static void main(String[] args) {
	
	//int[][]	tabuleiro = new int[][] {{3, 0, 1}, {4, 7, 2}, {6, 8, 5}};
			//{{4,6,2},{8,1,3},{7,5,0}};
			//{ { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
	int[][] tabInicial =//{ { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
			//{{6,4,2},{8,1,3},{7,5,0}};
			{{4,6,2},{8,1,3},{7,5,0}};
		//{{1, 4, 2}, {0, 3, 5}, {6, 7, 8}};
	//{3, 0, 1}, {4, 7, 2}, {6, 8, 5} 
	int[][] tabelaIdeal = {{1,2,3},{4,5,6},{7,8,0}};
	Puzzle puzz = new Puzzle(tabelaIdeal);
	Jogo jogo = new Jogo(new Puzzle(tabInicial));
	
	//Puzzle puzzle = new Puzzle(tabuleiro, null);
	
	jogo.jogo(puzz);
	//puzzle.imprimir(puzzle);
	}

}
