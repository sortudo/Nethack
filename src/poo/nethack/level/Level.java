package poo.nethack.level;

import java.util.ArrayList;
import java.util.List;

import poo.nethack.entities.Entity;
import poo.nethack.gfx.Screen;

public class Level {
	
	private byte[] tiles;
	public int width;
	public int height;
	public List<Entity> entities = new ArrayList<>();
	
	/** Construtor da classe Level de acordo com o tamanho desejado
	 * 
	 * @param width
	 * @param height
	 */
	public Level(int width, int height) {
		tiles = new byte[width * height];
		this.width = width;
		this.height = height;
		this.generateLevel();
	}
	
	/** Geracao de um nivel padrao apenas para realizar teste
	 * 
	 */
	public void generateLevel() {
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				if (x * y % 10 < 5)
					tiles[x + y * width] = Tile.GRASS.getId();
				else
					tiles[x + y * width] = Tile.STONE.getId();
			}
		}
	}
	
	/** Atualiza os personagens que estao no nivel
	 * 
	 */
	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
	}
	
	/** Renderiza cada objeto do mapa
	 * 
	 * @param screen
	 * @param xOffset
	 * @param yOffset
	 */
	public void renderTiles(Screen screen, int xOffset, int yOffset) {
		if (xOffset < 0) xOffset = 0;
		if (xOffset > ((width << 3) - screen.width)) xOffset = ((width << 3) - screen.width);
		if (yOffset < 0) yOffset = 0;
		if (yOffset > ((height << 3) - screen.height)) yOffset = ((height) - screen.height);
		
		screen.setOffset(xOffset, yOffset);
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(screen, this, x << 3, y << 3);
			}
		}
	}
	
	/** Renderiza os personagens que estao no nivel
	 * 
	 * @param screen
	 */
	public void renderEntities(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
	}
	
	/** Retorna o tipo de objeto
	 * 
	 * @param x
	 * @param y
	 * @return Tile com o tipo de objeto em (x,y) do mapa
	 */
	private Tile getTile(int x, int y) {
		if (x < 0 || x > width || y < 0 || y > height) return Tile.VOID;
		return Tile.tiles[tiles[x + y * width]];
	}
	
	/** Adiciona Jogador ao nivel
	 * 
	 * @param entity jogador
	 */
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
}
