package usuario;
import java.util.Scanner;
import biblioteca.*;
import livros.Livro;

public class Bibliotecario extends Usuario {
	
	static Scanner scan = new Scanner(System.in);

	//construtor da classe bibliotecario
	public Bibliotecario (String nome, String sobrenome, String email, int senha) {
		super (nome, sobrenome, email, senha);
	}
	
	// método para cadastrar livro
	public static void cadastraLivro () {
		System.out.println("Digite o título, assunto, autores e ano do livro.");
		String titulo = scan.nextLine();
		String assunto = scan.nextLine();
		String autor = scan.nextLine();
		int ano = scan.nextInt();
		Livro l = new Livro(titulo, assunto, autor, ano);
		Biblioteca.getAcervo().add(l);
	}
	
	//método para remover um livro
	public static void removeLivro (String title) {
		for (int i = 0; i < Biblioteca.getAcervo().size(); i++) 
			if (Livro.titulo.equals(title))	
				Biblioteca.getAcervo().remove(i);
	}
			
}
