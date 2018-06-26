package Race;

public abstract class Race {
	private String name;
	private int mStr;
	private int mInt;
	private int mWis;
	private int mDex;
	private int mCon;
	private int mCha;
	
	public Race(String n, int s, int i, int w, int d, int co, int ch) {
		name = n;
		mStr = s;
		mInt = i;
		mWis = w;
		mDex = d;
		mCon = co;
		mCha = ch;
	}
	
	public String getName() {
		return name;
	}
}
