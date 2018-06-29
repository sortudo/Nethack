package Itens;

import Lucky.Dices;
import PlayNet.Player;

/**
 * abstract class Weapon: Representa todas as armas presentes no jogo
 * Damage: � o dano corpo-a-corpo que essa arma da no alvo
 * HitBonus: Aumenta a sua chance de acertar um ataque
 * Weight: Peso que o player carrega ao equipa-la
 * @author braga
 *
 */
public abstract class Weapon extends Item{
	private Dices Damage;
	private int hitBonus;
	
	public Weapon(String n, String des, Dices d, int h, int w, int l, int c) {
		super(n,des, w,'W', l, c);
		Damage = d;
		hitBonus = h;
	}
	
	/**
	 * Quando usada no inventario, a arma escolhida eh equipada
	 * e a que estava equipada vai para o inventario
	 */
	@Override
	public void use(Player p, int index) {
		System.out.println("Wield Weapon now is: " + this.getNome());
		Weapon wea = p.getWield_w();
		p.setWield_w(this);
		p.setInventory(index-1, wea);
	}
}
