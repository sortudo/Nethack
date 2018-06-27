package poo.nethack.entities;

import poo.nethack.level.Level;

public abstract class Mob extends Entity{

	protected String name;
	protected int speed;
	protected int numSteps = 0;
	protected boolean isMoving;
	protected int movingDir = 1;
	protected int scale = 1;
	
	/** Construtor Mob
	 * 
	 * @param level
	 * @param name
	 * @param x
	 * @param y
	 * @param speed
	 */
	public Mob(Level level, String name, int x, int y, int speed) {
		super(level);
		
		this.name = name;
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
	
	/** Muda a direcao do player de acordo com os valores de xa e ya
	 * 
	 */
	public void move (int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(ya, 0);
			numSteps--;
			return;
		}
		
		numSteps++;
		if (!hasCollided(xa, ya)) {
			if (ya < 0) movingDir = 0;
			if (ya > 0) movingDir = 1;
			if (xa < 0) movingDir = 2;
			if (xa > 0) movingDir = 3;
			
			x += xa * speed;
			y += ya * speed;
		}
			
	}
	
	public abstract boolean hasCollided(int xa, int ya);
	
	public String getName(){
		return this.name;
	}

}
