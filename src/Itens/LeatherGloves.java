package Itens;

/**
 * class LeatherGloves: AC forte e nao é pesado
 * @author braga
 *
 */
public class LeatherGloves extends Armor{

	public LeatherGloves(int l, int c) {
		super("Leather Gloves", "The most basic kind of gloves", 1, 10, l, c);
		// TODO Auto-generated constructor stub
	}

	public LeatherGloves() {
		super("Leather Gloves", "The most basic kind of gloves", 1, 10, -1, -1);
	}
}
