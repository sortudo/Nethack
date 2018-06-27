package Itens;

import PlayNet.Player;

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
	public Armadura(String n, String des, int a, int w, int l, int c) {
		super(n, des, w,'a', l, c);
		AC = a;
	}
	
	public int getAC() {
		return AC;
	}
	
	@Override
	public void use(Player p, int index) {
		Armadura ar = p.getWield_a();
		p.setWield_a(this);
		p.setInventory(index, ar);
		
	}
}
