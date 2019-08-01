package usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.Biblioteca;
import comprovante.Comprovante;
import comprovante.ComprovanteDevolucao;
import comprovante.ComprovanteEmprestimo;

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

	// método para realizar empréstimo
	@Override
	public void realizaEmprestimo (final String titulo) {
		// se o limite de livros ainda não for atigido
		if (this.getQtdMax() > 0) {
			// se o livro estiver disponivel
			Biblioteca.emprestimo(titulo);
			// cria comprovante e adiciona ao historico
			Comprovante comp = new Comprovante (titulo, LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().plusDays(30));
			this.getHistorico().add(comp);
			// cria comprovante de emprestimo
			ComprovanteEmprestimo c = new ComprovanteEmprestimo (titulo, LocalDate.now(), LocalDate.now().plusDays(this.getPrazoMax()));
			System.out.print(c);
			// diminui em 1 a quantidade possíveis futuros empréstimos
			int qtdNova = this.getQtdMax();
			this.setQtdMax(qtdNova--);
		} else {
			System.out.println("Você atingiu o limite para a locação de livros.\n "
					+ "Devolva um livro e tente novamente");
		}
	}


	// método para realizar a devolução
	@Override
	public void realizaDevolucao (final String titulo) {
		Biblioteca.devolucao(titulo);

		// resgata datas de empréstimo e previsão de devolução
		for (int i = 0; i < this.getHistorico().size(); i++) {
			if (this.getHistorico().get(i).getTitulo().equals(titulo))	{

				LocalDate emprest = this.getHistorico().get(i).getDataEmprestimo();
				LocalDate previsao = this.getHistorico().get(i).getDataPrevista();
				this.getHistorico().get(i).setDataDevolucao(LocalDate.now());

				ComprovanteDevolucao c = new ComprovanteDevolucao(titulo, emprest, LocalDate.now());
				System.out.print(c);

				// se a data de devolução for após a data prevista:
				if (this.getHistorico().get(i).getDataDevolucao().isAfter(previsao)) {
					System.out.print("Atenção! Devolução atrasada, você está bloqueado por 7 dias.");
				}
			}
		}
	}

}
