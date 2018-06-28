package Role;
import Itens.LeatherArmor;
import Itens.ShortSword;
import Lucky.Dices;

/**
 * class Rogue: fragil mas rápida no ataque
 * A habilidade secreta dela é Stealth
 * @author braga
 *
 */
public class Rogue extends Role{

	public Rogue() {
		super("Rogue", 15, 14, 14, 18, 14, 8, 10, 1, 11, new Dices(1,8,0), 1,new ShortSword(), new LeatherArmor());
		// TODO Auto-generated constructor stub
	}

}
