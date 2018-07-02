package PlayNet;
import java.io.IOException;

import Itens.Apple;
import Itens.Arrow;
import Itens.FoodRation;
import Itens.Gold;
import Itens.LongSword;
import Itens.PotionAbility;
import Itens.PotionExtraHealing;
import Itens.PotionHealing;
import Itens.PotionInvisibility;
import Itens.PotionSleeping;
import Itens.RingMail;
import Lucky.Dices;
import Monster.Jackal;
import Race.Dwarf;
import Race.Elf;
import Race.Gnome;
import Race.Human;
import Race.Orc;
import Role.Barbarian;
import Role.Healer;
import Role.Knight;
import Role.Priest;
import Role.Ranger;
import Role.Rogue;
import Role.Wizard;

/**
 * class Main: Aqui eh onde o jogo eh colocado em pratica
 * @author braga
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		int classe, time = 0;
		boolean loop = true;
		Game g = new Game(8,8);
		Player p = new Player(4,4);
		g.put(p);
		g.put(new Jackal(2,3));
		/**
		 * O jogo comeca com o jogador criando o seu personagem
		 * Escolhendo nome, classe, raça e sexo
		 */
		System.out.println("Who are You?");
		p.setName(EntradaTeclado.leString());
		System.out.println("What is your class?");
		System.out.println("1 - Barbarian");
		System.out.println("2 - Priest");
		System.out.println("3 - Knight");
		System.out.println("4 - Rogue");
		System.out.println("5 - Healer");
		System.out.println("6 - Ranger");
		System.out.println("7 - Wizard");
		classe = EntradaTeclado.leInt();
		while(loop) {
			if(classe == 1) {
				p.setRole(new Barbarian());
				p.addInventory(new FoodRation());
				p.addInventory(new FoodRation());
				loop = false;
			}else if (classe == 2) {
				p.setRole(new Priest());
				loop = false;
			}else if (classe == 3) {
				p.setRole(new Knight());
				p.addInventory(new Apple(new Dices(1,11,9).Roll()));
				loop = false;
			}else if (classe == 4) {
				p.setRole(new Rogue());
				p.addInventory(new PotionInvisibility());
				loop = false;
			}else if(classe == 5){
				p.setRole(new Healer());
				p.setGold(new Dices(1,1000, 1000).Roll());
				p.addInventory(new Apple(new Dices(1,5,5).Roll()));
				p.addInventory(new PotionHealing(4));
				p.addInventory(new PotionExtraHealing(4));
				loop = false;
			}else if(classe == 6){
				p.setRole(new Ranger());
				p.addInventory(new FoodRation());
				p.addInventory(new FoodRation());
				p.addInventory(new Arrow(new Dices(1,100, 80).Roll()));
				loop = false;
			}else if(classe == 7){
				p.addInventory(new PotionAbility());
				p.addInventory(new PotionSleeping(1));
				p.addInventory(new PotionHealing(1));
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
		System.out.println("4 - Dwarf");
		System.out.println("5 - Gnome");
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
			}else if (classe == 4) {
				p.setRace(new Dwarf());
				loop = false;
			}else if (classe == 5) {
				p.setRace(new Gnome());
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
		/**
		 * Apartir daqui o jogo comeca com o player criado, dentro de uma sala
		 */
		// Da boas-vindas ao player
		System.out.println("Hello " + p.getName() + ", Welcome to NetHack! You are a " + p.getGender() + " " + p.getRacename() + " " + p.getClasse() + ".");
		p.Alive();
		g.Draw();
		// Linha de Status do personagem
		System.out.println(p.getName() + " the "+ p.getClasse() + "\t\t\t"+ "St:" + p.getSt() + " Dx:" + p.getDx() + " Co:" + p.getCo() + " In:" + p.getIn() + " Wi:" + p.getWi() +" Ch:" + p.getCh());
		System.out.println("Level:" + p.getNivel() + "\t\t\t" +  "$:" + p.getGold() + " HP:" + p.getLife() + "(" + p.getMax_life() + ")" + " PW:" + p.getPower() + "(" + p.getMax_power() + ")" + " AC:" + p.getAC() + " Xp:"+ p.getXp() + " T:" + time);
		while(p.getLife() > 0) { // Enquanto o player estiver vivo o jogo continua
			System.out.println("-----------------------------------------------");
			p.action(g, EntradaTeclado.leString()); // Ve qual acao o player quer tomar
			time++;
			//clearScreen()
			p.Alive();
			g.Draw();
			System.out.println(p.getName() + " the "+ p.getClasse() + "\t\t\t"+ "St:" + p.getSt() + " Dx:" + p.getDx() + " Co:" + p.getCo() + " In:" + p.getIn() + " Wi:" + p.getWi() +" Ch:" + p.getCh() + " " + p.getState_cap());
			System.out.println("Level:" + p.getNivel() + "\t\t\t" +  "$:" + p.getGold() + " HP:" + p.getLife() + "(" + p.getMax_life() + ")" + " PW:" + p.getPower() + "(" + p.getMax_power() + ")" + " AC:" + p.getAC() + " Xp:"+ p.getXp() + " T:" + time + " " + p.getNu_state());
		}
		p.setScore(p.getScore() + p.getGold());
		// Score tbm depende do nivel da dungeon
		
		System.out.println("Here lies...");	
		System.out.println("Goodbye " + p.getName() + " the " + p.getRole().getName() + "...");
		System.out.println("You died in The Dungeons of Doom on dungeon level XXX with " + p.getScore() + " points,");
		System.out.println("and " + p.getGold() + " pieces of gold, after " + time + " moves.");
		System.out.println("You were level " + p.getLevel() + " with a maximun of " + p.getMax_life() + " hit points when you died.");
		System.out.println("R.I.P.");
	}
}
