package utils;
import graphs.*;
import algorithms.*;
import java.util.*;

public class GraphTimes {
	public static void timeGraphBFS(String graphType, String sampleChosen, Graph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;
        int vertexStart=0;
        Scanner input = new Scanner(System.in);
        
        System.out.print(" Escolha o vértice de início: ");
        vertexStart = input.nextInt();

        System.out.print("\n Algoritmo: Busca em Largura (BFS)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            graph.BFS(vertexStart);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "BFS, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
        }
	}
	
	public static void timeGraphDFS(String graphType, String sampleChosen, Graph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;

        System.out.print("\n Algoritmo: Busca em Profundidade (DFS)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            graph.DFS();
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "DFS, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
        }
	}
	
	public static void timeDigraphBFS(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;
        int vertexStart=0;
        Scanner input = new Scanner(System.in);
        
        System.out.print(" Escolha o vértice de início: ");
        vertexStart = input.nextInt();

        System.out.print("\n Algoritmo: Busca em Largura (BFS)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            graph.BFS(vertexStart);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "BFS, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
        }
	}
	
	public static void timeDigraphDFS(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;

        System.out.print("\n Algoritmo: Busca em Profundidade (DFS)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            graph.DFS();
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "DFS, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
        }
	}
	
	public static void timeOT(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;

        System.out.print("\n Algoritmo: Ordenação Topológica (OT)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        TopologicalSort tGraph = new TopologicalSort(graph);
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            tGraph.sort();
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "OT, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            System.out.println(" Ordem resultante: " + tGraph.ordenation());
        }
	}
	
	public static void timeK(String graphType, String sampleChosen, Graph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;

        System.out.print("\n Algoritmo: Árvore Geradora Mínima (Kruskal)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        Kruskal kGraph = new Kruskal();
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            kGraph.findMST(graph);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "Kruskal, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            System.out.println(" Peso da MST: " + kGraph.minimumST());
        }
	}
	
	public static void timeP(String graphType, String sampleChosen, Graph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;

        System.out.print("\n Algoritmo: Árvore Geradora Mínima (Prim)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        Prim pGraph = new Prim();
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            pGraph.findMST(graph);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "Prim, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            System.out.println(" Peso da MST: " + pGraph.minimumST());
        }
	}
	
	public static void timeBF(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;
        int vertexStart=0;
        Scanner input = new Scanner(System.in);
        
        System.out.print(" Escolha o vértice de início: ");
        vertexStart = input.nextInt();

        System.out.print("\n Algoritmo: Caminho Mínimo De Origem Única Para Todos Os Vértices (Bellman-Ford)");
        System.out.printf("\n Grafo com %s de Adjacências:\n",graphType);
        System.out.println(graph);//toString
        
        BellmanFord bfGraph = new BellmanFord(graph);
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            bfGraph.computeShortestPaths(vertexStart);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "Bellman-Ford, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            bfGraph.printDistances(1);
        }
	}
	
	public static void timeD(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;
        int vertexStart=0;
        Scanner input = new Scanner(System.in);
        
        System.out.print(" Escolha o vértice de início: ");
        vertexStart = input.nextInt();

        System.out.print("\n Algoritmo: Caminho Mínimo De Origem Única Para Todos Os Vértices (Dijkstra)");
        System.out.printf("\n Grafo com %s de Adjacências:\n", graphType);
        System.out.println(graph);//toString
        
        Dijkstra dGraph = new Dijkstra(graph);
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            dGraph.computeShortestPaths(vertexStart);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "Dijkstra, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            dGraph.printDistances(0);
        }
	}
	
	public static void timeFW(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;

        System.out.print("\n Algoritmo: Caminho Mínimo (Floyd-Warshall)");
        System.out.printf("\n Grafo com %s de Adjacências:\n", graphType);
        System.out.println(graph);//toString
        
        FloydWarshall fwGraph = new FloydWarshall(graph);
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            fwGraph.computeShortestPaths();
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "Floyd-Warshall, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            System.out.println(" Distâncias mínimas:");
            fwGraph.printDistances();
        }
	}
	
	public static void timeFF(String graphType, String sampleChosen, Digraph graph, int repetitions, List<String> csvList) {
		final double CONVERTNS4MS = 1_000_000.0;
        double[] times = new double[repetitions];
        double sum = 0, start, end, duration;
        int vertexStart=0, vertexEnd=0;
        Scanner input = new Scanner(System.in);
        
        System.out.print(" Escolha o vértice de início: ");
        vertexStart = input.nextInt();
        
        System.out.print(" Escolha o vértice de fim: ");
        vertexEnd = input.nextInt();

        System.out.print("\n Algoritmo: Fluxo máximo em redes (Ford-Fulkerson)");
        System.out.printf("\n Grafo com %s de Adjacências:\n", graphType);
        System.out.println(graph);//toString
        
        FordFulkerson ffGraph = new FordFulkerson(graph);
        
        for (int i = 0; i < repetitions; i++) {
            start = System.nanoTime();
            ffGraph.maxFlow(vertexStart, vertexEnd);
            end = System.nanoTime();
            duration = (end - start) / CONVERTNS4MS;

            times[i] = duration;
            sum += duration;
			
			String csvLine = String.format(Locale.US, "Ford-Fulkerson, %s, %s, %d, %.6f", graphType, sampleChosen, i + 1, duration);
            csvList.add(csvLine);

            System.out.printf("\n Execução %d - %s: %.2f ms%n", i + 1, graphType, duration);
            System.out.println(" Fluxo máximo: " + ffGraph.getMaxFlow());
        }
	}
}
