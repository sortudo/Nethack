package Spell;

public abstract class Spell {
	private String name;
	private String t_damage;
	private int power;
	private int damage;
	
	public Spell(String n, String t, int p, int d) {
		name = n;
		t_damage = t;
		power = p;
		damage = d;
	}
}
