package poo.nethack.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public String path;
	public int width;
	public int height;
	
	public int[] pixels;
	
	/** Construtor da class SpriteSheet que carrega sprite do jogo
	 * 
	 * @param path caminho da imagem 
	 */
	public SpriteSheet(String path) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (image == null)
			return;
		
		this.path = path;
		this.width = image.getWidth();
		this.height = image.getHeight();
		
		this.pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		// Remover alfa do hexa da imagem
		for (int i = 0; i < pixels.length; i++) 
			pixels[i] = (pixels[i] & 0xff) / 64; 
		
		for (int i = 0; i < 8; i++)
			System.out.println(pixels[i]);
		
		
	}
	
}
