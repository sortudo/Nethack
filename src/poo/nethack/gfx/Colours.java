package poo.nethack.gfx;

public class Colours {
	
	/** Tratamento da cor que esta no sprite
	 * 
	 * @param colour1 
	 * @param colour2 
	 * @param colour3 
	 * @param colour4 
	 * @return int com valor da cor utilizada
	 */
	public static int get(int colour1, int colour2, int colour3, int colour4) {
		return (get(colour4) << 24) + (get(colour3) << 16) + (get(colour2) << 8) + (get(colour1));
	}
	
	/** Converte cor para o formado RGB 
	 * 
	 * @param colour
	 * @return int com valor do rgb da cor desejada
	 */
	private static int get(int colour) {
		if (colour < 0) return 255;
		int r = colour / 100 % 10;
		int g = colour / 10 % 10;
		int b = colour % 10;
		return r * 36 + g * 6 + b;
	}
	
}
