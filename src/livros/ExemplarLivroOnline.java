package Livros;

public class ExemplarLivroOnline extends Livro {
	private String [] link; //link do livro online
	
	//construtor da classe ExemplarLivroonline
	public ExemplarLivroOnline (String titulo, String assunto, String [] autores, 
								String [] nChamada, int ano, String [] link) {
		super (titulo, assunto, autores, nChamada, ano);
		this.link = link;
	}

	public String[] getLink() {
		return link;
	}

	public void setLink(String[] link) {
		this.link = link;
	}
	
	//NECESSARIO IMPLEMENTAR AINDA
	public String toString () {
		return "";
	}
}
