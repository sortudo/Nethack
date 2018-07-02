package Itens;

import PlayNet.Game;
import PlayNet.GameObject;
import PlayNet.Player;

/**
 * class Itens: Representacao de todos os itens presentes nesse jogo
 * @author braga
 *
 */
public abstract class Item extends GameObject{
	private String nome;
	private String descricao;
	private int weight;
	
	public Item(String n, String des, int w, char r,int l, int c) {
		super(r, l, c);
		setNome(n);
		setDescricao(des);
		setWeight(w);
	}
	
	/**
	 * Quando o player anda para a mesma posicao que um item
	 * ele armazena no inventario, porem tem excessoes
	 */
	@Override
	public void onInteract(Player p) {
		p.addInventory(this);
		System.out.println("You pick a " + this.getNome() + "!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void use(Player p, int index) {
		
	}

	public void use(Player p) {
		// TODO Auto-generated method stub
	}
	
	public void use(Player p, int index, Game g) {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
