import java.util.Scanner;

import biblioteca.Biblioteca;
import usuario.Aluno;
import usuario.Bibliotecario;
import usuario.Professor;

public class Principal {
	
	public static void main(final String[] args) {
		int type1;
		int type2 = 10;
		int iD;
		int senha;
		String titulo;
		Biblioteca biblioteca = new Biblioteca();
		Scanner scan = new Scanner(System.in);

		System.out.println("----------	Bem vindo!	----------");


		System.out.println("Digite seu iD e senha: \n");
		iD = scan.nextInt();
		scan.nextLine();
		senha = scan.nextInt();

		System.out.println("Digite seu perfil: ");
		System.out.println("1: Aluno.\n"
				+ "2: Professor.\n"
				+ "3: Funcionário.");

		while (type2 != 0) {
			type1 = scan.nextInt();
			switch (type1) {
			case 1:
				Aluno a = new Aluno();
				a = biblioteca.buscaAluno(iD, senha);
				System.out.println("O que você deseja?");
				System.out.println("1: Procurar livro.\n"
						+ "2: Verificar meu histórico.\n"
						+ "3: Alugar um livro.\n"
						+ "4: Devolver um livro.\n" 
						+ "5: Fazer cadastro.\n"
						+ "Pressione '0' para sair.");
				type2 = scan.nextInt();
				switch (type2) {
				case 1:
					System.out.println("Digite o nome do livro a ser procurado. \n");
					scan.nextLine();
					titulo = scan.nextLine();
					biblioteca.buscaLivro(titulo);
					break;
				case 2:
					System.out.println(a.getHistorico());
					break;
				case 3:
					System.out.println("Digite o nome do livro a ser alugado.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					a.realizaEmprestimo(titulo);
					break;
				case 4:
					System.out.println("Digite o nome do livro a ser devolvido.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					a.realizaDevolucao(titulo);
					break;
				case 5:
					a.cadastroAluno();
					break;
				default:
					return;
				}
				break;
			case 2:
				Professor p = new Professor();
				p = biblioteca.buscaProfessor(iD, senha);
				System.out.println("O que você deseja?");
				System.out.println("1: Procurar livro.\n"
						+ "2: Verificar meu histórico.\n"
						+ "3: Alugar um livro.\n"
						+ "4: Devolver um livro.\n" 
						+ "5: Fazer cadastro.\n"
						+ "Pressione '0' para sair.");
				type2 = scan.nextInt();
				switch (type2) {
				case 1:
					System.out.println("Digite o nome do livro a ser procurado.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					biblioteca.buscaLivro(titulo);
					break;
				case 2:
					System.out.println(p.getHistorico());
					break;
				case 3:
					System.out.println("Digite o nome do livro a ser alugado.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					p.realizaEmprestimo(titulo);
					break;
				case 4:
					System.out.println("Digite o nome do livro a ser devolvido.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					p.realizaDevolucao(titulo);
					break;
				case 5:
					p.cadastraProfessor();
					break;
				default:
					return;
				}
				break;
			case 3:
				Bibliotecario b = new Bibliotecario();
				b = biblioteca.buscaTA(iD, senha);
				System.out.println("O que você deseja?");
				System.out.println("1: Procurar livro.\n"
						+ "2: Cadastrar livro.\n"
						+ "3: Remover livro.\n"
						+ "Pressione '0' para sair.");
				type2 = scan.nextInt();
				switch (type2) {
				case 1:
					System.out.println("Digite o nome do livro a ser procurado.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					biblioteca.buscaLivro(titulo);
					break;
				case 2:
					b.cadastraLivro();
					break;
				case 3:
					System.out.println("Digite o nome do livro a ser removido.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					b.removeLivro(titulo);
					break;
				default:
					return;
				}
				break;
			default:
				return;
			}
		}
		scan.close();
	}
}
