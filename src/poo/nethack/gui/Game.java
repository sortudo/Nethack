package poo.nethack.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import poo.nethack.entities.Player;
import poo.nethack.gfx.Screen;
import poo.nethack.gfx.SpriteSheet;
import poo.nethack.level.Level;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	
	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH/12 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "NetHack";
	
	private JFrame frame;
	
	public boolean running = false;
	public int tickCount = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private int[] colours = new int[216];
	
	private Screen screen;
	public InputHandler input;
	public Level level;
	public Player player;
	
	public Game() {
		// Coloca tamanho do Canvas que sera utilizado
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		// Inicializa JFrame com funcoes basicas
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// Adiciona Canvas ao JFrame 
		frame.add(this, BorderLayout.CENTER);
		// JFrame pega as configuracoes de dimensao do canvas adicionado
		frame.pack();
		
		// Configuracoes de redimensionamento e faz frame visivel
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	@Override
	public void run() {
		// Calculo do frame de atualizacao
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		init();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			// Adiciona delay para o tick()
			while (delta >= 1) {
				ticks++;
				tick();	
				delta -= 1;
				shouldRender = true;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (shouldRender) {
				frames++;
				render();
			}
			
			// Reseta valores de delay
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				
				System.out.println(ticks + " ticks, " + frames + " frames");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void init() {
		int index = 0;
		for (int r = 0; r < 6; r++) {
			for (int g = 0; g < 6; g++) {
				for (int b = 0; b < 6; b++) {
					int rr = (r * 255 / 5);
					int gg = (r * 255 / 5);
					int bb = (r * 255 / 5);
					
					colours[index++] = rr << 16 | gg << 8 | bb;
				}
			}
		}
		
		
		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite.png"));
		input = new InputHandler(this);
		level = new Level(64, 64);
		player = new Player(level, 0, 0, input);
		level.addEntity(player);
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
	}
	
	private int x = 0, y = 0;
	
	/** Atualizar as variaveis e logica do jogo
	 * 
	 */
	public void tick() {
		tickCount++;
		
		
		level.tick();
	}
	
	/** Atualiza o jogo de acordo com a logica da tick
	 * 
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			// Certifica que nao possui ruido na imagem caso demore a renderizar
			createBufferStrategy(3);
			return; 
		}
		
		int xOffset = player.x - (screen.width/2);
		int yOffset = player.y - (screen.height/2);
		
		level.renderTiles(screen, xOffset, yOffset);
		level.renderEntities(screen);
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game().start();
	}

}
