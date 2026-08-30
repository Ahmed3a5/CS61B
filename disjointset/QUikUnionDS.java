package disjointset;

public class QUikUnionDS implements DisJointSet{

    private int[] parent;

    public QUikUnionDS(int N){
        parent = new int[N];

        for(int i = 0 ; i < parent.length  ; i++){
            parent[i] = i;
        }
    }

    private int find(int x){
        while(parent[x] >= 0){
            x = parent[x];
        }
        return x;
    }
    @Override
    public void connect(int x, int y) {
        int px = find(x);
        int py = find(y);

        parent[px] = py;
    }



    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
}
