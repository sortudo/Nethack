package Itens;

/**
 * abstract class Weapon: Representa todas as armas presentes no jogo
 * Damage: É o dano corpo-a-corpo que essa arma da no alvo
 * HitBonus: Aumenta a sua chance de acertar um ataque
 * Weight: Peso que o player carrega ao equipa-la
 * @author braga
 *
 */
public abstract class Weapon extends Item{
	private int Damage;
	private int hitBonus;
	private int weight;
	
	public Weapon(String n, String des, int d, int h, int w) {
		super(n,des);
		Damage = d;
		hitBonus = h;
		weight = w;
	}
}
