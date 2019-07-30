import java.util.Scanner;
import usuario.*;
import biblioteca.*;

public class Principal {
	
	public static void main (String[] args) {
		int type1, type2 = 10;
		String titulo;
		Biblioteca biblioteca = new Biblioteca ();
		
		Scanner scan = new Scanner(System.in);
		
		
		
		
		System.out.println("----------	Bem vindo!	----------");
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
							+ "4: Devolver um livro.\n"
							+ "5: Fazer cadastro.\n"
							+ "Pressione '0' para sair.");
					type2 = scan.nextInt();
					switch (type2) {
						case 1:
							System.out.println("Digite o nome do livro a ser procurado. \n");
							scan.nextLine();
							titulo = scan.nextLine();
							Biblioteca.buscaLivro(titulo);
							break;
						case 2:
							System.out.println("Digite o seu iD e senha.\n");
							scan.nextLine();
							int iD = scan.nextInt();
							scan.nextLine();
							int senha = scan.nextInt();
							Aluno.buscaHistoricoAluno(iD,senha);
							break;
						case 3:
							System.out.println("Digite o nome do livro a ser alugado.\n");
							scan.nextLine();
							titulo = scan.nextLine();
							Aluno.realizaEmprestimo(titulo);
							break;
						case 4:
							System.out.println("Digite o nome do livro a ser devolvido.\n");
							scan.nextLine();
							titulo = scan.nextLine();
							Aluno.realizaDevolucao(titulo);
							break;
						case 5:
							Aluno.cadastraAluno();
							break;
					}
			
				case 2:
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
							Biblioteca.buscaLivro(titulo);
							break;
						case 2:
							System.out.println("Digite o seu iD e senha.\n");
							scan.nextLine();
							int iD = scan.nextInt();
							scan.nextLine();
							int senha = scan.nextInt();
							Professor.buscaHistoricoProf(iD,senha);
							break;
						case 3:
							System.out.println("Digite o nome do livro a ser alugado.\n");
							scan.nextLine();
							titulo = scan.nextLine();
							Professor.realizaEmprestimo(titulo);
							break;
						case 4:
							System.out.println("Digite o nome do livro a ser devolvido.\n");
							scan.nextLine();
							titulo = scan.nextLine();
							Professor.realizaDevolucao(titulo);
							break;
						case 5:
							Professor.cadastraProfessor();
							break;
						
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
							System.out.println("Digite o nome do livro a ser procurado.\n");
							scan.nextLine();
							titulo = scan.nextLine();
							Biblioteca.buscaLivro(titulo);
							break;
						case 2:
							Bibliotecario.cadastraLivro();
							break;
						case 3:
							System.out.println("Digite o nome do livro a ser procurado.\n");
							scan.nextLine();
							titulo = scan.nextLine();
							Bibliotecario.removeLivro(titulo);
							break;
					}
				}
			}	
		scan.close();
	}
}
