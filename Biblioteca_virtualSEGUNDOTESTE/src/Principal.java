import biblioteca.Biblioteca;
import usuario.Aluno;
import usuario.Bibliotecario;
import usuario.Professor;

public class Principal {

	public static void main(final String[] args) {
		Biblioteca biblioteca = Biblioteca.getInstance();

		// cadastro de usuários
		biblioteca.cadastroAluno("Beatriz", "Farkas", 10, 123);
		biblioteca.cadastroProfessor("Saul", "Leite", 20, 456);
		biblioteca.cadastroTA("Vera", "Nagamuta", 30, 789);

		// instanciação auxiliar de usuários
		Aluno a = new Aluno();
		a = biblioteca.buscaAluno(10, 123);
		Professor p = new Professor();
		p = biblioteca.buscaProfessor(20, 456);
		Bibliotecario b = new Bibliotecario();
		b = biblioteca.buscaTA(30, 789);

		// cadastro de livros
		Biblioteca.cadastraLivro("Dom Casmurro", "Romance", "Machado de Assis", 1899);
		Biblioteca.cadastraLivro("Iracema", "Romance", "José de Alencar", 1865);
		Biblioteca.cadastraLivro("O Cortiço", "Romance", "Aluísio Azevedo", 1890);

		// cadastro de livros por um bibliotecário
		b.cadastraLivro("Livro", "assunto", "autor", 1900);

		// remoção de livros por um bibliotecário
		b.removeLivro("Livro");

		// busca de livros por título
		System.out.println(biblioteca.buscaLivro("Dom Casmurro"));
		System.out.println(biblioteca.buscaLivro("Iracema"));
		System.out.println(biblioteca.buscaLivro("O Cortiço"));

		// imprime o acervo
		System.out.println(biblioteca.getAcervo());

		// busca de usuários
		System.out.println(biblioteca.buscaAluno(10, 123));
		System.out.println(biblioteca.buscaProfessor(20, 456));
		System.out.println(biblioteca.buscaTA(30, 789));

		//empréstimo e devolução de livro por um aluno
		a.realizaEmprestimo("Dom Casmurro");
		a.realizaEmprestimo("Iracema");
		a.realizaEmprestimo("O Cortiço");
		a.realizaDevolucao("Dom Casmurro");

		// impressão de histórico
		System.out.println(a.solicitaHistorico(10, 123));
	}
}