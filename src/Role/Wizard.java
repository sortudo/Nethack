package Role;

import Itens.Armor;
import Itens.CloakMagicResistance;
import Itens.Quarterstaff;
import Itens.Weapon;
import Lucky.Dices;

public class Wizard extends Role{

	public Wizard() {
		super("Wizard", 10, 18, 10, 13, 13, 10, 10, new Dices(1,3,4).Roll(), 12, new Dices(1,8,0), 1, new Quarterstaff(), new CloakMagicResistance());
		// TODO Auto-generated constructor stub
	}

}
