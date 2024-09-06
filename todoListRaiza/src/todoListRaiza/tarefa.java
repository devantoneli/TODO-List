package todoListRaiza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class tarefa {
	public String nome;
	public String desc;
	public String data;
	public int prioridade;
	public String categ;
	public String status;
	
	
	public void salvar() {
		String tarefa    = this.nome;
		String descricao = this.desc;
		String data      = this.data;
		int prioridade   = this.prioridade;
		String categoria = this.categ;
		String status    = this.status;
		
        try (FileWriter writer = new FileWriter("tarefas.txt", true)) {
        	String id = (UUID.randomUUID().toString()).substring(0, 8);
            writer.write("ID:"+ id + "\n Nome:" + tarefa + "\n Descricao:" + descricao + "\n Data:" + data + "\n Prioridade:"+ prioridade + "\n Categoria:"+ categoria + "\n Status:"+ status + "\n -------------- \n");
            System.out.println("Tarefa salva com sucesso!");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar a tarefa.");
            e.printStackTrace();
        }
    }
	
	public void excluir(String id) {
		String arquivo = "tarefas.txt";
        String idParaExcluir = id;

        try {
            List<String> linhas = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    linhas.add(linha);
                }
            }
            List<String> novasLinhas = new ArrayList<>();
            boolean excluindo = false;

            for (String linha : linhas) {
                if (linha.contains("ID:" + idParaExcluir)) {
                    excluindo = true;
                    System.out.println("Excluindo. " + linha);
                } else if (linha.equals(" -------------- ")) {
                    if (excluindo) {
                        excluindo = false;
                        continue;
                    }
                }
                if (!excluindo) {
                    novasLinhas.add(linha);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : novasLinhas) {
                    writer.write(linha);
                    writer.newLine();
                }
            }

            System.out.println("Tarefa excluída com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
