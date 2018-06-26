package Classe;
import java.util.ArrayList;

import Itens.Armadura;
import Itens.Weapon;

public abstract class Classe {
	private String name;
	private int Str;
	private int Int;
	private int Wis;
	private int Dex;
	private int Con;
	private int Cha;
	private Weapon wea;
	private Armadura arm;
	
	public Classe (String n, int s, int i, int w, int d, int co, int cha, Weapon we, Armadura ar) {
		name = n;
		Str = s;
		Int = i;
		Wis = w;
		Dex = d;
		Con = co;
		Cha = cha;
		arm = ar;
	}
}
