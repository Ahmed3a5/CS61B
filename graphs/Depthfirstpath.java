package graphs;

public class Depthfirstpath {

    private boolean[] marked;
    boolean result;
    
    public Depthfirstpath(graph G , int s , int t){
        marked = new boolean[G.v()];
        result = dfs(G , s , t);
    }

    public boolean dfs(graph G , int s , int t){
        if(s == t){return true;};
        marked[s] = true;
        for(int n : G.adj(s)){
            if(!marked[n]){
                if(dfs(G , n , t)){return true;}
            }
        }
        return false;
    }

    public boolean result(){
        return result;
    }
}
