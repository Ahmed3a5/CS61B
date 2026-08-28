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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
       return items[nextfirst+1];
    }

    @Override
    public T getLast() {
        return items[nextlast-1];
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T getRecursive(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecursive'");
    }


}
