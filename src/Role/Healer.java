package Role;

import Itens.Armadura;
import Itens.LeatherGloves;
import Itens.Scalpel;
import Itens.Weapon;
import Lucky.Dices;

public class Healer extends Role{

	public Healer() {
		super("Healer", 9, 10, 16, 9, 14, 17, 11, new Dices(1,4,1).Roll(), 20, new Dices(1,8,0), 1,new Scalpel(), new LeatherGloves());
		// TODO Auto-generated constructor stub
	}

}
