package utils;
import graphs.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadGraph {

	public static DigraphList readGraphFromFile(String filename) {
		int vertices = 0;
		DigraphList graph = null;
		
		try (Scanner scanner = new Scanner(new File(filename))) {
			
			// 1. LÊ TODO O ARQUIVO EM UM ÚNICO LOOP
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				
				// Ignora comentários ('c') ou linhas vazias
				if (line.startsWith("c") || line.isEmpty()) continue;

				// Lê número de vértices e arestas
				if (line.startsWith("p")) {
					// Exemplo: p sp 100 1980
					String[] parts = line.split("\\s+");
                    // parts[0] = "p"
                    // parts[1] = "sp"
					vertices = Integer.parseInt(parts[2]); // Vértices (100)
                    // arestas = Integer.parseInt(parts[3]); // Arestas (1980)

                    // Inicializa o grafo imediatamente após saber o V
                    graph = new DigraphList(vertices);
                    System.out.println("Grafo inicializado. V = " + vertices);
                    
				} else if (line.startsWith("a")) {
                    // Lê arestas do grafo
					if (graph == null) {
						System.err.println("Erro: Aresta encontrada antes da definição 'p'.");
						break;
					}
					
					// Exemplo: a 64 73 66
					String[] parts = line.split("\\s+");
					// parts[0] = "a"
					int v = Integer.parseInt(parts[1]) - 1; // -1 pois DIMACS começa em 1!
					int w = Integer.parseInt(parts[2]) - 1;
					double weight = Double.parseDouble(parts[3]);
					
                    // Adiciona a aresta ao grafo
					graph.addEdge(v, w, weight);
				}
			}
			
			// Verifica se o grafo foi carregado
			if (graph != null && graph.V() > 0 && graph.edges().isEmpty()) {
                System.out.println("AVISO: Grafo com " + graph.V() + " vértices, mas 0 arestas.");
            }
            
		} catch (FileNotFoundException e) {
			System.err.println("ERRO: O arquivo " + filename + " não foi encontrado. Verifique o caminho.");
			return null;
		} catch (Exception e) {
            System.err.println("ERRO ao processar o arquivo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
		
		return graph;
	}
}
