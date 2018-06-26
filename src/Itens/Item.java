package Itens;


public abstract class Item {
	private String nome;
	private String descricao;
	
	public Item(String n, String des) {
		nome = n;
		descricao = des;
	}
}
