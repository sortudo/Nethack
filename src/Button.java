
public class Button extends GameObject {

	public Button(int linhaInicial, int colunaInicial) {
		super('o', linhaInicial, colunaInicial);
	}
	
	public void onInteract() {
		System.out.println("apertou, miserávi");
	}

}
