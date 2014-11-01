//Barbara Camila C. Goncalves
package q1;

import java.util.Arrays;

public class Puzzle {
	
	private int[][] tabuleiro;
	private Puzzle pai;
	
	public Puzzle(int[][] tabuleiro) {
		super();
		this.tabuleiro = tabuleiro;
	}
	
	/**
	 * Metodo para checar onde esta o espaco vazio no puzzle
	 * @return posicao do zero.
	 */
	public int[] checarPosicao() {
		int[] posicao = new int[2];
		int i,j = 0;
		for ( i = 0; i < this.tabuleiro.length; i++) {
			for ( j = 0; j < this.tabuleiro[i].length; j++) {
				if(this.tabuleiro[i][j]== 0){
					posicao[0] = i;
					posicao[1] = j;
					break;
 				}
			}
		}
		return posicao;
	}
	
	public Puzzle(int[][] tabuleiro, Puzzle pai) {
		super();
		this.tabuleiro = tabuleiro;
		this.pai = pai;
	}
	
	public int[][] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public Puzzle getPai() {
		return pai;
	}
	public void setPai(Puzzle pai) {
		this.pai = pai;
	}
	
	
	public boolean equals(Puzzle puzzle) {
		boolean checar = true;
		int[][] aux = puzzle.getTabuleiro();
		for (int i = 0; i < this.tabuleiro.length && checar; i++) {
			for (int j = 0; j < this.tabuleiro[i].length && checar; j++) {
				if (this.tabuleiro[i][j] != aux[i][j]) {
					checar = false;
				}
			}
		}
		return checar;

	}

	public void imprimir(Puzzle q){
		
		for(int i = 0; i< q.tabuleiro.length; i++ ){
			System.out.println(" ");
			for(int j= 0 ; j < q.tabuleiro[i].length;j++){
			System.out.print(q.tabuleiro[i][j] + " ");
		}
			System.out.println(" ");
		}
	}
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tabuleiro.length; i++) {
			sb.append("[");
			for (int j = 0; j < tabuleiro[i].length; j++) {
				sb.append(this.tabuleiro[i][j] + "|");
			}
			sb.append("]\n");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puzzle other = (Puzzle) obj;
		if (!Arrays.deepEquals(this.tabuleiro, other.tabuleiro))
			return false;
		return true;
	}
}

