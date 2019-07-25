package Livros;

public abstract class Livro {
	
	//atributos de um livro
	String titulo, assunto;
	String [] autores, nChamada; //nChamada já indica localizacao
	int ano;
	
	//construtor da classe abstrata Livro
	public Livro (String titulo, String assunto, String [] autores, String [] nChamada, int ano) {
		this.titulo = titulo;
		this.assunto = assunto;
		this.autores = autores;
		this.nChamada = nChamada;
		this.ano = ano;
	}
}
