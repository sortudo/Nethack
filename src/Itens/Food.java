package Itens;

import PlayNet.Player;

public abstract class Food extends Consumables{
	private int nutrition;
	
	public Food(String n, String des, int quant, int nu, int w, int l, int c) {
		super(n, des, quant, w, l, c);
		// TODO Auto-generated constructor stub
		nutrition = nu;
	}

	public int getNutrition() {
		return nutrition;
	}

	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}
	
	@Override
	public void use(Player p, int index) {
		this.setQuant(this.getQuant() -1);
		p.setNutrition(p.getNutrition() + nutrition);
		System.out.println("You ate a " + this.getNome() + "! You feel less hungry.");
		if(this.getQuant() == 0)
			p.dropInventory(index-1);
	}
}
