package PlayNet;
import java.io.IOException;

import Classe.Barbarian;
import Classe.Knight;
import Classe.Priest;
import Classe.Rogue;
import Race.Elf;
import Race.Human;
import Race.Orc;

public class Main {
	public static void main(String[] args) throws IOException {
		int classe, time = 0;
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
		System.out.println("What is your race?");
		System.out.println("1 - Human");
		System.out.println("2 - Elf");
		System.out.println("3 - Orc");
		classe = EntradaTeclado.leInt();
		while(loop) {
			if(classe == 1) {
				p.setRace(new Human());
				loop = false;
			}else if (classe == 2) {
				p.setRace(new Elf());
				loop = false;
			}else if (classe == 3) {
				p.setRace(new Orc());
				loop = false;
			}else {
				System.out.println("Number incorrect!");
				System.out.println("What is your race?");
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
		System.out.println("Hello " + p.getName() + ", Welcome to NetHack! You are a " + p.getGender() + " " + p.getRace() + " " + p.getClasse() + ".");
		g.Draw();
		System.out.println(p.getName() + " the "+ p.getClasse() + "\t\t\t"+ "St:" + p.getSt() + " Dx:" + p.getDx() + " Co:" + p.getCo() + " In:" + p.getIn() + " Wi:" + p.getWi() +" Ch:" + p.getCh());
		System.out.println("Level:" + p.getNivel() + "\t\t\t" +  "$:" + p.getGold() + " HP:" + p.getLife() + "(" + p.getMax_life() + ")" + " PW:" + p.getPower() + "(" + p.getMax_power() + ")" + " AC:" + p.getAC() + " Xp:"+ p.getXp() + " T:" + time);
		while(p.getLife() > 0) {
			p.action(g, EntradaTeclado.leString());
			time++;
			//clearScreen();
			System.out.println("-----------------------------------------------");
			g.Draw();
			System.out.println(p.getName() + " the "+ p.getClasse() + "\t\t\t"+ "St:" + p.getSt() + " Dx:" + p.getDx() + " Co:" + p.getCo() + " In:" + p.getIn() + " Wi:" + p.getWi() +" Ch:" + p.getCh());
			System.out.println("Level:" + p.getNivel() + "\t\t\t" +  "$:" + p.getGold() + " HP:" + p.getLife() + "(" + p.getMax_life() + ")" + " PW:" + p.getPower() + "(" + p.getMax_power() + ")" + " AC:" + p.getAC() + " Xp:"+ p.getXp() + " T:" + time);
		}
	}
}
