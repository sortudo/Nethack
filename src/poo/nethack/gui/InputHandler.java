package poo.nethack.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
	
	/** Construtor do InputHandler
	 * 
	 * @param game
	 */
	public InputHandler(Game game) {
		// Adiciona o Listener aqui para nao precisar fazer na classe Game
		game.addKeyListener(this);
	}
	
	/** Classe para auxiliar no mapeamento de cada tecla
	 *
	 */
	public class Key {
		private int numTimesPressed = 0;
		private boolean pressed = false;
		
		public boolean isPressed() {
			return this.pressed;
		}
		
		public int getNumTimesPressed() {
			return this.numTimesPressed;
		}
		
		public void toggle(boolean isPressed) {
			pressed = isPressed;
			if (isPressed) numTimesPressed++;
		}
	}
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}
	
	/** Verifica qual tecla que foi pressionada
	 * 
	 * @param keyCode
	 * @param isPressed
	 */
	public void toggleKey(int keyCode, boolean isPressed) {
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) 
			up.toggle(isPressed);
		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) 
			down.toggle(isPressed);
		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) 
			left.toggle(isPressed);
		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) 
			right.toggle(isPressed);
		
	}
}
