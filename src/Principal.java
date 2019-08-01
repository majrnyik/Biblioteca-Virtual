import biblioteca.Biblioteca;
import usuario.Aluno;
import usuario.Bibliotecario;
import usuario.Professor;

public class Principal {



	public static void main(final String[] args) {
		Biblioteca biblioteca = new Biblioteca();

		// cadastro de usu�rios
		biblioteca.cadastroAluno("Beatriz", "Farkas", 10, 123);
		biblioteca.cadastroProfessor("Saul", "Leite", 20, 456);
		biblioteca.cadastroTA("Vera", "Nagamuta", 30, 789);

		// instancia��o auxiliar de usu�rios
		Aluno a = new Aluno();
		a = biblioteca.buscaAluno(10, 123);
		Professor p = new Professor();
		p = biblioteca.buscaProfessor(20, 456);
		Bibliotecario b = new Bibliotecario();
		b = biblioteca.buscaTA(30, 789);

		// cadastro de livros
		Biblioteca.cadastraLivro("Dom Casmurro", "Romance", "Machado de Assis", 1899);
		Biblioteca.cadastraLivro("Iracema", "Romance", "Jos� de Alencar", 1865);
		Biblioteca.cadastraLivro("O Corti�o", "Romance", "Alu�sio Azevedo", 1890);
		// cadastro de livros por um bibliotec�rio
		b.cadastraLivro("Livro", "assunto", "autor", 1900);

		// remo��o de livros por um bibliotec�rio
		/*b.removeLivro("Livro");*/

		// busca de livros por t�tulo
		/*System.out.println(biblioteca.buscaLivro("Dom Casmurro"));
		System.out.println(biblioteca.buscaLivro("Iracema"));
		System.out.println(biblioteca.buscaLivro("O Corti�o"));
		System.out.println(biblioteca.buscaLivro("Livro"));*/

		// busca usu�rios, para manter a privacidade � necess�rio informar a senha tamb�m
		/*System.out.println(biblioteca.buscaAluno(10, 123));
		System.out.println(biblioteca.buscaProfessor(20, 456));
		System.out.println(biblioteca.buscaTA(30, 789));*/

		//empr�stimo e devolu��o de livro por um aluno
		a.realizaEmprestimo("Dom Casmurro");
		a.realizaDevolucao("Dom Casmurro");

		// impress�o de hist�rico PRECISO ADICIONAR NIVEL DE SEGURAN�A AQUI --> COLOCAR ID E SENHA P ACESSAR
		p.solicitaHistorico();

	}
}

