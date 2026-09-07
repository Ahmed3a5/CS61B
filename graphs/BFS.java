package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    boolean [] marked;
    int[] edgTo;

    int S;
    
    public BFS(graph G , int s){
        marked = new boolean[G.v()];
        edgTo = new int[G.v()];
        S = s;

        bfs(G , s);
    }

    public void bfs(graph G , int s){
        Queue<Integer> fringe = new LinkedList<Integer>();
        marked[s] = true;
        fringe.add(s);
        while(!fringe.isEmpty()){
            int v = fringe.poll();
            for(int x : G.adj(v)){
                if(!marked[x]){
                    fringe.add(x);
                    marked[x] = true;
                    edgTo[x] = v;
                    
                }
            }
        }

    }

    public int[] edg(){
        return edgTo;
    }

    public static void main(String[] args){

        graph g  = new graph(10);

        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(1,4);
        g.addEdge(2, 5);
        g.addEdge(5,4);
        g.addEdge(4, 3);
        g.addEdge(5,6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);

        BFS bfs = new BFS(g, 0);

        for(int i : bfs.edg()){
            System.out.println(i);
        }

    }
}
