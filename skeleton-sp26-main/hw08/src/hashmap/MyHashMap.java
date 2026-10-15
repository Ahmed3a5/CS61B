package hashmap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int intialcapacity;
    private int size;
    private int bucketsize;
    private Set<K> keys;
    private double loadfactor;

    /** Constructors */
    public MyHashMap() { 
        buckets = new Collection[16];
        for(int i = 0 ; i < buckets.length ; i++ ){
            buckets[i] = createBucket();
        }
        size = 0;
        keys = new HashSet<>();
        loadfactor = 0.75;
        bucketsize = buckets.length;
    }

    public MyHashMap(int initialCapacity) {
        intialcapacity = initialCapacity;
        buckets = new Collection[initialCapacity];
        for(int i = 0 ; i < initialCapacity ; i++ ){
            buckets[i] = createBucket();
        }
        size = 0;
        keys = new HashSet<>();
        bucketsize = buckets.length;
        loadfactor = 0.75;
     }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor maximum load factor
     */
    public MyHashMap(int initialCapacity, double loadFactor) {
        intialcapacity = initialCapacity;
        buckets = new Collection[initialCapacity];
        for(int i = 0 ; i < initialCapacity ; i++ ){
            buckets[i] = createBucket();
        }
        size = 0;
        keys = new HashSet<>();
        bucketsize = buckets.length;
        loadfactor = loadFactor;
     }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *  Note that this is referring to the hash table bucket itself,
     *  not the hash map itself.
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    @Override
    public Iterator<K> iterator() {
        return keys.iterator();
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        if(keys.contains(key)){
            int index = Math.floorMod(hash, bucketsize);
            for(Node n : buckets[index]){
                if(n.key.equals(key)){n.value = value; return;}
            }
            return;
        }

        if((double) (size+1) / bucketsize > loadfactor){resizeup();}
        int index = Math.floorMod(hash, bucketsize);        
        Node n = new Node(key , value);
        keys.add(key);
        buckets[index].add(n);
        size++;
        
    }

    @Override
    public V get(K key) {
        int index = Math.floorMod(key.hashCode() , buckets.length);
        V value = null;
        for(Node n : buckets[index]){
            if(n.key.equals(key)){value = n.value; break;}
        }
        return value;
    }

    @Override
    public boolean containsKey(K key) {
        if(keys.contains(key)){return true;}
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new Collection[intialcapacity];
        for(int i = 0 ; i < buckets.length ; i++){
            buckets[i] = createBucket();
        }
        keys = new HashSet<>();
        size = 0;
        bucketsize = buckets.length;
    }

    @Override
    public Set<K> keySet() {
        return keys;
    }

    @Override
    public V remove(K key) {
        int index = Math.floorMod(key.hashCode(), bucketsize);
        V value = null;
        for(Node n : buckets[index]){
            if(n.key.equals(key)){
                value = n.value;
                buckets[index].remove(n);
                keys.remove(key);
                size--;
                break;
            }
        }
        return value;
    }

    public V remove(K key , V value){
        int index = Math.floorMod(key.hashCode(), bucketsize);
        V removedV = null;
        for(Node n : buckets[index]){
            if(n.key.equals(key) && n.value.equals(value)){
                removedV = n.value;
                buckets[index].remove(n);
                keys.remove(key);
                size--;
                break;
            }
        }
        return removedV;
    }

    private void resizeup(){
        bucketsize = bucketsize*2;
        Collection<Node>[] N = new Collection[bucketsize];
        for(int i = 0; i< bucketsize ; i++){
            N[i] = createBucket();
        }
        for(int i = 0 ; i < buckets.length ; i++){
            for(Node n : buckets[i]){
                N[Math.floorMod(n.key.hashCode(), bucketsize)].add(n);
            }
        }
        buckets = N;
    }
}
