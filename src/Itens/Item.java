package Itens;

import PlayNet.GameObject;

/**
 * class Itens: Representacao de todos os itens presentes nesse jogo
 * @author braga
 *
 */
public abstract class Item {
	private String nome;
	private String descricao;
	
	public Item(String n, String des) {
		nome = n;
		descricao = des;
	}
}
