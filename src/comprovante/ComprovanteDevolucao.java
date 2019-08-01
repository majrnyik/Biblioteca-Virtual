package comprovante;
import java.time.LocalDate;
public class ComprovanteDevolucao extends Comprovante {

	// construtor da classe ComprovanteDevolucao
	public ComprovanteDevolucao (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, LocalDate.now());
	}

	@Override
	public String toString () {
		return "---------- Devolução realizada com sucessso! ----------\n"
				+ "Título:  " + this.getTitulo() + "\n"
				+ "Data de devolução: " + this.getDataDevolucao() + "\n";
	}
}
