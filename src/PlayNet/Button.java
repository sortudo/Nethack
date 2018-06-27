package PlayNet;

public class Button extends GameObject {

	public Button(int linhaInicial, int colunaInicial) {
		super('o', linhaInicial, colunaInicial);
	}
	
	@Override
	public void onInteract() {
		System.out.println("apertou, miserávi");
	}

}
