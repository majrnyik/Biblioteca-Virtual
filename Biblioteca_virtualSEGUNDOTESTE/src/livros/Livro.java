package livros;

public class Livro {
	private String titulo; 						// titulo do livro
	private String assunto; 					// assunto do livro
	private String autor; 						// autores do livro
	private int nChamada;						// numero de chamada do livro
	private static int nChamadaUniversal = 0; 	// ultimo numero de chamada
	private int ano; 							// ano de publicação
	private int status;							// 0: o livro está disponível, 1 está alugado

	// construtor da classe abstrata Livro
	public Livro(final String titulo, final String assunto, final String autor, final int ano) {
		this.setTitulo(titulo);
		this.setAssunto(assunto);
		this.autor = autor;
		this.ano = ano;
		this.nChamada = Livro.nChamadaUniversal++; 	//a cada cadastro o numero de chamada aumenta +1
		this.setStatus(0);
	}

	@Override
	public String toString () {
		return "Título: " + this.getTitulo() + "\n"
				+ "Assunto: " + this.getAssunto() + "\n"
				+ "Autor: "  + this.getAutor() + "\n"
				+ "Ano de publicação: "	+ this.getAno() + "\n\n";
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(final String assunto) {
		this.assunto = assunto;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(final String autor) {
		this.autor = autor;
	}

	public int getnChamada() {
		return this.nChamada;
	}

	public void setnChamada(final int nChamada) {
		this.nChamada = nChamada;
	}

	public static int getnChamadaUniversal() {
		return Livro.nChamadaUniversal;
	}

	public static void setnChamadaUniversal(final int nChamadaUniversal) {
		Livro.nChamadaUniversal = nChamadaUniversal;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(final int ano) {
		this.ano = ano;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(final int status) {
		this.status = status;
	}
}