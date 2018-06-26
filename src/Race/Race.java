package Race;

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
	
	public Race(String n, int s, int i, int w, int d, int co, int ch, int hp, int pw) {
		name = n;
		mStr = s;
		mInt = i;
		mWis = w;
		mDex = d;
		mCon = co;
		mCha = ch;
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
}
