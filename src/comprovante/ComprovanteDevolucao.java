package comprovante;
import java.time.LocalDate;
public class ComprovanteDevolucao extends Comprovante {

	// construtor da classe ComprovanteDevolucao
	public ComprovanteDevolucao (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, LocalDate.now());
	}

	@Override
	public String toString () {
		return "---------- Devolu��o realizada com sucessso! ----------\n"
				+ "T�tulo:  " + this.getTitulo() + "\n"
				+ "Data de devolu��o: " + this.getDataDevolucao() + "\n";
	}
}
