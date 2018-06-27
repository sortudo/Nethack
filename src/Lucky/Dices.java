package Lucky;

public class Dices {
	private int n;
	private int faces;
	private int resultado;
	private int modifier;
	
	public Dices(int n, int f, int m) {
		this.n = n;
		faces = f;
		modifier = m;
	}
	
	public int Roll() {
		resultado = 0;
		for(int i = 0; i < n; i++)
			resultado += this.rolar();
		return resultado + modifier;
	}
	
	private int rolar() {
		Random rand = new Random();
		this.resultado = rand.getIntRand(faces);
		return this.resultado;
	}
}
