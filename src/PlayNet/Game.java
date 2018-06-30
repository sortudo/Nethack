package PlayNet;

import Itens.Item;

/**
 * class Game: Representa o jogo em si.
 * Como funciona o seu tabuleiro e GameObjects dentro dele
 * @author braga
 *
 */
public class Game {
	private GameObject[][] tabuleiro;
	private int lin, col;
	
	/**
	 * Cria uma sala retangular
	 * @param linha
	 * @param coluna
	 */
	public Game(int linha, int coluna) {
		this.lin = linha;
		this.col = coluna;
		this.tabuleiro = new GameObject[lin][col];
		for(int i = 0; i < lin; i++) {
			this.tabuleiro[i][0] = new Wall(i,0);
			this.tabuleiro[i][col-1] = new Wall(i, col-1);
		}
		for(int i = 0; i < col; i++) {
			this.tabuleiro[0][i] = new Wall(0,i);
			this.tabuleiro[lin-1][i] = new Wall(lin-1,i);
		}
	}
	
	/**
	 * Desenha a sala no terminal
	 */
	public void Draw() {
		for(int i = 0; i < lin; i++) {
			for(int j = 0; j < col; j++) {
				if(this.tabuleiro[i][j] == null)
					System.out.printf(". ");
				else System.out.printf(this.tabuleiro[i][j].getRepresentacao() + " ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Cola um GameObject no jogo
	 * @param obj
	 */
	public void put(GameObject obj) {
		this.tabuleiro[obj.getLinha()][obj.getColuna()] = obj;
	}
	
	public void remove(GameObject obj) {
		this.tabuleiro[obj.getLinha()][obj.getColuna()] = null;
	}
	
	/**
	 * Movimenta o player de uma posicao para outra
	 * Nao pode atravessar Walls
	 * @param l0
	 * @param c0
	 * @param l1
	 * @param c1
	 */
	public void move(int l0, int c0, int l1, int c1) {
		if(!((Player)this.tabuleiro[l0][c0]).getState_cap().equals(new String("Overloaded"))) {
			if((this.tabuleiro[l1][c1] == null || this.tabuleiro[l1][c1] instanceof Item)) {
				if(this.tabuleiro[l1][c1] instanceof Item)
					this.tabuleiro[l1][c1].onInteract((Player) tabuleiro[l0][c0]);
				this.tabuleiro[l1][c1] = this.tabuleiro[l0][c0];
				this.tabuleiro[l0][c0] = null;
				this.tabuleiro[l1][c1].setPos(l1, c1);
			} else {
				this.tabuleiro[l1][c1].onInteract((Player)this.tabuleiro[l0][c0], this);
			}
		}
	}
}
