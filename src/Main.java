import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Game g = new Game(8,8);
		Player p = new Player(4,4);
		g.put(p);
		g.put(new Button(2, 3));
		g.Draw();
		System.out.println("Who are You?");
		p.setName(EntradaTeclado.leString());
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
