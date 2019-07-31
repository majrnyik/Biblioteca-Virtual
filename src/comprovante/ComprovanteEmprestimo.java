package comprovante;
import java.time.LocalDate;

public class ComprovanteEmprestimo extends Comprovante {

	// construtor da classe ComprovanteEmprestimo
	public ComprovanteEmprestimo (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, dataPrevista);
	}

	@Override
	public String toString () {
		return "---------- Empréstimo realizado com sucessso! ----------"
				+ "Título:  " + this.getTitulo() + "\n"
				+ "Data de empréstimo: " + this.getDataEmprestimo() + "\n"
				+ "Prazo de devolução: " + this.getDataPrevista() + "\n";
	}
}
