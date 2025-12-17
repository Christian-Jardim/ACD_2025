package graphs;

public class VertexAttributes {

    private Color color; //cor do vértice
    private int pred;    //predecessor do vértice
    private int d;       //tempo de descoberta ou distância
    private int f;       //tempo de término (para DFS)

    public VertexAttributes() {
        this.color = Color.WHITE;
        this.pred = -1;//NIL
        this.d = Integer.MAX_VALUE;//INF 0
        this.f = 0;
    }


    public int getPred(){
        return pred;
    }

    public int getD(){
        return d;
    }

    public int getF(){
        return f;
    }

    public Color getColor(){
        return color;
    }


    public void setPred(int Pred){
        pred = Pred;
    }

    public void setD(int D){
        d = D;
    }

    public void setF(int F){
        f = F;
    }
    
    public void setColor(Color Color){
        color = Color;
    }


    @Override
    public String toString() {
        return String.format("Color: %s, Pred: %d, d: %d, f: %d", color, pred, d, f);
    }

}
