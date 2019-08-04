import java.util.Scanner;

import biblioteca.Biblioteca;
import usuario.Aluno;
import usuario.Bibliotecario;
import usuario.Professor;

public class Principal {

	public static void main(final String[] args) {
		int type1;
		int type2 = 10;
		int type3;
		int iD;
		int senha;
		String titulo;
		Biblioteca biblioteca = Biblioteca.getInstance();
		Scanner scan = new Scanner(System.in);

		System.out.println("----------	Bem vindo!	----------");

		System.out.println("Digite seu perfil: ");
		System.out.println("1: Aluno.\n"
				+ "2: Professor.\n"
				+ "3: Funcion�rio.");
		type1 = scan.nextInt();

		switch (type1) {
		case 1:

			System.out.println("Voc� j� est� cadastrado?\n"
					+ "1. Sim.\n"
					+ "2. N�o.\n");
			type3 = scan.nextInt();

			// se ainda n�o estiver cadastrado, cria cadastro
			if (type3 == 2) {
				biblioteca.cadastroAluno();
			}

			// faz login
			System.out.println("Digite seu iD e senha: \n");
			iD = scan.nextInt();
			scan.nextLine();
			senha = scan.nextInt();
			scan.nextLine();

			// instancia��o auxiliar
			Aluno a = new Aluno();
			a = biblioteca.buscaAluno(iD, senha);

			//menu de sele��o
			System.out.println("O que voc� deseja?");
			System.out.println("1: Procurar livro.\n"
					+ "2: Verificar meu hist�rico.\n"
					+ "3: Alugar um livro.\n"
					+ "4: Devolver um livro.\n"
					+ "Pressione '0' para sair.");
			type2 = scan.nextInt();

			while (type2 != 0) {
				switch (type2) {
				case 1:
					System.out.println("Digite o nome do livro a ser procurado. \n");
					scan.nextLine();
					titulo = scan.nextLine();
					biblioteca.buscaLivro(titulo);
					break;
				case 2:
					System.out.println(a.solicitaHistorico(iD, senha));
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
				default:
					return;
				}
			}
			break;
		case 2:

			System.out.println("Voc� j� est� cadastrado?\n"
					+ "1. Sim.\n"
					+ "2. N�o.\n");
			type3 = scan.nextInt();

			// se ainda n�o estiver cadastrado, cria cadastro
			if (type3 == 2) {
				biblioteca.cadastroProfessor();
			}

			// faz login
			System.out.println("Digite seu iD e senha: \n");
			iD = scan.nextInt();
			scan.nextLine();
			senha = scan.nextInt();

			// instancia��o auxiliar
			Professor p = new Professor();
			p = biblioteca.buscaProfessor(iD, senha);

			// menu de sele��o
			System.out.println("O que voc� deseja?");
			System.out.println("1: Procurar livro.\n"
					+ "2: Verificar meu hist�rico.\n"
					+ "3: Alugar um livro.\n"
					+ "4: Devolver um livro.\n"
					+ "Pressione '0' para sair.");
			type2 = scan.nextInt();
			while (type2 != 0) {
				switch (type2) {
				case 1:
					System.out.println("Digite o nome do livro a ser procurado.\n");
					scan.nextLine();
					titulo = scan.nextLine();
					biblioteca.buscaLivro(titulo);
					break;
				case 2:
					System.out.println(p.solicitaHistorico(iD, senha));
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
				default:
					return;
				}
			}
			break;
		case 3:

			System.out.println("Voc� j� est� cadastrado?\n"
					+ "1. Sim.\n"
					+ "2. N�o.\n");
			type3 = scan.nextInt();
			// se ainda n�o estiver cadastrado, cria cadastro
			if (type3 == 2) {
				biblioteca.cadastroTA();
			}

			// faz login
			System.out.println("Digite seu iD e senha: \n");
			iD = scan.nextInt();
			scan.nextLine();
			senha = scan.nextInt();

			// instancia��o auxiliar
			Bibliotecario b = new Bibliotecario();
			b = biblioteca.buscaTA(iD, senha);

			// menu de sele��o
			System.out.println("O que voc� deseja?");
			System.out.println("1: Procurar livro.\n"
					+ "2: Cadastrar livro.\n"
					+ "3: Remover livro.\n"
					+ "Pressione '0' para sair.");
			type2 = scan.nextInt();
			while (type2 != 0) {
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
			}
			break;
		default:
			return;
		}
		scan.close();
	}
}

