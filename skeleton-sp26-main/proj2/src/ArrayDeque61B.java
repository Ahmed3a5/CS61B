import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>{
    private T[] items;
    private int nextfirst;
    private int nextlast;
    public int size;

    private class Arraysetiterator implements Iterator<T>{
        private int wizpos;

        public Arraysetiterator(){
            wizpos = 0;
        }

        public boolean hasNext(){
            if(wizpos < size){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T returneditem = get(wizpos);
            wizpos++;
            return returneditem;
        }
    }

    public ArrayDeque61B(){
        items = (T[]) new Object[8];
        nextfirst = 0;
        nextlast = 1;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if(size >= items.length){
            this.resizeUp(size*2);
        }
        if(nextfirst == 0){
            items[nextfirst] = x;
            nextfirst = items.length-1;
        }
        else{
            items[nextfirst] = x;
            nextfirst--;
        }
        size++;

    }

    @Override
    public void addLast(T x){
        if(size >= items.length){
            this.resizeUp(size*2);
        }

        if(nextlast >= items.length-1){
            items[nextlast] = x;
            nextlast = 0;
        }
        else{
            items[nextlast] = x;
            nextlast++;
        }
        size++;

    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        int tracker = nextfirst;
        for(int i = 0 ; i < size ; i++){
            tracker++;
            if(tracker > items.length-1){
               tracker = 0;            
            }
            list.add(i , items[tracker]);
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        if(nextfirst >= items.length-1){
            return items[0];
        }
       return items[nextfirst+1];
    }

    @Override
    public T getLast() {
        if(nextlast <= 0){
            return items[items.length-1];
        }
        return items[nextlast-1];
    }

    @Override
    public T removeFirst() {
        if(size < (items.length/4)){
            resizeDown(items.length/2);
        }

        if(nextfirst >= items.length-1){
            nextfirst = 0;
        }
        else{
            nextfirst =nextfirst+1;
        }
        T removed = items[nextfirst];
        size--;
       return removed;
    }

    @Override
    public T removeLast() {
        if(nextlast <= 0 ){
            nextlast = items.length-1;
        }
        else{
            nextlast = nextlast-1;
        }
       T removed = items[nextlast];
       size--;
       return removed;
    }

    @Override
    public T get(int index) {
        if(index > size){
            return null;
        }
        int correctedindex = (nextfirst+1 + index) % items.length;
        return items[correctedindex];
    }

    @Override
    public T getRecursive(int index) {
        // not needed 
        throw new UnsupportedOperationException("No need to implement getRecursive for ArrayDeque61B.");
    }

    private void resizeUp(int capacity){
        T[] resizedarr = (T[]) new Object[capacity];

        for(int i = 0 ; i < size ; i++){
            resizedarr[i] = this.get(i);
        }
        items = resizedarr;
        nextfirst = items.length-1;
        nextlast = size;
    }

    private void resizeDown(int capacity){
        T[] resizedarr = (T[]) new Object[capacity];
        for(int i = 0 ; i < size ; i++){
            resizedarr[i] = this.get(i);
        }
        items = resizedarr;
        nextfirst = items.length-1;
        nextlast = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Arraysetiterator();
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(this.getClass() != other.getClass()){
            return false;
        }

        ArrayDeque61B<T> O = (ArrayDeque61B<T>) other;
        if(this.size() != O.size()){
            return false;
        }
        for(int i = 0 ; i < O.size() ; i++){
            if(O.get(i) != this.get(i)){
                return false;
            }
        }
        return true;
    }

    @Override

    public String toString(){

        String returnedString = "[";
        for(int i = 0 ; i<this.size() ; i++){
            if(i==0){
                returnedString += this.get(i);
            }
            else{
                returnedString += ",";
                returnedString += this.get(i);
            }
            
        }

        returnedString += "]";

        return returnedString;
    }

}
