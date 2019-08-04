package comprovante;
import java.time.LocalDate;

public class ComprovanteEmprestimo extends Comprovante {

	// construtor da classe ComprovanteEmprestimo
	public ComprovanteEmprestimo (final String titulo, final LocalDate dataEmprestimo, final LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, dataPrevista);
	}

	@Override
	public String toString () {
		return "---------- Empr�stimo realizado com sucessso! ----------"
				+ "T�tulo:  " + this.getTitulo() + "\n"
				+ "Data de empr�stimo: " + this.getDataEmprestimo() + "\n"
				+ "Prazo de devolu��o: " + this.getDataPrevista() + "\n";
	}
}
