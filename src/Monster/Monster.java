package Monster;

import Lucky.Dices;
import PlayNet.GameObject;

/**
 * class Monster: Representa todos os monstros que tem no jogo
 * @author braga
 *
 */
public class Monster extends GameObject{
	private Dices damage;
	private int level;
	private int AC;
	private int xp;
	private int hp;
	public Monster(Dices d, int le, int a, int l, int c) {
		super('M', l, c);
		// TODO Auto-generated constructor stub
		setDamage(d);
		setLevel(le);
		setAC(a);
		
		if(level != 0)
			setHp(new Dices(level,8,0).Roll());
		else
			setHp(new Dices(1,4,0).Roll());
		setXp((level*level)+20);
		if(AC == 2)
			setXp(getXp() + 5);
		else if(AC == 1)
			setXp(getXp() + 6);
		else if(AC == 0)
			setXp(getXp() + 7);
		else if(AC < 0)
			setXp(getXp() + (14+(-2*AC)));
		if(level >= 9)
			setXp(getXp() + 50);
	}
	public Dices getDamage() {
		return damage;
	}
	public void setDamage(Dices damage) {
		this.damage = damage;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAC() {
		return AC;
	}
	public void setAC(int aC) {
		AC = aC;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
}
