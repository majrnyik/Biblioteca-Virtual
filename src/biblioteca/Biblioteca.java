package biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import livros.*;
import usuario.*;

public class Biblioteca {
	static Scanner scan = new Scanner(System.in);
	public static List <Livro> acervo;
	private static List <Aluno> usuarioAluno;
	private static List <Professor> usuarioProf;
 	
	// construtor da classe biblioteca
	public Biblioteca () {
		new ArrayList<Livro>();
		new ArrayList <Aluno>();
		new ArrayList <Professor>();
	}
	
	// metodo auxiliar para realizar um empréstimo
	public static void Emprestimo (String title) {
		for (int i = 0; i < acervo.size(); i++) {
			if (Livro.getTitulo().equals(title))	
				Livro.status = 1;
		}
	}
	
	// metodo auxiliar para realizar uma devolução 
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
	
	/*------------------------- getters e setters -----------------------------*/
	
	public static List<Livro> getAcervo() {
		return acervo;
	}

	public static void setAcervo(List<Livro> acervo) {
		Biblioteca.acervo = acervo;
	}

	public static List<Aluno> getUsuarioAluno() {
		return usuarioAluno;
	}

	public static void setUsuarioAluno(List<Aluno> usuarioAluno) {
		Biblioteca.usuarioAluno = usuarioAluno;
	}

	public static List<Professor> getUsuarioProf() {
		return usuarioProf;
	}

	public static void setUsuarioProf(List<Professor> usuarioProf) {
		Biblioteca.usuarioProf = usuarioProf;
	}
}
