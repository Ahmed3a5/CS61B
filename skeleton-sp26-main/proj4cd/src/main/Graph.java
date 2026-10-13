package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    public int VNum;
    public int ENum;
    public Map<Integer , ArrayList<Integer>> adjv;    // adjucent list for all vertex this represent a list of all edges from this vertex 
                                        // the index of the array repersent the ID of the word in the file

    public Graph(int v){    
        VNum = v;
        ENum = 0;
        adjv = new HashMap<>();

        for(int i = 0 ; i < VNum ; i++){
            adjv.put(i , new ArrayList<>());
        }
    }

    public void addEdge(int v1 , int v2){
        if(!isEdgeTo(v1, v2) ){
            adjv.get(v1).add(v2);   // direction of the grapgh from the v1 to v2 
            ENum++;
        }
    }

    public ArrayList<Integer> adj(int v){
        return adjv.get(v);    // retrun the list of the hyponems of the vertex ID 
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

    public ArrayList<Integer> DfsHelper(int v ,ArrayList<Integer> allhyponemsvertces , Set<Integer> marked){
        marked.add(v);
        allhyponemsvertces.add(v);
        if(adj(v).isEmpty()){
            return allhyponemsvertces;
        }
        ArrayList<Integer> adjcev = this.adj(v);
        for(int vertex : adjcev){
            if(!marked.contains(vertex)){
                allhyponemsvertces = DfsHelper(vertex, allhyponemsvertces , marked);
            }
            
        }
        return allhyponemsvertces;
    }

    public ArrayList<Integer> DFS(int v){
        ArrayList<Integer> allhyponemsvertces = new ArrayList<>();
        Set<Integer> marked = new HashSet<>();
        allhyponemsvertces = DfsHelper(v, allhyponemsvertces , marked);
        return allhyponemsvertces;
    }

    
}
