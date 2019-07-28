package usuario;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;

public class Professor extends Usuario {
	
	private static List <String> historico;	// histórico de locações
	static int qtdMax = 10;			// quantidade máxima de livros que um professor pode alugar
	static int prazoMax = 90;		// data máxima que um livro pode ser alugado por um professor
	
	//construtor da classe professor
	public Professor (String nome, String sobrenome, String email, int senha) {
		super (nome, sobrenome, email, senha);
		setHistorico(new ArrayList<String>());
	}
	
	//metodo para realizar emprestimos
	public static void realizaEmprestimo (String titulo) {
		// se o limite de livros ainda n for atigido	
		if (qtdMax > 0) {
			// se o livro estiver disponivel					
			if( Biblioteca.buscaStatusLivro(titulo)) { 
			Biblioteca.Emprestimo(titulo);
			historico.add(titulo);
			System.out.println("Empréstimo realizado com sucesso!");
			qtdMax--;
		}
		else
			System.out.println("Livro já está alugado. Impossível realizar empréstimo.");
		}
		else 
			System.out.println("Você atingiu o limite para a locação de livros.\n"
					  + "Devolva um livro e tente novamente");
	}
	
	// metodo para realizar a devolucao
	public static void realizaDevolucao (String titulo) {
		Biblioteca.Devolucao(titulo);
	}
	
	public static void setHistorico(List<String> historico) {
		Professor.historico = historico;
	}
	
	public static List<String> getHistorico() {
		return historico;
	}
}
