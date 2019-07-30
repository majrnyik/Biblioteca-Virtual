package biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import livros.*;
import usuario.*;

public class Biblioteca {
	static Scanner scan = new Scanner(System.in);
	private static List <Livro> acervo;
	private static List <Aluno> usuarioAluno;
	private static List <Professor> usuarioProf;
 	
	// construtor da classe biblioteca
	public Biblioteca () {
		new ArrayList<Livro>();
		new ArrayList <Aluno>();
		new ArrayList <Professor>();
	}
	
	// metodo para realizar um empréstimo
	public static void Emprestimo (String title) {
		for (int i = 0; i < acervo.size(); i++) {
			if (Livro.getTitulo().equals(title))	
				Livro.status = 1;
		}
	}
	
	// metodo para realizar uma devolução 
	public static void Devolucao (String title) {
		for (int i = 0; i < acervo.size(); i++) {
			if (Livro.getTitulo().equals(title))	
				Livro.status = 0;
		}
	}
	
	// busca por um livro no acervo e o imprime
	public static void buscaLivro (String title) {		
		for (int i = 0; i < acervo.size(); i++) {
			if (Livro.getTitulo().equals(title))	
				System.out.println(acervo.get(i));
		}		
	}
	
	// método para verificar o status de um livro
	// devolve true se livro estiver disponivel e false se estiver alugado
	public static boolean buscaStatusLivro (String title) {
		for (int i = 0; i < acervo.size(); i++) {
			if (Livro.titulo.equals(title))	
				if (Livro.status == 0)
					return true;
		}
		return false;
	}
	
	// método para cadastrar livro
	public static void cadastraLivro () {
			System.out.println("Digite o título, assunto, autores e ano do livro.");
			String titulo = scan.nextLine();
			String assunto = scan.nextLine();
			String autor = scan.nextLine();
			int ano = scan.nextInt();
			Livro l = new Livro(titulo, assunto, autor, ano);
			acervo.add(l);
	}
	
	// método para remover um livro do acervo
	public static void removeLivro (String title) {
		for (int i = 0; i < acervo.size(); i++) 
			if (Livro.titulo.equals(title))	
				acervo.remove(i);
	}
	
	// método para buscar histórico de aluno
	public static void buscaHistoricoAluno (int iD, int senha) {
		for (int i = 0; i < usuarioAluno.size(); i++) {
			if (Aluno.getiD() == iD && Aluno.getSenha() == senha)	
				System.out.println(Aluno.getHistorico());
		}
	}
	
	// método para buscar histórico de professor
	public static void buscaHistoricoProf (int iD, int senha) {
		for (int i = 0; i < usuarioProf.size(); i++) {
			if (Professor.getiD() == iD && Professor.getSenha() == senha)	
				System.out.println(Aluno.getHistorico());
		}
	}
	
	public static void cadastraAluno () {
		System.out.println("Digite o nome, sobrenome, email e nova senha.");
		String nome = scan.nextLine();
		String sobrenome = scan.nextLine();
		String email = scan.nextLine();
		int senha = scan.nextInt();
		Aluno a = new Aluno(nome, sobrenome, email, senha);
		usuarioAluno.add(a);
	}
	
	public static void cadastraProfessor () {
		System.out.println("Digite o nome, sobrenome, email e nova senha.");
		String nome = scan.nextLine();
		String sobrenome = scan.nextLine();
		String email = scan.nextLine();
		int senha = scan.nextInt();
		Professor p = new Professor(nome, sobrenome, email, senha);
		usuarioProf.add(p);
	}
}
