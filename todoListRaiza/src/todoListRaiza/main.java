package todoListRaiza;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		String comando;
		
		System.out.println("Bem vindo(a) ao TODO List em Java de Raiza Antoneli!");
		System.out.println("Para listar os comandos possíveis, digite -ajuda.");
		System.out.print("Comece digitando um comando: ");
		Scanner ler = new Scanner(System.in);
		comando = ler.nextLine();
		
		tarefa trfa = new tarefa();
		todo tod = new todo();
		do {
			switch(comando) {
			case "nova-tarefa": {
				System.out.print("Nome: ");
				trfa.nome = ler.nextLine();
				System.out.print("Descrição: ");
				trfa.desc = ler.nextLine();
				System.out.print("Data (dd/mm/aa): ");
				trfa.data = ler.nextLine();
				System.out.print("Prioridade: ");
				trfa.prioridade = ler.nextInt();
				ler.nextLine();
				System.out.print("Categoria: ");
				trfa.categ = ler.nextLine();
				System.out.print("Status: ");
				String stt = ler.nextLine();
				while (!stt.equals("To do") && !stt.equals("Doing") && !stt.equals("Done")){
					System.out.print("Status inccorreto! Status: ");
					stt = ler.nextLine();
				}
				trfa.status = stt;
				
				trfa.salvar();
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "tarefas": {
				tod.tarefas("nulo");
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "-ajuda": {
				System.out.println("nova-tarefa (cria uma nova tarefa) # excluir-tarefa [id da tarefa] (exclui uma tarefa pelo seu identificador) # tarefas (lista tarefas por ordem de adição) # tarefas prioridade (lista tarefas por prioridade) # tarefas categoria (lista tarefas por categoria) # tarefas status (lista tarefas por status)");
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "tarefas prioridade": {
				tod.tarefas("prioridade");
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "tarefas categoria": {
				tod.tarefas("categoria");
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "tarefas status": {
				tod.tarefas("status");
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "excluir-tarefa": {
				System.out.print("Digite o ID da tarefa para excluir: ");
				String idTrfa = ler.nextLine();
				trfa.excluir(idTrfa);
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}case "para": {
				comando = "para";
				break;
			}
			default: {
				System.out.println("Comando incorreto. Tente novamente.");
				System.out.print("Comando: ");
				comando = ler.nextLine();
				break;
			}
			}
		}while (comando != "para");

		ler.close();
	}

}
