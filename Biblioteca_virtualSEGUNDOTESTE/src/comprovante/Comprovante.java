package comprovante;
import java.time.LocalDate;

public class Comprovante {
	private String titulo;				// titulo do livro
	private LocalDate dataEmprestimo;	// data em que o empr�stimo foi realizado
	private LocalDate dataPrevista;		// data prevista para ocorrer a devolu��o
	private LocalDate dataDevolucao;	// data em que ocorreu a devolu��o

	public Comprovante (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista, final LocalDate dataDevolucao) {
		this.setTitulo(titulo);
		this.setDataEmprestimo(dataEmprestimo);
		this.setDataPrevista(dataPrevista);
		this.setDataDevolucao(dataDevolucao);
	}

	public Comprovante () {

	}

	@Override
	public String toString () {
		return "------------------------------------------------------- \n"
				+ "T�tulo:  " + this.getTitulo() + "\n"
				+ "Data de empr�stimo: " + this.getDataEmprestimo() + "\n\n";
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