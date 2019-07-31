package comprovante;
import java.time.LocalDate;
public class ComprovanteDevolucao extends Comprovante {

	// construtor da classe ComprovanteDevolucao
	public ComprovanteDevolucao (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, LocalDate.now());
	}

	@Override
	public String toString () {
		return "---------- Devolução realizada com sucessso! ----------"
				+ "Título:  " + this.getTitulo() + "\n"
				+ "Data de empréstimo: " + this.getDataEmprestimo() + "\n"
				+ "Data de devolução: " + this.getDataDevolucao() + "\n";
	}
}
