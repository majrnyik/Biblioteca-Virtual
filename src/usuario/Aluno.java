package usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import biblioteca.*;

public class Aluno extends Usuario {
	
	private static List <String> historico;	// histórico de locações
	static int  qtdMax = 5; 				// quantidade máxima de livros que um aluno pode alugar
	static int prazoMax = 30;				// data máxima que um livro pode ser alugado por um aluno
	static Scanner scan = new Scanner(System.in);
	
	//construtor da classe aluno 
	public Aluno (String nome, String sobrenome, String email, int senha) {
		super (nome, sobrenome, email, senha);
		setHistorico(new ArrayList<String>());
	}
	
	//metodo para realizar emprestimo
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
			System.out.println("Você atingiu o limite para a locação de livros. "
					+ "Devolva um livro e tente novamente");
	}
	
	// método para realizar a devolução 
	public static void realizaDevolucao (String titulo) {
		Biblioteca.Devolucao(titulo);
	}
	
	//metodo para o aluno fazer cadastro
	public static void cadastraAluno () {
		System.out.println("Digite o nome, sobrenome, email e nova senha.");
		String nome = scan.nextLine();
		String sobrenome = scan.nextLine();
		String email = scan.nextLine();
		int senha = scan.nextInt();
		Aluno a = new Aluno(nome, sobrenome, email, senha);
		Biblioteca.getUsuarioAluno().add(a);
	}
	
	// método para buscar histórico de aluno
		public static void buscaHistoricoAluno (int iD, int senha) {
			for (int i = 0; i < Biblioteca.getUsuarioAluno().size(); i++) {
				if (Aluno.getiD() == iD && Aluno.getSenha() == senha)	
					System.out.println(Aluno.getHistorico());
			}
		}
	
	
	
	
	public static void setHistorico(List<String> historico) {
		Aluno.historico = historico;
	}
	
	public static List<String> getHistorico() {
		return historico;
	}

}
