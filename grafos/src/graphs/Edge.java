package graphs;

public class Edge {
    //deveriam ser privados
    public int v, w;//vertices
    public double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public String toString() {
        return String.format(" (%d - %d, weight: %.2f)", v + 1, w + 1, weight);
    }
}
