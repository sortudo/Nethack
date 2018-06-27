package Itens;

import PlayNet.Player;

public class Apple extends Consumables{

	public Apple(int q, int l, int c) {
		super("Apple", "HEY APPLE!", q, 2, l, c);
		// TODO Auto-generated constructor stub
	}
	
	public Apple(int q) {
		super("Apple", "HEY APPLE!", q, 2, -1, -1);
	}
	
	@Override
	public void use(Player p, int index) {
		this.setQuant(this.getQuant() -1);
		// player.nutrition += nutrition;
		if(this.getQuant() == 0)
			p.dropInventory(index);
		System.out.println("You ate a " + this.getNome() + "! You feel less hungry.");
	}
}
