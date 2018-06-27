package PlayNet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.*;
import java.lang.Math;

import Itens.Armadura;
import Itens.Consumables;
import Itens.Food;
import Itens.Item;
import Itens.Potions;
import Itens.Weapon;
import Race.Race;
import Role.Role;
public class Player extends GameObject {
	private String name;
	private Role role;
	private Race race;
	private String gender;
	private int level = 1;
	private int gold = 0;
	private ArrayList<Item> Inventory = new ArrayList<>();
	public static final char REPR = 'P';
	private int life = 0;
	private int max_life = 0;
	private int power = 0;
	private int max_power = 0;
	private int xp = 0;
	private Weapon wield_w;
	private Armadura wield_a;
	private HashMap<String, Consumer<Game>> comandos = new HashMap<>();

	public Player(int lin, int col) {
		super(REPR, lin, col);
		comandos.put("4", g -> {
			g.move(getLinha(), getColuna(), getLinha(), getColuna()-1);
		});
		comandos.put("8", g -> {
			g.move(getLinha(), getColuna(), getLinha()-1, getColuna());
		});
		comandos.put("6", g -> {
			g.move(getLinha(), getColuna(), getLinha(), getColuna()+1);
		});		
		comandos.put("2", g -> {
			g.move(getLinha(), getColuna(), getLinha()+1, getColuna());
		});
		comandos.put("7", g -> {
			g.move(getLinha(), getColuna(), getLinha()-1, getColuna()-1);
		});
		comandos.put("9", g -> {
			g.move(getLinha(), getColuna(), getLinha()-1, getColuna()+1);
		});
		comandos.put("3", g -> {
			g.move(getLinha(), getColuna(), getLinha()+1, getColuna()+1);
		});
		comandos.put("1", g -> {
			g.move(getLinha(), getColuna(), getLinha()+1, getColuna()-1);
		});
		comandos.put("5", g -> {
			int j = 0;
			int index = 0, ud = 0;
			System.out.println("\t---- Inventory ----");
			System.out.println("Equiped:");
			System.out.println("\t- " + getWield_w().getNome());
			System.out.println("\t- " + getWield_a().getNome());
			for(Item i : Inventory) {
				j++;
				System.out.print( j + " - " + i.getNome());
				if(i instanceof Consumables) System.out.print("\t" + "x" + ((Consumables)i).getQuant());
				System.out.println("");
			}
			System.out.println("\t---- End of Inventory ----");
			if(!Inventory.isEmpty()) {
				System.out.println("Do you wanna use an item or drop? (other for none, 1 for use, 2 for drop and 3 for info)");
				try {
					ud = EntradaTeclado.leInt();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(ud == 1 || ud == 2 || ud == 3) {
					System.out.println("Choose the item:");
					try {
						index = EntradaTeclado.leInt();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(index > 0 && index <= j)
						if(ud == 1)
							Inventory.get(index-1).use(this, index-1);
						else if(ud == 2){
							Inventory.remove(index-1);
							System.out.println("You dropped " + Inventory.get(index-1).getNome() + "!");
						}else {
							System.out.println(Inventory.get(index-1).getNome() + ": " + Inventory.get(index-1).getDescricao());
						}
				}
			}
		});
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void action(Game g, String s) {
		Consumer<Game> funcao = comandos.get(s);
		
		if(funcao != null)funcao.accept(g);
		else System.out.println("Comando inválido! Digite novamente");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public void setRole(Role s) {
		role = s;
		setLife(getLife() + s.getS_hp());
		setMax_life(getMax_life() + s.getS_hp());
		power += s.getS_pw();
		max_power += s.getS_pw();
		setWield_w(s.getWea());
		setWield_a(s.getArm());
	}
	
	public void setGender(String g) {
		gender = g;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setRace(Race r) {
		race = r;
		setLife(getLife() + r.getS_hp());
		setMax_life(getMax_life() + r.getS_hp());
		power += r.getS_pw();
		max_power += r.getS_pw();
	}
	
	public String getRace() {
		return race.getName();
	}
	
	public String getClasse() {
		return role.getName();
	}
	
	public int getSt() {
		return role.getStr();
	}
	public int getDx() {
		return role.getDex();
	}
	public int getCo() {
		return role.getCon();
	}
	public int getIn() {
		return role.getInt();
	}
	public int getWi() {
		return role.getWis();
	}
	public int getCh() {
		return role.getDex();
	}

	public int getNivel() {
		return level;
	}

	public void setNivel(int nivel) {
		level = nivel;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getMax_life() {
		return max_life;
	}

	public void setMax_life(int max_life) {
		this.max_life = max_life;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMax_power() {
		return max_power;
	}

	public void setMax_power(int max_power) {
		this.max_power = max_power;
	}
	
	public int getAC() {
		return role.getAC();
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public void addInventory(Item i) {
		Inventory.add(i);
	}

	public Weapon getWield_w() {
		return wield_w;
	}

	public void setWield_w(Weapon wield_w) {
		this.wield_w = wield_w;
	}

	public Armadura getWield_a() {
		return wield_a;
	}

	public void setWield_a(Armadura wield_a) {
		this.wield_a = wield_a;
	}
	
	public void setInventory(int index, Item i) {
		Inventory.set(index, i);
	}
	
	public void dropInventory(int index) {
		Inventory.remove(index);
	}
	
	public void levelUp() {
		if(level < 10)
			if(xp >= Math.pow(2, level+1)*10)
				level++;
		else if (level >= 10 && level < 20)
			if(xp >= Math.pow(2, level-9)*10000)
				level++;
		else if(level >= 20)
			if(xp >= (level-19)*10000000);
				level++;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
