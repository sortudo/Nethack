package Itens;

/**
 * abstract class Armadura: Representa todas as armaduras presentes no jogo
 * AC: Se você recebe um ataque esse valor indica se você sofre dano ou se recebe dano reduzido
 * 	- Quanto menor o valor de AC menor o dano que o jogador recebe
 *  - Sem Armadura a AC do jogador fica 10    
 * Weight: Peso que o player tem que carregar ao vestir ela
 * @author braga
 *
 */
public abstract class Armadura extends Item{
	private int AC;
	private int weight;
	public Armadura(String n, String des, int a, int w) {
		super(n, des);
		AC = a;
		weight = w;
	}
	
	public int getAC() {
		return AC;
	}
}
