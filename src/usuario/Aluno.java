package usuario;

public class Aluno extends Usuario implements Emprestimo {
	//aluno pode alugar até 5 livros com prazo de 30 dias
	int limite_livros = 5;
	int prazoMax = 30;
	
	//construtor da classe aluno 
	public Aluno (String nome, String sobrenome, String email, int id, int senha) {
		super (nome, sobrenome, email, id, senha);
	}
	public void realizaEmprestimo () {
		
	}
	
	public void realizaDevolucao () {
		
	}
}
