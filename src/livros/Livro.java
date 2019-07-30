package livros;

public class Livro {
	
	public static String titulo; 				// titulo do livro
	public String assunto; 						// assunto do livro 
	public String autor; 						// autores do livro
	public int nChamada;						// numero de chamada do livro
	public static int nChamadaUniversal = 0; 	// ultimo numero de chamada
	public int ano; 							// ano de publicação
	public static int status;

	// construtor da classe abstrata Livro
	public Livro(String titulo, String assunto, String autor, int ano) {
		setTitulo(titulo);
		this.assunto = assunto;
		this.autor = autor;
		this.ano = ano;
		this.nChamada = nChamadaUniversal++; 	//a cada cadastro o numero de chamada aumenta +1
		setStatus(0);
	}
	
	@Override
	public String toString () {
		return "Título: " + getTitulo() + "\n"
			+ "Assunto: " + getAssunto() + "\n"
			+ "Autor: "  + getAutor() + "\n"
			+ "Ano de publicação: "	+ getAno() + "\n";
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getnChamada() {
		return nChamada;
	}

	public void setnChamada(int nChamada) {
		this.nChamada = nChamada;
	}

	public static int getnChamadaUniversal() {
		return nChamadaUniversal;
	}

	public static void setnChamadaUniversal(int nChamadaUniversal) {
		Livro.nChamadaUniversal = nChamadaUniversal;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public static int getStatus() {
		return status;
	}

	public static void setStatus(int status) {
		Livro.status = status;
	}

	public static String getTitulo() {
		return titulo;
	}

	public static void setTitulo(String titulo) {
		Livro.titulo = titulo;
	}
}
