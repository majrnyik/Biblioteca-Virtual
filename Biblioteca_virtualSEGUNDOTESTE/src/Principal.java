import biblioteca.Biblioteca;
import usuario.Aluno;
import usuario.Bibliotecario;
import usuario.Professor;

public class Principal {

	public static void main(final String[] args) {
		Biblioteca biblioteca = Biblioteca.getInstance();

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
		b.removeLivro("Livro");

		// busca de livros por t�tulo
		System.out.println(biblioteca.buscaLivro("Dom Casmurro"));
		System.out.println(biblioteca.buscaLivro("Iracema"));
		System.out.println(biblioteca.buscaLivro("O Corti�o"));

		// imprime o acervo
		System.out.println(biblioteca.getAcervo());

		// busca de usu�rios
		System.out.println(biblioteca.buscaAluno(10, 123));
		System.out.println(biblioteca.buscaProfessor(20, 456));
		System.out.println(biblioteca.buscaTA(30, 789));

		//empr�stimo e devolu��o de livro por um aluno
		a.realizaEmprestimo("Dom Casmurro");
		a.realizaEmprestimo("Iracema");
		a.realizaEmprestimo("O Corti�o");
		a.realizaDevolucao("Dom Casmurro");

		// impress�o de hist�rico
		System.out.println(a.solicitaHistorico(10, 123));
	}
}