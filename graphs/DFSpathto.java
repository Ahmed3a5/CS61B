package graphs;

import java.util.Stack;

public class DFSpathto {
    private int[] edgeTo;
    private boolean[] marked;
    private int S;

    public DFSpathto(graph G , int s){
        S = s;
        edgeTo = new int[G.v()];
        marked = new boolean[G.v()];
        DFS(G , s);
    }

    public void DFS(graph G , int v){
        marked[v] = true;

        for(int n : G.adj(v)){
            if(!marked[n]){
                edgeTo[n] = v;
                DFS(G, n);
            }
        }
    }

    public boolean haspath(int v){
        return marked[v];
    }

    public Iterable<Integer> PathTo(graph G , int v){
        if(!haspath(v)){return null;}
        Stack<Integer> path = new Stack<>();

        int x = v;
        while( x != S){
            path.push(x);
            x = edgeTo[x];
        }
        path.push(S);
        return path;
    }
}
