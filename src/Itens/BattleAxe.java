package Itens;

import Lucky.Dices;

/**
 * class BattleAxe: A arma mais forte corpo-a-corpo presente até agora
 * Ela também é arma inicial do Barbarian
 * @author braga
 *
 */
public class BattleAxe extends Weapon{
	public BattleAxe(int l, int c) {
		super("Battle Axe", "A very powerful two-handed version of the regular Axe", new Dices(1, 10, 2), 0, 120, l, c);
	}
	
	public BattleAxe() {
		super("Battle Axe", "A very powerful two-handed version of the regular Axe", new Dices(1, 10, 2), 0, 120, -1, -1);
	}
}
