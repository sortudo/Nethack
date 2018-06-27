package Role;
import Itens.LeatherArmor;
import Itens.ShortSword;

/**
 * class Rogue: fragil mas rápida no ataque
 * A habilidade secreta dela é Stealth
 * @author braga
 *
 */
public class Rogue extends Role{

	public Rogue() {
		super("Rogue", 15, 14, 14, 18, 14, 8, 10, 1, new ShortSword(), new LeatherArmor());
		// TODO Auto-generated constructor stub
	}

}
