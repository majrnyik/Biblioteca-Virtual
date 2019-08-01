package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;
import comprovante.Comprovante;
import comprovante.ComprovanteDevolucao;
import comprovante.ComprovanteEmprestimo;
import java.util.Scanner;

public abstract class  Usuario {
	private List <Comprovante> historico;								// hist�rico de emp�stimos do usu�rio
	private String nome; 												// nome do usuario
	private String sobrenome; 											// sobrenome do usuario
	private int iD;														// n�mero de identifica��o do usu�rio
	private int senha;													// senha do usu�rio
	private int  qtdMax; 												// quantidade m�xima de livros para loca��o por usu�rio
	private int prazoMax;												// data m�xima que um livro pode ser alugado
	private LocalDate dataEmprestimo = LocalDate.now();					// calcula o dia de hoje
	private LocalDate dataPrevista = this.getDataEmprestimo()			// calcula a data de devolu��o baseado na data atual
			.plusDays(this.getPrazoMax());
	private LocalDate dataDevolucao = LocalDate.now();

	//construtor da classe abstrata usuario
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
			// se o livro estiver disponivel
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
			int qtdNova = this.getQtdMax();
			this.setQtdMax(qtdNova);
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
				+ "iD: " + this.getiD();
	}
	public void solicitaHistorico() {
		Scanner scan =  new Scanner(System.in);
		System.out.print("ID: ");
		int scan_id = scan.nextInt();
		System.out.print("Senha: ");
		int scan_pass = scan.nextInt();
		
		if (scan_id == this.getiD() && scan_pass == this.getSenha()) {
			System.out.println(this.getHistorico());
		}else {
			System.out.println("ID ou senha incorreta! ");
			System.out.println("Deseja digitar a senha novamente?");
			System.out.println("1-Sim");
			System.out.println("2-nao");
			int menu= scan.nextInt();
			switch(menu){
			
			case 1:
				solicitaHistorico();
			case 2: break;
			}
		
		}
		scan.close();
	}

	/* -------- fun��es getters e setters -------- */

	protected List<Comprovante> getHistorico() {
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
