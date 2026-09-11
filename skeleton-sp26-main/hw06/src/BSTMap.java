
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<k extends Comparable<k>,v> implements Map61B<k,v> , Iterable<k>{

    private class BSTNode<k , v>{
        private k key;
        private v value;
        private BSTNode right;
        private BSTNode left;

        public BSTNode(k k , v v , BSTNode lt , BSTNode rt){
            key = k;
            value = v;
            right = rt;
            left = lt;
        }
    }

    private class BSTMapIterator<k> implements Iterator<k>{

        ArrayList<k> keys;
        int wizpos;

        public BSTMapIterator(){
            keys = new ArrayList<>();
            wizpos =0;
            preordersearch(keys, root,0);
        }

        public void preordersearch(ArrayList keys , BSTNode n , int i){
            if(n == null){return;}
            ((ArrayList<K>) keys).add(i ,(K) n.key);
            preordersearch(keys, n.left, i+1);
            preordersearch(keys, n.right, i+1);
        }
        public boolean hasNext(){
           if(wizpos < keys.size()){
            return true;
           }
           return false;
        }

        public k next() {
            k key = keys.get(wizpos);
            wizpos++;
            return key;
        }
    }

    private BSTNode root;
    private int size;

    public BSTMap(){
        root = null; 
        size = 0;
    }
    
    @Override
    public Iterator<k> iterator() {
       return (Iterator<k>) new BSTMapIterator();
    }

    @Override
    public void put(k key, v value) {
        if(size == 0){
           BSTNode n = new BSTNode(key , value , null , null);
           root = n;
           size++; 
        }
        else{
            BSTNode n = root;
            BSTNode parent = n;
            while(n !=null){
                parent = n;
                int cmp = key.compareTo((k) n.key);
                if(cmp == 0){n.value = value; return;}
                if(cmp < 0){
                    n = n.left;
                }
                else{
                    n = n.right;
                }
            }

            if(key.compareTo((k) parent.key) < 0){
                parent.left = new BSTNode<k,v>(key, value, null, null);
            }
            else{
                parent.right = new BSTNode<k ,v>(key , value , null , null);
            }
            size++;

        }

    }

    public BSTNode getNode(k key){
        BSTNode n = root;
        while(n != null){
            int cmp = key.compareTo((k) n.key);
            if(cmp == 0){
                return n;
            }
            if(cmp < 0){
                n = n.left;
            }
            else{
                n = n.right;
            } 
        }
        return null;
    }

    @Override
    public v get(k key) {
        BSTNode target = getNode(key);
        if(target == null){return null;}
        return (v) target.value;
    }

    @Override
    public boolean containsKey(k key) {
       BSTNode target = getNode(key);
       if(target != null){
        return true;
       }
       return false;
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public void clear() {
        root = null;
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
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }
}
