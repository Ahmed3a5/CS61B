package graphs;

import java.util.ArrayList;

public class graph {
    private int V ;
    private int E ;
    private ArrayList<Integer>[] adj;

    public graph(int v){
        V = v;
        E = 0;

        adj = new ArrayList[v];

        for(int i = 0 ; i < v ; i++){
            adj[i] = new ArrayList<>(); 
        }
    }


    public void addEdge(int u , int v){
        adj[u].add(v);
        adj[v].add(u);  // if it is a directed graph we will remove one of this lines acoording to the direction of edge 
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public void printgraph(){
        for(int v = 0 ; v < this.V ; v++){
            for(int e : adj(v)){
                System.out.println(v + "-->" + e);
            }
        }
    }

    public int v(){
        return this.V;
    }

    public int degree(int v){
        int degree = 0;

        for(int x : adj(v)){
            degree +=1;
        }
        return degree;
    }
}
