package Monster;

import Lucky.Dices;
import PlayNet.Game;
import PlayNet.GameObject;
import PlayNet.Player;
// Fazer os monstros perseguirem
/**
 * class Monster: Representa todos os monstros que tem no jogo
 * @author braga
 *
 */
public abstract class Monster extends GameObject{
	private Dices damage;
	private int level;
	private int AC;
	private int xp;
	private int hp;
	private String name;
	public Monster(String n, Dices d, int le, int a, int l, int c) {
		super('M', l, c);
		// TODO Auto-generated constructor stub
		setDamage(d);
		setLevel(le);
		setAC(a);
		setName(n);
		
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
	
	@Override
	public void onInteract(Player p, Game g) {
		if(p.getState_cap().equals(new String("Strained")) || p.getState_cap().equals("Overloaded"))
			System.out.println("You are carrying so many things that You can't move a muscle"); // Testa
		else {
			p.setExe_Str(p.getExe_Str()+1);
			int to_hit = new Dices(1,20,0).Roll();
			int to_hit_bonus = 1;
			to_hit_bonus += p.getWield_w().getHitBonus();
			to_hit_bonus += p.getTo_hitStr();
			to_hit_bonus += p.getTo_hitDex();
			to_hit_bonus += p.getLevel();
			if(p.getLevel() == 1 || p.getLevel() == 2)
				to_hit_bonus++;
			if(p.getState_cap().equals(new String("Stressed")))
				to_hit_bonus -= 3;
			if(p.getState_cap().equals(new String("Strained")))
				to_hit_bonus -= 5;
			to_hit_bonus -= (10 - AC)/2;
			
			if(to_hit_bonus > to_hit) {
				p.setExe_Dex(p.getExe_Dex()+1); // Apenas quando o player causa dano no inimigo
				int damage = p.getWield_w().getDamage().Roll();
				int total_damage = damage;
				if(AC < 0) {
					int damage_reduction = new Dices(1,-AC,0).Roll();
					total_damage = damage - damage_reduction;
					if(total_damage <= 0)
						total_damage = 1;
					
				}
				hp -= total_damage;
				System.out.println("You hitted " + getName() + "!");
				
				if(hp <= 0) {
					System.out.println(getName() + " was killed!");
					p.setXp(p.getXp() + xp);
					g.remove(this);
				}
			}else
				System.out.println("You missed the attack!");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
