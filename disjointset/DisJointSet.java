package disjointset;

public interface DisJointSet {
    
    public void connect(int x  , int y);

    public boolean isConnected(int x , int y);
}
