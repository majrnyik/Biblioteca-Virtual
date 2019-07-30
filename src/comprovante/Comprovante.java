package comprovante;
import java.time.LocalDate;

public class Comprovante {
	static String titulo;				// titulo do livro
	static LocalDate dataEmprestimo;	// data em que o empréstimo foi realizado
	static LocalDate dataPrevista;		// data prevista para ocorrer a devolução
	static LocalDate dataDevolucao;		// data em que ocorreu a devolução
	
	public Comprovante (String titulo, LocalDate dataEmprestimo, LocalDate dataPrevista, LocalDate dataDevolucao) {
		setTitulo(titulo);
		setDataEmprestimo(dataEmprestimo);
		setDataPrevista(dataPrevista);
		setDataDevolucao(dataDevolucao);		
	}
	
	public String toString () {
		return  "Título:  " + getTitulo() + "\n" 
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
	
	public static LocalDate getDataPrevista() {
		return dataPrevista;
	}

	public static void setDataPrevista(LocalDate dataPrevista) {
		Comprovante.dataPrevista = dataPrevista;
	}

	public static void setTitulo(String titulo) {
		Comprovante.titulo = titulo;
	}

	public static void setDataEmprestimo(LocalDate dataEmprestimo) {
		Comprovante.dataEmprestimo = dataEmprestimo;
	}

	public static void setDataDevolucao(LocalDate dataDevolucao) {
		Comprovante.dataDevolucao = dataDevolucao;
	}

}


