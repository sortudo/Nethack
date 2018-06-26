package Itens;



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
