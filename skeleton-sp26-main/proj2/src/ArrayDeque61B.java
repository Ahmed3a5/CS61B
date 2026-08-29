import java.util.ArrayList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>{
    private T[] items;
    private int nextfirst;
    private int nextlast;
    public int size;

    public ArrayDeque61B(){
        items = (T[]) new Object[8];
        nextfirst = 0;
        nextlast = 1;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if(size >= items.length){
            return;
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
            return;
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


}
