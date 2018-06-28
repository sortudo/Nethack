package Role;

import Itens.BattleAxe;
import Itens.RingMail;
import Lucky.Dices;

/**
 * class Barbarian: Eh a classe com maior dano bruto corpo-a-corpo
 * A habilidade secreta dele é ter resistencia contra veneno
 * @author braga
 *
 */
public class Barbarian extends Role{	
	public Barbarian() {
		super("Barbarian", 18, 7, 7, 17, 18, 6, 14+3, 1, 10, new Dices(1,10,0), 2,new BattleAxe(), new RingMail());
	}
	
}
