package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

	// MAP<_NomeDoVertice_, MAP<_VerticeDestino_, _Peso_>>
	private Map<Integer, Map<Integer, Integer>> vertices;
	
	public Grafo() {
		vertices = new HashMap<>();
	}
	
	public void addVertice(Integer nomeVertice, Map<Integer, Integer> arestas) {
		vertices.put(nomeVertice, arestas);
	}
	
	public Map<Integer, Map<Integer, Integer>> getVertices() {
		return vertices;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> menorCaminho(Integer verticeInicial, Integer verticeFinal) {
		Map<Integer, Integer> proximo = new HashMap<>();
		final Map<Integer, Integer> distancias = new HashMap<>();
		List<Integer> nodes = new ArrayList<>();
		
		List<Integer> path = null;
		
		for (Map.Entry<Integer, Map<Integer, Integer>> vertice : vertices.entrySet()) {
			if (vertice.getKey().equals(verticeInicial)) {
				distancias.put(vertice.getKey(), 0);
			} else {
				distancias.put(vertice.getKey(), Integer.MAX_VALUE);
			}
			
			if (!nodes.contains(vertice.getKey())) {
				nodes.add(vertice.getKey());
			}
			
			for (Map.Entry<Integer, Integer> vizinho : vertice.getValue().entrySet()) {
				if (!distancias.containsKey(vizinho.getKey())) {
					distancias.put(vizinho.getKey(), Integer.MAX_VALUE);
				}
				if (!nodes.contains(vizinho.getKey())) {
					nodes.add(vizinho.getKey());
				}
			}
		}
		
		while (!nodes.isEmpty()) {
			// Ordena os nodos com base nos menores caminhos
			Collections.sort(nodes, new Comparator() {

				@Override
				public int compare(Object o1, Object o2) {
					if (o1 instanceof Integer && o2 instanceof Integer) {
						Integer index1 = (Integer) o1;
						Integer index2 = (Integer) o2;
						
						return distancias.get(index1).compareTo(distancias.get(index2));
					}
					
					return 0;
				}
			
			});
			
			Integer menor = nodes.remove(0);
			
			if (menor.equals(verticeFinal)) {
				path = new ArrayList<>();
				while (proximo.containsKey(menor)) {
					path.add(menor);
					menor = proximo.get(menor);
				}
				if (menor.equals(verticeInicial))
				{
					path.add(menor);
				}
				break;
			}
			
			if (distancias.get(menor).equals(Integer.MAX_VALUE)) {
				break;
			}
			
			if (vertices.get(menor) != null) {
				for (Map.Entry<Integer, Integer> vizinho : vertices.get(menor).entrySet()) {
					Integer alt = distancias.get(menor) + vizinho.getValue();
					if (distancias.get(vizinho.getKey()) != null && alt < distancias.get(vizinho.getKey())) {
						distancias.put(vizinho.getKey(), alt);
						proximo.put(vizinho.getKey(), menor);
					}
				}
			}
		}
		Collections.sort(path);
		return path;
	}
	
}