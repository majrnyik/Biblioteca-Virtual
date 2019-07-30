package comprovante;
import java.time.LocalDate;

public class ComprovanteEmprestimo extends Comprovante {
	
	// construtor da classe ComprovanteEmprestimo
	public ComprovanteEmprestimo (String titulo, LocalDate dataEmprestimo, LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, dataPrevista);	
	}
	
	@Override
	public String toString () {
		return "---------- Empréstimo realizado com sucessso ----------!" 
				+ "Descrição:  " + getTitulo() + "\n" 
				+ "Data de empréstimo: " + getDataEmprestimo() + "\n"
				+ "Prazo de devolução: " + getDataPrevista() + "\n";
	}
	
	/*------------------------- getters e setters -----------------------------*/
	
	static public String getTitulo() {
		return titulo;
	}
	
	static public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	static public LocalDate getDataPrevista() {
		return dataPrevista;
	}
}
