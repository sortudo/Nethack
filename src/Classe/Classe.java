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
	private int s_hp;
	private int s_pw;
	private Weapon wea;
	private Armadura arm;
	
	public Classe (String n, int s, int i, int w, int d, int co, int cha, int hp, int pw, Weapon we, Armadura ar) {
		name = n;
		Str = s;
		s_hp = hp;
		setS_pw(pw);
		setInt(i);
		setWis(w);
		setDex(d);
		setCon(co);
		setCha(cha);
		arm = ar;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStr() {
		return Str;
	}

	public int getInt() {
		return Int;
	}

	public void setInt(int i) {
		Int = i;
	}

	public int getWis() {
		return Wis;
	}

	public void setWis(int wis) {
		Wis = wis;
	}

	public int getDex() {
		return Dex;
	}

	public void setDex(int dex) {
		Dex = dex;
	}

	public int getCon() {
		return Con;
	}

	public void setCon(int con) {
		Con = con;
	}

	public int getCha() {
		return Cha;
	}

	public void setCha(int cha) {
		Cha = cha;
	}

	public int getS_hp() {
		return s_hp;
	}

	public void setS_hp(int s_hp) {
		this.s_hp = s_hp;
	}

	public int getS_pw() {
		return s_pw;
	}

	public void setS_pw(int s_pw) {
		this.s_pw = s_pw;
	}
	
	public int getAC() {
		return arm.getAC();
	}
}
