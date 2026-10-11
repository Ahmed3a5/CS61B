package main;

import java.util.ArrayList;

public class Graph {
    public int VNum;
    public int ENum;
    public ArrayList<Integer>[] adjv;    // adjucent list for all vertex this represent a list of all edges from this vertex 
                                        // the index of the array repersent the ID of the word in the file

    public Graph(int v){    
        VNum = v;
        ENum = 0;
        adjv = new ArrayList[v];

        for(int i = 0 ; i < VNum ; i++){
            adjv[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v1 , int v2){
        if(!isEdgeTo(v1, v2) ){
            adjv[v1].add(v2);   // direction of the grapgh from the v1 to v2 
            ENum++;
        }
    }

    public ArrayList<Integer> adj(int v){
        return adjv[v];    // retrun the list of the hyponems of the vertex ID 
    }

    public boolean isEdgeTo(int v , int u){
        for( Object x : adj(v)){
            if(x.equals(u)){
                return true;
            }
        }
        return false;
    }

    public int v(){
        return this.VNum;
    } 

    public ArrayList<Integer> DfsHelper(int v ,ArrayList<Integer> allhyponemsvertces , boolean[] marked){
        marked[v] = true;
        allhyponemsvertces.add(v);
        if(adj(v).isEmpty()){
            return allhyponemsvertces;
        }
        ArrayList<Integer> adjcev = this.adj(v);
        for(int vertex : adjcev){
            if(!marked[vertex]){
                allhyponemsvertces = DfsHelper(vertex, allhyponemsvertces , marked);
            }
            
        }
        return allhyponemsvertces;
    }

    public ArrayList<Integer> DFS(int v){
        ArrayList<Integer> allhyponemsvertces = new ArrayList<>();
        boolean[] marked = new boolean[this.VNum];
        allhyponemsvertces = DfsHelper(v, allhyponemsvertces , marked);
        return allhyponemsvertces;
    }

    
}
