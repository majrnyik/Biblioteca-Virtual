package usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import biblioteca.*;
import comprovante.*;

public class Aluno extends Usuario {
	
	static int  qtdMax = 5; 												// quantidade máxima de livros que um aluno pode alugar
	static int prazoMax = 30;												// data máxima que um livro pode ser alugado por um aluno
	static LocalDate dataEmprestimo = LocalDate.now();						// calcula o dia de hoje
	static LocalDate dataPrevista = dataEmprestimo.plusDays(prazoMax);		// calcula a data de devolução baseado na data atual
	static LocalDate dataDevolucao = LocalDate.now();
	
	static Scanner scan = new Scanner(System.in);
	
	//construtor da classe aluno 
	public Aluno (String nome, String sobrenome, String email, int senha) {
		super (nome, sobrenome, email, senha);
		setHistorico(new ArrayList<Comprovante>());
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
}
