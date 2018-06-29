package Race;

import Lucky.Dices;

/**
 * class Race: Representa todas as racas presentes no jogo
 * @author braga
 *
 */
public abstract class Race {
	private String name;
	private int mStr;
	private int mInt;
	private int mWis;
	private int mDex;
	private int mCon;
	private int mCha;
	private int s_hp;
	private int s_pw;
	private Dices l_l;
	private int h_l;
	
	public Race(String n, int s, int i, int w, int d, int co, int ch, int hp, int pw, Dices l, int h) {
		name = n;
		mStr = s;
		mInt = i;
		mWis = w;
		mDex = d;
		mCon = co;
		mCha = ch;
		setL_l(l);
		setH_l(h);
		setS_hp(hp);
		setS_pw(pw);
	}
	
	public String getName() {
		return name;
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

	public Dices getL_l() {
		return l_l;
	}

	public void setL_l(Dices l_l) {
		this.l_l = l_l;
	}

	public int getH_l() {
		return h_l;
	}

	public void setH_l(int h_l) {
		this.h_l = h_l;
	}
}
