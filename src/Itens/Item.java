package Itens;

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
		weight = w;
	}
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
