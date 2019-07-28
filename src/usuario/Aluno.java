package usuario;
import java.util.ArrayList;
import java.util.List;
import biblioteca.*;

public class Aluno extends Usuario {
	
	private static List <String> historico;	// histórico de locações
	static int  qtdMax = 5; 		// quantidade máxima de livros que um aluno pode alugar
	static int prazoMax = 30;		// data máxima que um livro pode ser alugado por um aluno
	
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
			System.out.println("Você atingiu o limite para a locação de livros.\n"
					   + "Devolva um livro e tente novamente");
	}
	
	// método para realizar a devolução 
	public static void realizaDevolucao (String titulo) {
		Biblioteca.Devolucao(titulo);
	}
	
	public static void setHistorico(List<String> historico) {
		Aluno.historico = historico;
	}
	
	public static List<String> getHistorico() {
		return historico;
	}
}
