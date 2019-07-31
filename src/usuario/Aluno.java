package usuario;
import java.util.ArrayList;
import java.util.Scanner;

import comprovante.Comprovante;

public class Aluno extends Usuario {
	public static Scanner scan = new Scanner(System.in);

	//construtor da classe aluno
	public Aluno (final String nome, final String sobrenome, final int iD, final int senha) {
		super (nome, sobrenome, iD, senha);
		this.setHistorico(new ArrayList<Comprovante>());
		this.setQtdMax(5);
		this.setPrazoMax(30);
	}

	public Aluno () {

	}
}
