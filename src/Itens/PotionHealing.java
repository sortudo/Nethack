package Itens;

import Lucky.Dices;
import PlayNet.Player;

public class PotionHealing extends Potions{

	public PotionHealing(int quant, int l, int c) {
		super("Potion of Healing", "This will heal you.", quant, 20, l, c);
		// TODO Auto-generated constructor stub
	}

	public PotionHealing(int quant) {
		super("Potion of Healing", "This will heal you.", quant, 20, -1, -1);
	}
	
	@Override
	public void use(Player p, int index) {
		System.out.println("You drinked " + this.getNome() +"! You feel healthy.");
		p.setLife(p.getLife() + new Dices(7,4,0).Roll());
		if(p.getLife() > p.getMax_life())
			p.setLife(p.getMax_life());
		this.setQuant(this.getQuant() -1);
		if(this.getQuant() == 0)
			p.dropInventory(index);
	}
}
