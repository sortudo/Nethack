package Classe;
import Itens.LongSword;
import Itens.RingMail;

/**
 * class Knight: A classe mais padrão dos rpgs
 * Tem um escudo que aumenta a AC do Knight
 * A habilidade secreta é que em alguns momentos o escudo anula totalmente o dano
 * @author braga
 *
 */
public class Knight extends Classe{

	public Knight() {
		super("Knight", 15, 8, 15, 8, 11, 17, 14, 3, new LongSword(), new RingMail());
		// TODO Auto-generated constructor stub
	}

}
