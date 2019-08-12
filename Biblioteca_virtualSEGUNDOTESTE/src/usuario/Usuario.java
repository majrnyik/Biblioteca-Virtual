package usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;
import comprovante.Comprovante;
import comprovante.ComprovanteDevolucao;
import comprovante.ComprovanteEmprestimo;

public abstract class  Usuario {
	private List <Comprovante> historico;							// hist�rico de emp�stimos do usu�rio
	private String nome; 											// nome do usuario
	private String sobrenome; 										// sobrenome do usuario
	private int iD;													// n�mero de identifica��o do usu�rio
	private int senha;												// senha do usu�rio
	private int  qtdMax; 											// quantidade m�xima de livros para loca��o por usu�rio
	private int prazoMax;											// data m�xima que um livro pode ser alugado

	//construtor da classe usuario
	public Usuario (final String nome, final String sobrenome,final int iD, final int senha) {
		this.setNome(nome);
		this.setiD(iD);
		this.setSobrenome(sobrenome);
		this.setSenha(senha);
		this.setHistorico(new ArrayList<Comprovante>());
	}

	public Usuario () {

	}

	// m�todo para realizar empr�stimo
	public void realizaEmprestimo (final String titulo) {
		// se o limite de livros ainda n�o for atigido
		if (this.getQtdMax() > 0) {
			// se o livro estiver disponivel faz o empr�stimo
			Biblioteca.emprestimo(titulo);
			// cria comprovante e adiciona ao historico
			Comprovante comp = new Comprovante (titulo, LocalDate.now(),
					LocalDate.now().plusDays(this.getPrazoMax()),
					LocalDate.now().plusDays(this.getPrazoMax()));
			this.getHistorico().add(comp);
			// cria comprovante de emprestimo
			ComprovanteEmprestimo c = new ComprovanteEmprestimo (titulo, LocalDate.now(),
					LocalDate.now().plusDays(this.getPrazoMax()));
			System.out.print(c);
			// diminui em 1 a quantidade poss�veis futuros empr�stimos
			this.setQtdMax(this.getQtdMax()-1);
		} else {
			System.out.println("Voc� atingiu o limite para a loca��o de livros.\n "
					+ "Devolva um livro e tente novamente");
		}
	}

	// m�todo para realizar a devolu��o
	public void realizaDevolucao (final String titulo) {
		Biblioteca.devolucao(titulo);

		// resgata datas de empr�stimo e previs�o de devolu��o
		for (int i = 0; i < this.getHistorico().size(); i++) {
			if (this.getHistorico().get(i).getTitulo().equals(titulo))	{
				LocalDate emprest = this.getHistorico().get(i).getDataEmprestimo();
				LocalDate previsao = this.getHistorico().get(i).getDataPrevista();
				this.getHistorico().get(i).setDataDevolucao(LocalDate.now());
				ComprovanteDevolucao c = new ComprovanteDevolucao(titulo, emprest, previsao);
				System.out.print(c);
				// se a data de devolu��o for ap�s a data prevista:
				if (this.getHistorico().get(i).getDataDevolucao().isAfter(previsao)) {
					System.out.print("Aten��o! Devolu��o atrasada, voc� est� bloqueado por 7 dias.");
				}
			}
		}
	}

	@Override
	public String toString () {
		return "Nome: " + this.getNome() + " " + this.getSobrenome() + "\n"
				+ "iD: " + this.getiD() + "\n";
	}

	/* -------- fun��es getters e setters -------- */

	public List<Comprovante> getHistorico() {
		return this.historico;
	}

	public void setHistorico(final List<Comprovante> historico) {
		this.historico = historico;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(final String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getiD() {
		return this.iD;
	}

	public void setiD(final int iD) {
		this.iD = iD;
	}

	public int getSenha() {
		return this.senha;
	}

	public void setSenha(final int senha) {
		this.senha = senha;
	}

	public int getQtdMax() {
		return this.qtdMax;
	}

	public void setQtdMax(final int qtdMax) {
		this.qtdMax = qtdMax;
	}

	public int getPrazoMax() {
		return this.prazoMax;
	}

	public void setPrazoMax(final int prazoMax) {
		this.prazoMax = prazoMax;
	}
}
