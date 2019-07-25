package usuario;

public class Professor extends Usuario implements Emprestimo {
	//professor pode alugar ate 10 livros com prazo de devolucao de 90 dias
	int qtdMax = 10;
	int prazoMax = 90;
	
	//construtor da classe professor
	public Professor (String nome, String sobrenome, String email, int id, int senha) {
		super (nome, sobrenome, email, id, senha);
	}
	
	public void realizaEmprestimo () {
		
	}
	
	public void realizaDevolucao () {
		
	}
}
