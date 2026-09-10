import java.util.Iterator;
import java.util.Set;

public class BSTMap<k extends Comparable<k>,v> implements Map61B<k,v> , Iterable<k>{
    private class BSTMapIterator<K , v> implements Iterator<K>{

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

        public k next() {
            k item = (K) keys[wizpos];
            wizpos++;

            return item;
        }
    }

    private k[] keys;
    v[] values;
    int size;

    public BSTMap(){
        keys   = (k[]) new Comparable[4];
        values = (v[]) new Object[4];
        size = 0;
    }
    
    @Override
    public Iterator<k> iterator() {
       return (Iterator<K>) new BSTMapIterator();
    }

    @Override
    public void put(k key, v value) {
        if(size >= keys.length){
            resize(size*2);
        }

        if(containsKey(key)){
            int index = getindex(key);
            values[index] = value;
        }
        else{
            keys[size] = key;
            values[size]  = value;
            size++;
        }
        
    }

    public int getindex(k key){
        int index = 0;
        for(int i = 0 ; i <size ; i++){
            if (keys[i] == key){index = i;}
        }
        return index;
    }

    @Override
    public v get(k key) {
        if(!containsKey(key)){return null;}
        int index = 0;
        for(int i = 0 ; i <size ; i++){
            if (keys[i] == key){index = i;}
        }
        return values[index];
    }

    @Override
    public boolean containsKey(k key) {
      for(int i = 0 ; i < size ; i ++ ){
        if(keys[i] == key){
            return true;
        }
      }
      return false;
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public void clear() {
      keys = (k[]) new Comparable[4];
      values = (v[]) new Object[4];
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
        v[] newvalues = (v[]) new Object[capacity]; 
        k[] newkeys = (k[]) new Comparable[capacity];

        for(int i = 0 ; i < size ; i ++){
            newkeys[i] = keys[i];
            newvalues[i] = values[i];
        }
        keys = newkeys;
        values = newvalues;
    }
    
}
