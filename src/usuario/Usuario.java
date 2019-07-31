package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;
import comprovante.Comprovante;
import comprovante.ComprovanteDevolucao;
import comprovante.ComprovanteEmprestimo;

public abstract class  Usuario {
	private List <Comprovante> historico;								// histórico de empéstimos do usuário
	private String nome; 												// nome do usuario
	private String sobrenome; 											// sobrenome do usuario
	private int iD;														// número de identificação do usuário
	private int senha;													// senha do usuário
	private static int iDUniversal = 0; 								// variável auxiliar para criação de um iD
	private int  qtdMax; 												// quantidade máxima de livros para locação por usuário
	private int prazoMax;												// data máxima que um livro pode ser alugado
	private LocalDate dataEmprestimo = LocalDate.now();					// calcula o dia de hoje
	private LocalDate dataPrevista = this.getDataEmprestimo()			// calcula a data de devolução baseado na data atual
			.plusDays(this.getPrazoMax());
	private LocalDate dataDevolucao = LocalDate.now();

	//construtor da classe abstrata usuario
	public Usuario (final String nome, final String sobrenome, final int senha) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setiD(Usuario.iDUniversal++);
		this.setSenha(senha);
		this.setHistorico(new ArrayList<Comprovante>());
	}

	public Usuario () {

	}

	// método para realizar empréstimo
	public void realizaEmprestimo (final String titulo) {
		// se o limite de livros ainda não for atigido
		if (this.getQtdMax() > 0) {
			// se o livro estiver disponivel
			Biblioteca.emprestimo(titulo);
			// cria comprovante de empréstimo e coloca no histórico do usuário
			ComprovanteEmprestimo c = new ComprovanteEmprestimo (titulo, this.getDataEmprestimo(), this.getDataPrevista());
			this.getHistorico().add(c);
			System.out.print(c);
			// diminui em 1 a quantidade possíveis futuros empréstimos
			int qtdNova = this.getQtdMax();
			this.setQtdMax(qtdNova);
		} else {
			System.out.println("Você atingiu o limite para a locação de livros.\n "
					+ "Devolva um livro e tente novamente");
		}
	}

	// método para realizar a devolução
	public void realizaDevolucao (final String titulo) {
		Biblioteca.devolucao(titulo);

		// resgata datas de empréstimo e previsão de devolução
		LocalDate emprest = null;
		LocalDate previsao =  null;
		for (int i = 0; i < this.getHistorico().size(); i++) {
			if (this.getHistorico().get(i).getTitulo().equals(titulo))	{
				emprest = this.getHistorico().get(i).getDataEmprestimo();
				previsao = this.getHistorico().get(i).getDataPrevista();

				// se a data de devolução for após a data prevista:
				if (this.getHistorico().get(i).getDataDevolucao().isAfter(previsao)) {
					System.out.print("Atenção! Devolução atrasada, você está bloqueado por 7 dias.");
				}
			}
		}
		// cria comprovante de devolução
		ComprovanteDevolucao c = new ComprovanteDevolucao(titulo, emprest, previsao);
		System.out.print(c);
	}

	/* -------- funções getters e setters -------- */

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

	public static int getiDUniversal() {
		return Usuario.iDUniversal;
	}

	public static void setiDUniversal(final int iDUniversal) {
		Usuario.iDUniversal = iDUniversal;
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

	public LocalDate getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public void setDataEmprestimo(final LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataPrevista() {
		return this.dataPrevista;
	}

	public void setDataPrevista(final LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public LocalDate getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataDevolucao(final LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
