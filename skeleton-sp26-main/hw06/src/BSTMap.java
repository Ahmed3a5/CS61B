import java.util.Iterator;
import java.util.Set;

public class BSTMap<k extends Comparable<k>,v> implements Map61B<k,v> , Iterable<k>{

    private class BSTNode<k , v>{
        private k key;
        private v value;

        public BSTNode(k k , v v){
            key = k;
            value = v;
        }
    }

    private class BSTMapIterator<BSTNode> implements Iterator<BSTNode>{

        private int wizpos;

        public BSTMapIterator(){
            wizpos =0;
        }
        public boolean hasNext(){
            if(wizpos < size){
                return true;
            }
            return false;
        }

        public BSTNode next() {
            BSTNode item = (BSTNode) tree[wizpos];
            wizpos++;

            return (BSTNode)item;
        }
    }

    BSTNode[] tree;
    int size;

    public BSTMap(){
        tree = new BSTNode[4]; 
        size = 0;
    }
    
    @Override
    public Iterator<k> iterator() {
       return (Iterator<k>) new BSTMapIterator();
    }

    @Override
    public void put(k key, v value) {
        if(size >= tree.length){
            resize(size*2);
        }
        if(containsKey(key)){
            int index = getindex(key);
            tree[index].value = value;
        }
        else{
            BSTNode n = new BSTNode(key , value);
            tree[size] = n;
            size++;
        }
        
    }

    public int getindex(k key){
        int index = -1;
        for(int i = 0 ; i <size ; i++){
            if (tree[i].key.equals(key)){index = i;}
        }
        return index;
    }

    @Override
    public v get(k key) {
        if(!containsKey(key)){return null;}
        int index = getindex(key);
        return (v) tree[index].value;
    }

    @Override
    public boolean containsKey(k key) {
       int  index = getindex(key);
       if(index == -1){return false;}
       return true;   
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public void clear() {
        tree = new BSTNode[4];
        size = 0;
    }

    @Override
    public Set<k> keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }

    @Override
    public v remove(k key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    public void resize(int capacity){
        BSTNode[] n = new BSTNode[capacity];
        for(int i = 0 ; i < size ; i ++){
           n[i] = tree[i];
        }
        tree = n;
    }
    
}
