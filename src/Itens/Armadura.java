package Itens;

public class Armadura extends Item{
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
