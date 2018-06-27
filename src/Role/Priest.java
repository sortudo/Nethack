package Role;
import Itens.Mace;
import Itens.Robe;

/**
 * class Priest: Muito fraca no combate corpo-a-corpo
 * A habilidade secreta eh que ele pode rezar por ajuda de seu deus
 * @author braga
 *
 */
public class Priest extends Role{
	public Priest() {
		super("Priest", 12, 10, 18, 12, 13, 10, 12, 7, new Mace(), new Robe());
		// TODO Auto-generated constructor stub
	}
	
}
