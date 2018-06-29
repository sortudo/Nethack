package Race;

import Lucky.Dices;

/**
 * class Human: A raca mais equilibrada
 * @author braga
 *
 */
public class Human extends Race{
	public Human() {
		super("Human", 25, 18, 18, 18, 18, 18, 2, 1, new Dices(1,2,0), 1);
	}
}
