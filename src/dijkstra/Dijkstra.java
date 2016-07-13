package dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {
		Grafo g = new Grafo();
		Scanner ler = new Scanner(System.in);
		Integer numeroVertice;
		Integer verticeInicial = null;
		Integer verticeFinal = null;
		
		System.out.println("Digite o nome do arquivo de texto");
		String nome = ler.nextLine();
		
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader br = new BufferedReader(arq);
			
			numeroVertice = Integer.valueOf(br.readLine());
			verticeInicial = Integer.valueOf(br.readLine());
			verticeFinal = Integer.valueOf(br.readLine());
			
			while(br.ready()) {
				String linha = br.readLine();
				Map<Integer, Integer> edges;
				
				String array[] = new String[3];
				array = linha.split(" ");
				
				if(g.getVertices().containsKey(Integer.valueOf(array[0]))) {
					edges = g.getVertices().get(Integer.valueOf(array[0]));
				} else {
					edges = new HashMap<>();
				}
				
				edges.put(Integer.valueOf(array[1]), Integer.valueOf(array[2]));
				
				g.addVertice(Integer.valueOf(array[0]), edges);
			}
			br.close();
			
			// Chama o método para calcular o menor caminho e imprime o resultado
			List<Integer> listaCaminhos = g.menorCaminho(verticeInicial, verticeFinal);
			int count = 0;
			for (Integer caminho : listaCaminhos) {
				System.out.print(caminho);
				if (count < listaCaminhos.size() - 1) {
					System.out.print(" -> ");
				}
				count++;
			}
			System.out.println();
		} catch (IOException e) {
			System.err.println("Ocorreu erro ao tentar abrir o arquivo");
		}
	}

}