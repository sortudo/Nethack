package Role;

import Itens.Armor;
import Itens.Bow;
import Itens.CloakDisplacement;
import Itens.Weapon;
import Lucky.Dices;

public class Ranger extends Role{

	public Ranger() {
		super("Ranger", 14, 10, 10, 18, 14, 9, 13, 1, 12, new Dices(1,6,0), 1, new Bow(), new CloakDisplacement());
		// TODO Auto-generated constructor stub
	}

}
