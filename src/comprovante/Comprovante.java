package comprovante;
import java.time.LocalDate;

public class Comprovante {
	private String titulo;				// titulo do livro
	private LocalDate dataEmprestimo;	// data em que o empréstimo foi realizado
	private LocalDate dataPrevista;		// data prevista para ocorrer a devolução
	private LocalDate dataDevolucao;	// data em que ocorreu a devolução

	public Comprovante (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista, final LocalDate dataDevolucao) {
		this.setTitulo(titulo);
		this.setDataEmprestimo(dataEmprestimo);
		this.setDataPrevista(dataPrevista);
		this.setDataDevolucao(dataDevolucao);
	}

	@Override
	public String toString () {
		return  "Título:  " + this.getTitulo() + "\n"
				+ "Data de empréstimo: " + this.getDataEmprestimo() + "\n"
				+ "Data de devolução: " + this.getDataDevolucao() + "\n";
	}


	/*------------------------- getters e setters -----------------------------*/


	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
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


