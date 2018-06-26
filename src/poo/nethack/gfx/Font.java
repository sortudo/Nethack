package poo.nethack.gfx;

public class Font {
	
	// Caracteres que estao no final do arquivo 'sprite_sheet.png'
	private static String chars = "ABCDEFGHIJKLMNOPRSTUVWXYZ      "
			+ "0123456789.,:;'\"!?$%()-=+/      ";
	
	/** Rederiza a fonte na tela de acordo com a mensagem pedida
	 * 
	 * @param msg
	 * @param screen
	 * @param x
	 * @param y
	 * @param colour
	 */
	public static void render(String msg, Screen screen, int x, int y, int colour) {
		msg = msg.toUpperCase();
		
		for (int i = 0; i < msg.length(); i++) {
			int charIndex = chars.indexOf(msg.charAt(i));
			if (charIndex >= 0) screen.render(x + (i*8), y, charIndex + 30 * 32, colour);
		}
	}

}
