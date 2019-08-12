package usuario;
import java.util.Scanner;

import biblioteca.Biblioteca;

public class Bibliotecario extends Usuario {

	static Scanner scan = new Scanner(System.in);

	//construtor da classe bibliotecario
	public Bibliotecario (final String nome, final String sobrenome, final int iD, final int senha) {
		super (nome, sobrenome, iD, senha);
	}

	public Bibliotecario () {

	}

	// método para cadastrar livro
	public void cadastraLivro (final String titulo, final String assunto, final String autor, final int ano) {
		Biblioteca.cadastraLivro(titulo, assunto, autor, ano);
	}

	//método para remover um livro
	public void removeLivro (final String title) {
		Biblioteca.removeLivro(title);
	}
}
