package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
	public Professor (final String nome, final String sobrenome, final int iD, final int senha) {
		super (nome, sobrenome, iD, senha);
		this.setHistorico(new ArrayList<Comprovante>());
	}

	public Professor () {

	}
}

