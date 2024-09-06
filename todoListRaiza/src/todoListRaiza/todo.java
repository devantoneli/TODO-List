package todoListRaiza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class todo {
	 
	 public void tarefas(String filtro) {
		 switch(filtro) {
		 case "prioridade":{
			 try (BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"))) {
				 	List<String> linhas = new ArrayList<>();
		            String linha;

	                while ((linha = reader.readLine()) != null) {
	                    linhas.add(linha);
	                }
	             	int i = 0;
	                for (int h = 1; h <= 5; h++) {
	                	i = 0;
			            for (String lin: linhas) {
			            	i++;
			                if (lin.contains(" Prioridade:"+h)) {
			                    for (int j = i-6; j <= i+1; j++) {
			                    	System.out.println(linhas.get(j));
			                    }
			                }
			            }
			            
	                }
		            
		        } catch (IOException e) {
		            System.out.println("Ocorreu um erro ao ler as tarefas.");
		            e.printStackTrace();
		        }
			 break;
		 }case "categoria": {
			 try (BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"))) {
				  List<String> linhas = new ArrayList<>();
				    Set<String> categoriasLidas = new HashSet<>();
				    String linha;

				    while ((linha = reader.readLine()) != null) {
				        linhas.add(linha);
				    }

				    for (int i = 0; i < linhas.size(); i++) {
				        String lin = linhas.get(i);

				        if (lin.contains(" Categoria:")) {
				            String[] partes = lin.split(":");
				            String categoria = partes[1].trim();

				            if (!categoriasLidas.contains(categoria)) {
				                categoriasLidas.add(categoria);

				                for (int j = 0; j < linhas.size(); j++) {
				                    if (linhas.get(j).contains(" Categoria:" + categoria)) {

				                        for (int k = j - 6; k <= j + 1; k++) {
				                            if (k >= 0 && k < linhas.size()) { 
				                                System.out.println(linhas.get(k));
				                            }
				                        }
				                    }
				                }
				            }
				        }
				    }
			 	} catch (IOException e) {
		            System.out.println("Ocorreu um erro ao ler as tarefas.");
		            e.printStackTrace();
		        }
			 break;
			 }case "status": {
				 try (BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"))) {
					 List<String> linhas = new ArrayList<>();
					    Set<String> statusLido = new HashSet<>();
					    String linha;

					    while ((linha = reader.readLine()) != null) {
					        linhas.add(linha);
					    }

					    for (int i = 0; i < linhas.size(); i++) {
					        String lin = linhas.get(i);

					        if (lin.contains(" Status:")) {
					            String[] partes = lin.split(":");
					            String stat = partes[1].trim();

					            if (!statusLido.contains(stat)) {
					                statusLido.add(stat);
					                System.out.println("++++++++ " + stat.toUpperCase() + " ++++++++");
					                
					                for (int j = 0; j < linhas.size(); j++) {
					                    if (linhas.get(j).contains(" Status:" + stat)) {
					                        for (int k = j - 6; k <= j+1; k++) {
					                            if (k >= 0 && k < linhas.size()) { 
					                                System.out.println(linhas.get(k));
					                            }
					                        }
					                    }
					                }
					            }
					        }
					    }
			 }
			 catch (IOException e) {
		            System.out.println("Ocorreu um erro ao ler as tarefas.");
		            e.printStackTrace();
		        }
			 break;
		 }
		 default: {
			 try (BufferedReader reader = new BufferedReader(new FileReader("tarefas.txt"))) {
		            String linha;
		            while ((linha = reader.readLine()) != null) {
		                System.out.println(linha);
		            }
		        } catch (IOException e) {
		            System.out.println("Ocorreu um erro ao ler as tarefas.");
		            e.printStackTrace();
		        }
			 break;
		 }
		 }
		
	 }
}
