package Itens;

public class Consumables extends Item{
	private int quant;
	
	public Consumables(String n, String des, int quant, int w, int l, int c) {
		super(n, des, w, 'c', l, c);
		this.setQuant(quant);
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
}
