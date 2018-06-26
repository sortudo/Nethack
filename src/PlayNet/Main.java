package PlayNet;
import java.io.IOException;

import Classe.Barbarian;
import Classe.Knight;
import Classe.Priest;
import Classe.Rogue;

public class Main {
	public static void main(String[] args) throws IOException {
		int classe;
		boolean loop = true;
		Game g = new Game(8,8);
		Player p = new Player(4,4);
		g.put(p);
		g.put(new Button(2, 3));
		//g.Draw();
		System.out.println("Who are You?");
		p.setName(EntradaTeclado.leString());
		System.out.println("What is your classe?");
		System.out.println("1 - Barbarian");
		System.out.println("2 - Priest");
		System.out.println("3 - Knight");
		System.out.println("4 - Rogue");
		classe = EntradaTeclado.leInt();
		while(loop) {
			if(classe == 1) {
				p.setRole(new Barbarian());
				loop = false;
			}else if (classe == 2) {
				p.setRole(new Priest());
				loop = false;
			}else if (classe == 3) {
				p.setRole(new Knight());
				loop = false;
			}else if (classe == 4) {
				p.setRole(new Rogue());
				loop = false;
			}else {
				System.out.println("Number incorrect!");
				System.out.println("What is your classe?");
				classe = EntradaTeclado.leInt();
			}
		}
		loop = true;
		System.out.println("What is your gender?");
		System.out.println("1 - Male");
		System.out.println("2 - Female");
		System.out.println("3 - Agender");
		classe = EntradaTeclado.leInt();
		while(loop) {
			if(classe == 1) {
				p.setGender("Male");
				loop = false;
			}else if (classe == 2) {
				p.setGender("Female");
				loop = false;
			}else if (classe == 3) {
				p.setGender("Agender");
				loop = false;
			}else {
				System.out.println("Number incorrect!");
				System.out.println("What is your gender?");
				classe = EntradaTeclado.leInt();
			}
		}
		g.Draw();
		while(p.getLife() > 0) {
			p.action(g, EntradaTeclado.leString());
			//clearScreen();
			System.out.println("-----------------------------------------------");
			g.Draw(); 
		}
	}

	public static void clearScreen() {
		try {
			String osName = System.getProperty("os.name");
			System.out.println(osName);
			if (osName.contains("Windows")) {
				Runtime.getRuntime().exec("cmd /c cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
