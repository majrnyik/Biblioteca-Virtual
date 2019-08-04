package biblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import livros.Livro;
import usuario.Aluno;
import usuario.Bibliotecario;
import usuario.Professor;

public class Biblioteca {

	private static Biblioteca instance;

	public static final Scanner scan = new Scanner(System.in);
	protected static List <Livro> acervo;
	private static List <Aluno> usuarioAluno;
	private static List <Professor> usuarioProf;
	private static List <Bibliotecario> usuarioTA;

	// construtor privado da classe biblioteca
	private Biblioteca () {
		Biblioteca.setAcervo(new ArrayList <Livro>());
		this.setUsuarioAluno(new ArrayList <Aluno>());
		this.setUsuarioProf(new ArrayList <Professor>());
		this.setUsuarioTA(new ArrayList <Bibliotecario>());
	}

	// construtor p�blico de uma classe Biblioteca, de acordo com o padr�o Singleton
	public static Biblioteca getInstance()
	{
		if (Biblioteca.instance == null) {
			Biblioteca.instance = new Biblioteca();
		}

		return Biblioteca.instance;
	}

	// metodo auxiliar para realizar um empr�stimo
	public static void emprestimo (final String title) {
		for (int i = 0; i < Biblioteca.acervo.size(); i++) {
			if (Biblioteca.acervo.get(i).getTitulo().equals(title) && Biblioteca.acervo.get(i).getStatus() == 0) {
				Biblioteca.acervo.get(i).setStatus(1);
				return;
			}
		}
		throw new ArrayIndexOutOfBoundsException ("Livro n�o dispon�vel.");
	}

	// metodo auxiliar para realizar uma devolu��o
	public static void devolucao (final String title) {
		for (int i = 0; i < Biblioteca.acervo.size(); i++) {
			if (Biblioteca.acervo.get(i).getTitulo().equals(title)) {
				Biblioteca.acervo.get(i).setStatus(0);
			}
		}
	}

	//busca por um livro no acervo
	public Livro buscaLivro (final String title) {
		for (int i = 0; i < Biblioteca.acervo.size(); i++) {
			if (Biblioteca.acervo.get(i).getTitulo().equals(title)) {
				return Biblioteca.acervo.get(i);
			}
		}
		throw new ArrayIndexOutOfBoundsException ("Livro n�o encontrado.");
	}

	// m�todo para verificar o status de um livro
	// devolve true se livro estiver disponivel e false se estiver alugado
	public boolean buscaStatusLivro (final String title) {
		for (int i = 0; i < this.getAcervo().size(); i++) {
			if (Biblioteca.acervo.get(i).getTitulo().equals(title) && Biblioteca.acervo.get(i).getStatus() == 0) {
				return true;
			}
		}
		return false;
	}

	// m�todo para buscar aluno
	public Aluno buscaAluno (final int iD, final int senha) {
		for (int i = 0; i < Biblioteca.getUsuarioAluno().size(); i++) {
			if (Biblioteca.usuarioAluno.get(i).getiD() == iD && Biblioteca.usuarioAluno.get(i).getSenha() == senha) {
				return Biblioteca.usuarioAluno.get(i);
			}
		}
		throw new ArrayIndexOutOfBoundsException ("Usu�rio n�o encontrado.");
	}

	// m�todo para buscar professor
	public Professor buscaProfessor (final int iD, final int senha) {
		for (int i = 0; i < Biblioteca.getUsuarioProf().size(); i++) {
			if (Biblioteca.usuarioProf.get(i).getiD() == iD
					&& Biblioteca.usuarioProf.get(i).getSenha() == senha ) {
				return Biblioteca.usuarioProf.get(i);
			}
		}
		throw new ArrayIndexOutOfBoundsException ("Usu�rio n�o encontrado.");
	}

	// m�todo para buscar um bibliotec�rio
	public Bibliotecario buscaTA (final int iD, final int senha) {
		for (int i = 0; i < Biblioteca.getUsuarioTA().size(); i++) {
			if (Biblioteca.usuarioTA.get(i).getiD() == iD
					&& Biblioteca.usuarioTA.get(i).getSenha() == senha ) {
				return Biblioteca.usuarioTA.get(i);
			}
		}
		throw new ArrayIndexOutOfBoundsException ("Usu�rio n�o encontrado.");
	}

