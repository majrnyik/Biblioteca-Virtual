package comprovante;
import java.time.LocalDate;
public class ComprovanteDevolucao extends Comprovante {

	// construtor da classe ComprovanteDevolucao
	public ComprovanteDevolucao (String titulo, LocalDate dataEmprestimo, LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, LocalDate.now());
	}
	
	@Override
	public String toString () {
		return "---------- Devolução realizada com sucessso! ----------" 
				+ "Título:  " + getTitulo() + "\n" 
				+ "Data de empréstimo: " + getDataEmprestimo() + "\n"
				+ "Data de devolução: " + getDataDevolucao() + "\n";
	}
	
	/*------------------------- getters e setters -----------------------------*/
	
	static public String getTitulo() {
		return titulo;
	}
	
	static public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
}
