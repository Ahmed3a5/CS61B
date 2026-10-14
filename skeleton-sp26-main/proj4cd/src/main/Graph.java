package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import edu.princeton.cs.algs4.In;


public class Graph {
    private int VNum;
    private Map<Integer , ArrayList<Integer>> adjv = new HashMap<>();;    // adjucent list for all vertex this represent a list of all edges from this vertex 
                                                      // the index of the array repersent the ID of the word in the file

    public Graph(In File){ 
        while(!File.isEmpty()){
            String nextline = File.readLine();
            String[] linenums = nextline.split(",");
            int v = Integer.parseInt(linenums[0]);
            if(!adjv.containsKey(v)){adjv.put(v , new ArrayList<>());}
            for(int i = 1 ; i < linenums.length ; i++){
                int v2 = Integer.parseInt(linenums[i]);
                if(!adjv.containsKey(v2)){
                    adjv.put(v2 , new ArrayList<>());
                }
                adjv.get(v).add(v2);
            }
        }
        VNum = adjv.size();
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
