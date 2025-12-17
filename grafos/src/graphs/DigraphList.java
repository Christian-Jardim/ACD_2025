package graphs;
import java.util.*;
import graphs.Color;

public class DigraphList implements Graph, Digraph {
    private final int V;
    private final List<List<Edge>> adj;    
    private List<VertexAttributes> atribs;
    private int time; // Contador de tempo para DFS
    static final Integer NIL = -1;

    public DigraphList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        // Inicialização dos atributos
        atribs = new ArrayList<>();
        for (int v = 0; v < V; v++)
            atribs.add(new VertexAttributes());
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        adj.get(v).add(new Edge(v, w, weight));
    }

    @Override
    public int V() { return V; }

    @Override
    public int E() { return edges().size(); }

    @Override
    public List<Edge> adj(int v) { return adj.get(v); }

    @Override
    public List<Edge> edges() {
        List<Edge> all = new ArrayList<>();
        for (List<Edge> list : adj) all.addAll(list);
        return all;
    }

	@Override
    public void BFS(int s) {
        // Inicialização
        for (VertexAttributes a : atribs) {
            a.setColor(Color.WHITE);
            a.setD(Integer.MAX_VALUE); 
            a.setPred(NIL);
        }

        atribs.get(s).setColor(Color.GRAY);
        atribs.get(s).setD(0);
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);

        // Algoritmo BFS
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (Edge e : adj(u)) { 
                int v = e.w; 
                if (atribs.get(v).getColor() == Color.WHITE) {
                    atribs.get(v).setColor(Color.GRAY);
                    atribs.get(v).setD(atribs.get(u).getD() + 1);
                    atribs.get(v).setPred(u);
                    Q.add(v);
                }
            }
            atribs.get(u).setColor(Color.BLACK);
        }
    }

    @Override
    public void DFS() {
        // Inicialização
        for (VertexAttributes a : atribs) {
            a.setColor(Color.WHITE);
            a.setPred(NIL);
            a.setD(0);
            a.setF(0);
        }
        time = 0; // Inicializa o tempo

        // Percorre todos os vértices (para grafos desconexos)
        for (int u = 0; u < V; u++) {
            if (atribs.get(u).getColor() == Color.WHITE) {
                DFS_VISIT(u);
            }
        }
    }

    private void DFS_VISIT(int u) {
        time += 1;
        VertexAttributes uAtrib = atribs.get(u);
        uAtrib.setD(time);
        uAtrib.setColor(Color.GRAY);

        for (Edge e : adj(u)) { 
            int v = e.w; 
            if (atribs.get(v).getColor() == Color.WHITE) {
                atribs.get(v).setPred(u);
                DFS_VISIT(v);
            }
        }

        uAtrib.setColor(Color.BLACK);
        time += 1;
        uAtrib.setF(time);
    }
    
    // Atualiza o método StatusAtribs() para retornar os atributos reais
    @Override
    public String StatusAtribs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            // Imprime 1-based para o usuário
            sb.append(String.format(" Vértice %d: %s\n", i + 1, atribs.get(i).toString())); 
        }
        return sb.toString();
    }
    
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int v = 0; v < V; v++) {
			sb.append(v + 1).append(": ");
			for (Edge edge : adj.get(v)) {
				sb.append(edge).append(" ");
        }
        sb.append("\n");
    }
	return sb.toString();
	}
}
