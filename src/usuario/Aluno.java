package usuario;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.Biblioteca;
import comprovante.Comprovante;

public class Aluno extends Usuario {
	public static Scanner scan = new Scanner(System.in);

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
		String nome = Aluno.scan.nextLine();
		String sobrenome = Aluno.scan.nextLine();
		int senha = Aluno.scan.nextInt();
		Aluno a = new Aluno(nome, sobrenome, senha);
		Biblioteca.getUsuarioAluno().add(a);
	}
}
