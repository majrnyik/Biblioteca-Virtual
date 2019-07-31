package usuario;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.Biblioteca;
import comprovante.Comprovante;

public class Aluno extends Usuario {
	static Scanner scan = new Scanner(System.in);

	//construtor da classe aluno
	public Aluno (final String nome, final String sobrenome, final int senha) {
		super (nome, sobrenome, senha);
		this.setHistorico(new ArrayList<Comprovante>());
		this.setQtdMax(5);
		this.setPrazoMax(30);
	}

	public Aluno () {

	}

	//metodo para o aluno fazer cadastro
	public void cadastroAluno () {
		System.out.println("Digite o nome, sobrenome, email e nova senha.");
		String nome = Biblioteca.scan.nextLine();
		String sobrenome = Biblioteca.scan.nextLine();
		int senha = Biblioteca.scan.nextInt();
		Aluno a = new Aluno(nome, sobrenome, senha);
		Biblioteca.getUsuarioAluno().add(a);
	}
}
