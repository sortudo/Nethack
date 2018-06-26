package PlayNet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.*;

import Classe.Classe;
import Itens.Item;
public class Player extends GameObject {
	private String name;
	private Classe role;
	private String race;
	private String gender;
	private ArrayList<Item> Inventory;
	public static final char REPR = 'P';
	private static int life = 10;
	private HashMap<String, Consumer<Game>> comandos = new HashMap<>();
	//private HashMap<>
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
	}
	
	public void setGender(String g) {
		gender = g;
	}
	
	public String getGender() {
		return gender;
	}
}
