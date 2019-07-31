package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.Biblioteca;
import comprovante.Comprovante;

public class Professor extends Usuario {
	// histórico de locações
	static int qtdMax = 10;													// quantidade máxima de livros que um professor pode alugar
	static int prazoMax = 90;												// data máxima que um livro pode ser alugado por um professor
	static LocalDate dataEmprestimo = LocalDate.now();						// calcula o dia de hoje
	static LocalDate dataPrevista = Professor.dataEmprestimo.plusDays(Professor.prazoMax);		// calcula o prazo de devolução
	static LocalDate dataDevolucao = LocalDate.now();						// calcula a data de devolução baseado na data atual

	public static Scanner scan = new Scanner(System.in);

	//construtor da classe professor
	public Professor (final String nome, final String sobrenome, final int senha) {
		super (nome, sobrenome, senha);
		this.setHistorico(new ArrayList<Comprovante>());
	}

	public Professor () {

	}

	// metodo para cadastrar um professor
	public void cadastraProfessor () {
		System.out.println("Digite o nome, sobrenome, email e nova senha.");
		String nome = Professor.scan.nextLine();
		String sobrenome = Professor.scan.nextLine();
		int senha = Professor.scan.nextInt();
		Professor p = new Professor(nome, sobrenome, senha);
		Biblioteca.getUsuarioProf().add(p);
	}
}

