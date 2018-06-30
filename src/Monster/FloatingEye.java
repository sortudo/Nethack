package Monster;

import Lucky.Dices;

public class FloatingEye extends Monster{

	public FloatingEye(int l, int c) {
		super("Floating Eye", new Dices(1,0,0), 2, 9, l, c);
		// TODO Auto-generated constructor stub
	}

	// PARALISA O PLAYER
	// QUando recebe um ataque e nao morre
	// Every time you attack a floating eye with a melee attack,
	// there is a 2/3 chance that it will use its gaze attack against you if your attack did not kill it.
	// You are paralysed for (LEV + 1)d70 turns if your wisdom is greater than 12.
}
