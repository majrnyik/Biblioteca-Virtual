package usuario;

public class Bibliotecario extends Usuario implements Emprestimo, Cadastro {
	
	//construtor da classe bibliotecario
	public Bibliotecario (String nome, String sobrenome, String email, int id, int senha) {
		super (nome, sobrenome, email, id, senha);
	}
	
	//metodo para cadastrar usuario 
	//AINDA NAO TESTEI E NEM TA COMPLETO KKKKJ
	public void cadastraUsuario () {
		String tipo = "";
		Usuario user;
		switch (tipo) {
			case "Aluno": 
				user = new Aluno (getNome(), getSobrenome(), getEmail(), getiD(), getSenha());
				break;
			case "Professor": 
				user = new Professor (getNome(), getSobrenome(), getEmail(), getiD(), getSenha());
				break;
		}
			
	}
	
	public void cadastraLivro () {
		
	}
	
	public void removeCadastroUsuario () {
		
	}
	
	public void removeCadastroLivro () {
		
	}
	
	public void realizaEmprestimoFisico () {
		
	}
	
	public void realizaEmprestimoOnline () {
		
	}
	
	public void realizaDevolucao () {
		
	}	
	
	//metodo para ver o histórico de emprestimos de um usuario
	//ainda não sei se deixo aqui ou não
	//apenas bibliotecario tem acesso ao historico???
	public void verificaHistorico () {
		
	}
}
