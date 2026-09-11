import static org.junit.jupiter.api.Assumptions.abort;

import java.util.Iterator;
import java.util.Set;

public class BSTMapArraybased<k extends Comparable<k>,v> implements Map61B<k,v> , Iterable<k>{

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

    public BSTMapArraybased(){
        tree = new BSTNode[4]; 
        size = 0;
    }
    
    @Override
    public Iterator<k> iterator() {
       return (Iterator<k>) new BSTMapIterator();
    }

    @Override
    public void put(k key, v value) {
        int i = 0;
        while(i < tree.length && tree[i] !=null){
            int cmp = key.compareTo((k)tree[i].key);
            if(cmp == 0){tree[i].value = value; return;}
            else if(cmp < 0){
                i = 2*i+1;
            }
            else{
                i = 2*i +2;
            }

            if(i >= tree.length){
                resize(tree.length*2 +i);
            }
        }

        tree[i] = new BSTNode(key , value);
        size++; 
        
    }

    public int getindex(k key){
        int i = 0;
        while(i < tree.length && tree[i] !=null){
            int cmp = key.compareTo((k)tree[i].key);
            if(cmp == 0){return i;}
            else if(cmp < 0){i = i*2 +1;}
            else{i = i*2+2;};
        }
        if(i == 0){if(key.equals(tree[0].key)){return 0;}}
        return -1;
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
        for(int i = 0 ; i < tree.length ; i++){
           n[i] = tree[i];
        }
        tree = n;
    }
    
}
