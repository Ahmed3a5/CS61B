package disjointset;

public class quikfindDJS implements DisJointSet {

    private int id[];

    public quikfindDJS(int N){
        id = new int[N];
        for(int i = 0 ; i <= N; i++ ){
            id[i] = i;
        }
    }

    @Override
    public void connect(int x , int y) {
       int xid = id[x];
       int yid = id[y];

       for(int i = 0 ; i < id.length ; i++){
            if(id[i] == xid){
                id[i] = yid;
            }
        }
    }

    @Override
    public boolean isConnected(int x , int y) {
        return (id[x] == id[y]);
    }
    
}
