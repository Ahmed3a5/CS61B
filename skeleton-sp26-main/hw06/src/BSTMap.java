
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BSTMap<k extends Comparable<k>,v> implements Map61B<k,v> , Iterable<k>{

    private class BSTNode{
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
            inordersearch(keys, root);
        }

        public void inordersearch(ArrayList keys , BSTNode n){
            if(n == null){return;}
            inordersearch(keys, n.left);
            ((ArrayList<k>) keys).add((k) n.key);
            inordersearch(keys, n.right);
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
                parent.left = new BSTNode(key, value, null, null);
            }
            else{
                parent.right = new BSTNode(key , value , null , null);
            }
            size++;

        }

    }

    private BSTNode getNode(k key){
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

    private BSTNode getNodeparent(k key){
        BSTNode n = root;
        BSTNode parent = null;
        while(n != null){
            int cmp = key.compareTo((k) n.key);
            if(cmp == 0){
                return parent;
            }
            if(cmp < 0){
                parent = n;
                n = n.left;
            }
            else{
                parent = n;
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
        Set<k> keys = new TreeSet<>();
        for(k key : this){
            keys.add(key);
        }
        return keys;
    }

    @Override
    public v remove(k key) { 
        // the 3 cases 
        // if it has 2 childs 
        // we find the successor 
        // replace its valuse with node we need to remove 
        // then we make the parent os the successor to point to the successor right 
        // if it is a leaf we just make the pointer of the parent to be null
        // if it has a one child we assume it as in the right or the left then we change the parent pointer to point to the child of the remove
        // node then the garabage collector remove the unpointed nodes 
        
        BSTNode node = getNode(key);
        if(node == null){return null;}

        v removedv = (v)node.value;

        BSTNode parent = getNodeparent(key);

        if(node.left != null && node.right != null){
            BSTNode succ = findsuccessor(key);
            BSTNode succparent = getNodeparent((k)succ.key);
            node.key = succ.key;
            node.value = succ.value;
            if(succparent.right == succ){succparent.right = succ.right;}
            else{succparent.left = succ.right;}
        }
        else{
            if(node.left == null && node.right == null){
                if(parent == null){root = null;}
                else if(parent.right == node){parent.right = null;}
                else{parent.left = null;}
            }
            else{
                BSTNode child;
                if(node.left != null){child = node.left;}
                else{child = node.right;}

                if(parent == null){root = child;}
                else if(parent.right == node){parent.right = child;}
                else{parent.left = child;}
            }
        }
        size--;
        return removedv;
    }
    
    private BSTNode findsuccessorhelper(BSTNode node){
        if(node.left == null){return node;}
        return findsuccessorhelper(node.left);
    }

    private BSTNode findsuccessor(k key){
        BSTNode node = getNode(key);
        return findsuccessorhelper(node.right);
    }

    public static void main(String[] args){
        BSTMap<Integer , String> map = new BSTMap<>();
        map.put(7,"ahmed" );
        map.put(2, "ashraf");
        map.put(3, "ameer");
        map.put(5, "m");
        map.put(4, "aer");
        map.put(1, "a");
        map.put(14, "mohamed");
        map.put(12, "basem");
        map.put(13, "b");
        map.put(15, "c");

        for(Integer k : map){
            System.out.println(k);
        }

        // System.out.println(map.findsuccessor().value);
    }
}
