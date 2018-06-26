package PlayNet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.*;

import Classe.Classe;
import Itens.Item;
import Race.Race;
public class Player extends GameObject {
	private String name;
	private Classe role;
	private Race race;
	private String gender;
	private int nivel = 1;
	private int gold = 0;
	private ArrayList<Item> Inventory;
	public static final char REPR = 'P';
	private int life = 0;
	private int max_life = 0;
	private int power = 0;
	private int max_power = 0;
	private int xp = 0;
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
	
	public void setRole(Classe s) {
		role = s;
		life += s.getS_hp();
		setMax_life(getMax_life() + s.getS_hp());
		power += s.getS_pw();
		max_power += s.getS_pw();
	}
	
	public void setGender(String g) {
		gender = g;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setRace(Race r) {
		race = r;
		life += r.getS_hp();
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
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
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
}
