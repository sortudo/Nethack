package poo.nethack.gfx;

public class Screen {
	
	public static final int MAP_WIDTH = 64;
	public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;
	
	public static final byte BIT_MIRROR_X = 0x01;
	public static final byte BIT_MIRROR_Y = 0x02;
	
	public int[] pixels;
	
	public int xOffset = 0;
	public int yOffset = 0;
	
	public int width;
	public int height;
	
	public SpriteSheet sheet;
	
	/** Construtor da Screen
	 * 
	 * @param width
	 * @param height
	 * @param sheet
	 */
	public Screen(int width, int height, SpriteSheet sheet) {
		this.width = width;
		this.height = height;
		this.sheet = sheet;
		
		pixels = new int[width * height];
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/** Funcao auxiliar para nao precisar colocar se vai fazer 'mirror'
	 * 
	 * @param xPos
	 * @param yPos
	 * @param tile
	 * @param colour
	 */
	public void render(int xPos, int yPos, int tile, int colour) {
		render(xPos, yPos, tile, colour, 0x00);
	}
	
	/** Funcao para identificar o pixel da sheet e colocar na tela
	 * 
	 * @param xPos
	 * @param yPos
	 * @param tile
	 * @param colour
	 * @param mirrorDir
	 */
	public void render(int xPos, int yPos, int tile, int colour, int mirrorDir) {
		xPos -= xOffset;
		yPos -= yOffset;
		
		boolean mirrorX = (mirrorDir & BIT_MIRROR_X) > 0;
		boolean mirrorY = (mirrorDir & BIT_MIRROR_Y) > 0;
		
		// Matriz de 32 x 32 com 8 bits cada quadrado
		int xTile = tile % 32;
		int yTile = tile / 32;
		int tileOffset = (xTile << 3) + (yTile << 3) * sheet.width;
		
		for (int y = 0; y < 8; y++) {
			if (y + yPos < 0 || y + yPos >= height) continue;
			int ySheet = y;
			if (mirrorY) ySheet = 7 - y;
			for (int x = 0; x < 8; x++) {
				if (x + xPos < 0 || x + xPos >= width) continue;
				int xSheet = x;
				if (mirrorX) xSheet = 7 - x;
				int col = (colour >> (sheet.pixels[xSheet + ySheet * sheet.width + tileOffset] * 8)) & 255;
				
				if (col < 255) pixels[x+xPos + (y+yPos) * width] = col;
			}
		}
	}
}
