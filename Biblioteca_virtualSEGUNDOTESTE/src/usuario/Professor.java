package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import biblioteca.Biblioteca;
import comprovante.Comprovante;
import comprovante.ComprovanteDevolucao;
import comprovante.ComprovanteEmprestimo;

public class Professor extends Usuario {
	public static final Scanner scan = new Scanner(System.in);

	//construtor da classe professor
	public Professor (final String nome, final String sobrenome, final int iD, final int senha) {
		super (nome, sobrenome, iD, senha);
		this.setHistorico(new ArrayList<Comprovante>());
		this.setQtdMax(10);
		this.setPrazoMax(90);
	}

	public Professor () {

	}

	// m�todo para realizar empr�stimo
	@Override
	public void realizaEmprestimo (final String titulo) {
		// se o limite de livros ainda n�o for atigido
		if (this.getQtdMax() > 0) {

			// se o livro estiver dispon�vel faz empr�stimo
			Biblioteca.emprestimo(titulo);

			// cria comprovante e adiciona ao hist�rico
			Comprovante comp = new Comprovante (titulo, LocalDate.now(), LocalDate.now().plusDays(90), LocalDate.now().plusDays(90));
			this.getHistorico().add(comp);

			// cria comprovante de empr�stimo
			ComprovanteEmprestimo c = new ComprovanteEmprestimo (titulo, LocalDate.now(), LocalDate.now().plusDays(this.getPrazoMax()));
			System.out.print(c);

			// diminui em 1 a quantidade poss�veis futuros empr�stimos
			this.setQtdMax(this.getQtdMax()-1);
		} else {
			System.out.println("Voc� atingiu o limite para a loca��o de livros.\n "
					+ "Devolva um livro e tente novamente");
		}
	}

	// m�todo para realizar a devolu��o
	@Override
	public void realizaDevolucao (final String titulo) {
		Biblioteca.devolucao(titulo);

		// resgata datas de empr�stimo e previs�o de devolu��o
		for (int i = 0; i < this.getHistorico().size(); i++) {
			if (this.getHistorico().get(i).getTitulo().equals(titulo))	{

				LocalDate emprest = this.getHistorico().get(i).getDataEmprestimo();
				LocalDate previsao = this.getHistorico().get(i).getDataPrevista();
				this.getHistorico().get(i).setDataDevolucao(LocalDate.now());

				// cria comprovante de devolu��o e o imprime
				ComprovanteDevolucao c = new ComprovanteDevolucao(titulo, emprest, LocalDate.now());
				System.out.print(c);

				// se a data de devolu��o for ap�s a data prevista:
				if (this.getHistorico().get(i).getDataDevolucao().isAfter(previsao)) {
					System.out.print("Aten��o! Devolu��o atrasada, voc� est� bloqueado por 7 dias.");
				}
			}
		}
	}

	// m�todo para solicitar o hist�rico
	public List <Comprovante> solicitaHistorico (final int iD, final int senha) {
		if (Biblioteca.verificaProf(iD, senha)) {
			return this.getHistorico();
		}
		else {
			throw new ArrayIndexOutOfBoundsException ("Usu�rio n�o encontrado ou iD e senha errados.");
		}
	}
}