	public static boolean verificaAluno (final int iD, final int senha) {
		for (int i = 0; i < Biblioteca.getUsuarioAluno().size(); i++) {
			if (Biblioteca.usuarioAluno.get(i).getiD() == iD && Biblioteca.usuarioAluno.get(i).getSenha() == senha) {
				return true;
			}
		}
		return false;
	}

	public static boolean verificaProf (final int iD, final int senha) {
		for (int i = 0; i < Biblioteca.getUsuarioProf().size(); i++) {
			if (Biblioteca.usuarioProf.get(i).getiD() == iD
					&& Biblioteca.usuarioProf.get(i).getSenha() == senha ) {
				return true;
			}
		}
		return false;
	}

	// m�todo para cadastrar livro
	public static void cadastraLivro () {
		System.out.println("Digite o t�tulo, assunto, autores e ano do livro.");
		String titulo = Biblioteca.scan.nextLine();
		String assunto = Biblioteca.scan.nextLine();
		String autor = Biblioteca.scan.nextLine();
		int ano = Biblioteca.scan.nextInt();
		Livro l = new Livro(titulo, assunto, autor, ano);
		Biblioteca.acervo.add(l);
		System.out.println("Livro cadastrado com sucesso!");
	}

	//m�todo para remover um livro
	public static void removeLivro (final String title) {
		for (int i = 0; i < Biblioteca.acervo.size(); i++) {
			if (Biblioteca.acervo.get(i).getTitulo().equals(title)) {
				Biblioteca.acervo.remove(i);
			}
		}
	}

	//metodo para o aluno fazer cadastro
	public void cadastroAluno () {
		System.out.println("Digite o nome, sobrenome, iD e nova senha.");
		String nome = Biblioteca.scan.nextLine();
		String sobrenome = Biblioteca.scan.nextLine();
		int iD = Biblioteca.scan.nextInt();
		Biblioteca.scan.nextLine();
		int senha = Biblioteca.scan.nextInt();
		Aluno a = new Aluno(nome, sobrenome, iD, senha);
		Biblioteca.usuarioAluno.add(a);
		System.out.println("Cadastro realizado com sucesso!");
	}

	// metodo para cadastrar um professor
	public void cadastroProfessor () {
		System.out.println("Digite o nome, sobrenome, iD e nova senha.");
		String nome = Biblioteca.scan.nextLine();
		String sobrenome = Biblioteca.scan.nextLine();
		int iD = Biblioteca.scan.nextInt();
		int senha = Biblioteca.scan.nextInt();
		Professor p = new Professor(nome, sobrenome, iD, senha);
		Biblioteca.usuarioProf.add(p);
		System.out.println("Cadastro realizado com sucesso!");
	}

	// metodo para cadastrar um professor
	public void cadastroTA () {
		System.out.println("Digite o nome, sobrenome, iD e nova senha.");
		String nome = Biblioteca.scan.nextLine();
		String sobrenome = Biblioteca.scan.nextLine();
		int iD = Biblioteca.scan.nextInt();
		int senha = Biblioteca.scan.nextInt();
		Bibliotecario b = new Bibliotecario(nome, sobrenome, iD, senha);
		Biblioteca.usuarioTA.add(b);
		System.out.println("Cadastro realizado com sucesso!");
	}

	/*------------------------- getters e setters -----------------------------*/

	public static List<Aluno> getUsuarioAluno() {
		return Biblioteca.usuarioAluno;
	}

	public void setUsuarioAluno(final List<Aluno> usuarioAluno) {
		Biblioteca.usuarioAluno = usuarioAluno;
	}

	public static List<Professor> getUsuarioProf() {
		return Biblioteca.usuarioProf;
	}

	public void setUsuarioProf(final List<Professor> usuarioProf) {
		Biblioteca.usuarioProf = usuarioProf;
	}

	public static List<Bibliotecario> getUsuarioTA() {
		return Biblioteca.usuarioTA;
	}

	public void setUsuarioTA(final List<Bibliotecario> usuarioTA) {
		Biblioteca.usuarioTA = usuarioTA;
	}

	public List<Livro> getAcervo() {
		return Biblioteca.acervo;
	}

	public static void setAcervo(final List<Livro> acervo) {
		Biblioteca.acervo = acervo;
	}
}