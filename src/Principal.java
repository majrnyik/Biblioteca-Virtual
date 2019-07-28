import java.util.Scanner;
import usuario.*;
import biblioteca.*;
public class Principal {
	
	public static void main (String[] args) {
		int type1, type2 = 10;
		String titulo;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bem vindo!");
		System.out.println("Digite seu perfil: ");
		System.out.println("1: Professor.\n"
				+ "2: Aluno.\n"
				+ "3: Funcionário.");

		while (type2 != 0) {
			type1 = scan.nextInt();
			switch (type1) {
				case 1:
					System.out.println("O que você deseja?");
					System.out.println("1: Procurar livro.\n"
							+ "2: Verificar meu histórico.\n"
							+ "3: Alugar um livro.\n"
							+ "4: Devolver um livro."
							+ "5: Fazer cadastro.\n"
							+ "Pressione '0' para sair.");
					type2 = scan.nextInt();
					switch (type2) {
						case 1:
							System.out.println("Digite o nome do livro a ser procurado.");
							titulo = scan.nextLine();
							Biblioteca.buscaLivro(titulo);
						case 2:
							System.out.println("Digite o seu iD e senha.");
								int iD = scan.nextInt(); int senha = scan.nextInt();
							Biblioteca.buscaHistoricoAluno(iD,senha);
						case 3:
							System.out.println("Digite o nome do livro a ser alugado.");
							titulo = scan.nextLine();
							Aluno.realizaEmprestimo(titulo);
						case 4:
							System.out.println("Digite o nome do livro a ser devolvido.");
							titulo = scan.nextLine();
							Aluno.realizaDevolucao(titulo);
						case 5:
							Biblioteca.cadastraAluno();		
					}
			
				case 2:
					System.out.println("O que você deseja?");
					System.out.println("1: Procurar livro.\n"
							+ "2: Verificar meu histórico.\n"
							+ "3: Alugar um livro.\n"
							+ "4: Devolver um livro."
							+ "5: Fazer cadastro.\n"
							+ "Pressione '0' para sair.");
					type2 = scan.nextInt();
					switch (type2) {
						case 1:
							System.out.println("Digite o nome do livro a ser procurado.");
							titulo = scan.nextLine();
							Biblioteca.buscaLivro(titulo);
						case 2:
							System.out.println("Digite o seu iD e senha.");
							int iD = scan.nextInt(); int senha = scan.nextInt();
							Biblioteca.buscaHistoricoProf(iD,senha);
						case 3:
							System.out.println("Digite o nome do livro a ser alugado.");
							titulo = scan.nextLine();
							Professor.realizaEmprestimo(titulo);
						case 4:
							System.out.println("Digite o nome do livro a ser devolvido.");
							titulo = scan.nextLine();
							Professor.realizaDevolucao(titulo);
						case 5:
							Biblioteca.cadastraProfessor();
						
					}
				case 3:
					System.out.println("O que você deseja?");
					System.out.println("1: Procurar livro.\n"
							+ "2: Cadastrar livro.\n"
							+ "3: Remover livro.\n"
							+ "Pressione '0' para sair.");
					type2 = scan.nextInt();
					switch (type2) {
						case 1:
							System.out.println("Digite o nome do livro a ser procurado.");
							titulo = scan.nextLine();
							Biblioteca.buscaLivro(titulo);
						case 2:
							Biblioteca.cadastraLivro();
						case 3:
							System.out.println("Digite o nome do livro a ser procurado.");
							titulo = scan.nextLine();
							Biblioteca.removeLivro(titulo);
					}
				}
			}	
		scan.close();
	}
}
