package PlayNet;

/**
 * class Wall: Representa as paredes da sala
 * O player nao pode atravessar elas
 * @author braga
 *
 */
public class Wall extends GameObject{
	public static final char REPR = '#';
	public Wall(int linhaInicial, int colunaInicial) {
		super(REPR, linhaInicial, colunaInicial);
		// TODO Auto-generated constructor stub
	}
	
}
