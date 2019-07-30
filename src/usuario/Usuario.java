package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import biblioteca.*;
import comprovante.*;

	public abstract class Usuario {
	private static List <Comprovante> historico;							// histórico de empéstimos do usuário
	private String Nome; 													// nome do usuario
	private String Sobrenome; 												// sobrenome do usuario
	private String Email;													// e-mail do usuario
	private static int iD;													// número de identificação do usuário
	private static int senha;												// senha do usuário
	private static int iDUniversal = 0; 									// variável auxiliar para criação de um iD
	static int  qtdMax; 													// quantidade máxima de livros para locação por usuário
	static int prazoMax;													// data máxima que um livro pode ser alugado
	static LocalDate dataEmprestimo = LocalDate.now();						// calcula o dia de hoje
	static LocalDate dataPrevista = dataEmprestimo.plusDays(prazoMax);		// calcula a data de devolução baseado na data atual
	static LocalDate dataDevolucao = LocalDate.now();
	
	//construtor da classe abstrata usuario
	public Usuario (String Nome, String Sobrenome, String Email, int senha) {
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.Email = Email;
		setiD(iDUniversal++);
		setSenha(senha);
		setHistorico(new ArrayList<Comprovante>());
	}
	
	// método para realizar empréstimo
	public static void realizaEmprestimo (String titulo) {
		// se o limite de livros ainda não for atigido
		if (qtdMax > 0) {	
			// se o livro estiver disponivel				
			if( Biblioteca.buscaStatusLivro(titulo)) {   
			Biblioteca.Emprestimo(titulo);
			// cria comprovante de empréstimo e coloca no histórico do usuário
			ComprovanteEmprestimo c = new ComprovanteEmprestimo (titulo, dataEmprestimo, dataPrevista);
			historico.add(c);
			System.out.print(c);
			// diminui em 1 a quantidade possíveis futuros empréstimos
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
	
		// resgata datas de empréstimo e previsão de devolução
		LocalDate emprest = null, previsao =  null;
		for (int i = 0; i < historico.size(); i++) {
			if (Comprovante.getTitulo().equals(titulo))	{
				emprest = Comprovante.getDataEmprestimo();
				previsao = Comprovante.getDataPrevista();
			}
		}
		// cria comprovante de devolução
		ComprovanteDevolucao c = new ComprovanteDevolucao(titulo, emprest, previsao);
		System.out.print(c);
		
		// se a data de devolução for após a data prevista:
		if (dataDevolucao.isAfter(previsao)) {
				System.out.print("Atenção! Devolução atrasada, você está bloqueado por 7 dias.");	
		}
	}
	
	/* -------- funções getters e setters -------- */
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String newNome) {
		this.Nome = newNome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String newSobrenome) {
		this.Sobrenome = newSobrenome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String newEmail) {
		this.Email = newEmail;
	}
	public static int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		Usuario.iD = iD;
	}
	public static int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		Usuario.senha = senha;
	}
	public static List<Comprovante> getHistorico() {
		return historico;
	}
	public static void setHistorico(List<Comprovante> historico) {
		Usuario.historico = historico;
	}
}
