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
import Lucky.Dices;
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
	private int regeneration = 1;
	private int reg_count = 0;
	private int reg_turn = 15;
	private int pw_count;
	private int nutrition = 900;
	private int max_cap;
	private int atual_cap;
	private int count_cap = 0;
	private String state_cap = "";
	private String nu_state = "";
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
					if(index > 0 && index <= j) {
						if(ud == 1) {
							Inventory.get(index-1).use(this, index);
						}else if(ud == 2){
							System.out.println("You dropped " + Inventory.get(index-1).getNome() + "!");
							dropInventory(index-1);
						}else {
							System.out.println(Inventory.get(index-1).getNome() + ": " + Inventory.get(index-1).getDescricao());
						}
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
	
	public String getRacename() {
		return race.getName();
	}
	
	public Role getRole() {
		return role;
	}
	
	public Race getRace() {
		return race;
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
		return role.getCha();
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
		if(!(i instanceof Consumables))
			atual_cap += i.getWeight();
		else
			atual_cap += ((Consumables) i).getWeight() * ((Consumables) i).getQuant();
	}

	public Weapon getWield_w() {
		return wield_w;
	}

	public void setWield_w(Weapon wield_w) {
		this.wield_w = wield_w;
		atual_cap += wield_w.getWeight();
	}

	public Armadura getWield_a() {
		return wield_a;
	}

	public void setWield_a(Armadura wield_a) {
		this.wield_a = wield_a;
		atual_cap += wield_a.getWeight();
	}
	
	public void setInventory(int index, Item i) {
		Inventory.set(index, i);
	}
	
	public void dropInventory(int index) {
		if(!(Inventory.get(index) instanceof Consumables)) {
			atual_cap -= Inventory.get(index).getWeight();
		}else { 
			atual_cap -= ((Consumables)Inventory.get(index)).getWeight() * ((Consumables)Inventory.get(index)).getQuant();
		}
		Inventory.remove(index);
	}
	
	public void levelUp() {
		boolean levelupped = false;
		if(level < 10) {
			if(xp >= Math.pow(2, level+1)*10) {
				level++;
				levelupped = true;
			}
			if(level == 1)
				reg_turn = 15;
			else if(level == 2)
				reg_turn = 11;
			else if(level == 3)
				reg_turn = 9;
			else if(level == 4)
				reg_turn = 8;
			else if(level == 5)
				reg_turn = 7;
			else if(level == 6)
				reg_turn = 6;
			else if(level == 7)
				reg_turn = 5;
			else if(level == 8)
				reg_turn = 5;
			else if(level == 9)
				reg_turn = 4;
			else if(level == 10)
				reg_turn = 3;
		}else if (level >= 10 && level < 20)
			if(xp >= Math.pow(2, level-9)*10000) {
				level++;
				levelupped = true;
			}
		else if(level >= 20)
			if(xp >= (level-19)*10000000) {
				level++;
				levelupped = true;
			}
		if(levelupped) {
			if(this.level < role.getH_level()) {
				this.setLife(life + role.getLow().Roll() + race.getL_l().Roll());
				this.setMax_life(max_life + role.getLow().Roll() + race.getL_l().Roll());
			}else {
				this.setLife(life + role.getHigh() + race.getH_l());
				this.setMax_life(max_life + role.getHigh() + race.getH_l());
			}
			power += ((role.getWis()/2)+1);
			max_power += ((role.getWis()/2)+1);
		}
		if(level > 10)
			if(role.getCon() > 12)
				regeneration = new Dices(1,role.getCon(),0).Roll();
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getReg_count() {
		return reg_count;
	}

	public void setReg_count(int reg_count) {
		this.reg_count = reg_count;
	}
	
	public void Regeneration() {
		reg_count++;
		pw_count++;
		if(getState_cap().equals(new String("Stressed")) || getState_cap().equals(new String("Strained")) || getState_cap().equals(new String("Overloaded"))) {
			reg_count = 0;
			pw_count = 0;
		}
		System.out.println("Reg_count: " + reg_count);
		if(reg_count == reg_turn) {
			reg_count = 0;
			life += regeneration;
			if(life > max_life) {
				life = max_life;
			}
		}
		if(pw_count > (38 - level)*(2/3)) {
			pw_count = 0;
			power += new Dices(1,((role.getWis() + role.getInt())/15)+1,0).Roll();
			if(power > max_power)
				power = max_power;
		}
	}
	
	public void Nutrition() {
		setNutrition(getNutrition() - 1);
		if(getState_cap().equals(new String("Stressed")) || getState_cap().equals(new String("Strained")) || getState_cap().equals(new String("Overloaded")))
			setNutrition(getNutrition() - 1);
		if(getNutrition() >= 1000)
			setNu_state("Satiated");
		else if(getNutrition() >= 150 && getNutrition() < 1000)
			setNu_state("Not Hungry");
		else if(getNutrition() >= 50 && getNutrition() < 150)
			setNu_state("Hungry");
		else if(getNutrition() > 0 && getNutrition() < 50)
			setNu_state("Fainting");
		else if(getNutrition() == 0)
			life = 0;
	}

	public int getNutrition() {
		return nutrition;
	}

	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}

	public String getNu_state() {
		return nu_state;
	}

	public void setNu_state(String nu_state) {
		this.nu_state = nu_state;
	}
	
	public void Capacity() {
		max_cap = (25*(this.getSt() + this.getCo()) + 25);
		System.out.println("Max: " + max_cap);
		System.out.println("Atual: " + atual_cap);
		if(atual_cap < (1.5*max_cap))
			setState_cap("Unencumbered");
		else if (atual_cap >= 1.5*max_cap && atual_cap < 2*max_cap)
			setState_cap("Stressed");
		else if(atual_cap >= 2*max_cap && atual_cap < 3*max_cap)
			setState_cap("Strained");
		else if(atual_cap > 3*max_cap)
			setState_cap("Overloaded");
		
		if(getState_cap().equals(new String("Strained")) || getState_cap().equals(new String("Overloaded"))) {
			count_cap++;
			if(count_cap == 10) {
				count_cap = 0;
				life -= 1;
			}
		}
	}

	public String getState_cap() {
		return state_cap;
	}

	public void setState_cap(String state_cap) {
		this.state_cap = state_cap;
	}
	
	public void Alive() {
		Nutrition();
		levelUp();
		Capacity();
		Regeneration();
	}
}
