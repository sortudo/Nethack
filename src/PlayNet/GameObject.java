package PlayNet;

/**
 * class GameObject: É tudo que tem no tabuleiro do NetHack
 * @author braga
 *
 */
public abstract class GameObject {
	private final char representacao;
	private int linha;
	private int coluna;
	
	public GameObject(char repr, int linhaInicial, int colunaInicial) {
		this.representacao = repr;
		this.linha = linhaInicial;
		this.coluna = colunaInicial;
	}

	public char getRepresentacao() {
		return this.representacao;
	}
	
	public void setPos(int l1, int c1) {
		this.linha = l1;
		this.coluna = c1;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public void onInteract() {}

	public void onInteract(Player p) {
		// TODO Auto-generated method stub	
	}
	
	public void onInteract(Player p, Game g) {
		// TODO Auto-generated method stub	
	}
}
