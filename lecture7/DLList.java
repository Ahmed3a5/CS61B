package lecture7;

import java.util.Iterator;
public class DLList<T> implements Iterable<T>{

    public class DLListiterator implements Iterator<T>{

        int pos;

        public DLListiterator(){
            pos = 0;
        }

        public boolean hasNext(){
            if(pos < size){
                return true;
            }
            return false;
        }

        public T next(){
            T toreturn = (T) new Object();
            Node p = sentinel.next;
            int position = 0;
            while(p!=sentinel){
                if(position == pos){
                    toreturn = p.item;
                }
                p = p.next;
                position++;
            }
            pos++;
            return toreturn;
        }

    }
    
    private class Node{
        Node prev;
        T item;
        Node next;

        private Node(Node p  , T i ,Node n ){
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    public int size;

    public DLList(){
        T s = (T) new Object();
        sentinel = new Node(null, s, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public DLList(T i){
        T s = (T) new Object();
        sentinel = new Node(null , s , null);
        Node n = new Node(sentinel , i , sentinel);
        sentinel.prev = n;
        sentinel.next = n;
        size++;
    }

    public void addfirst(T i){
        Node n = new Node(sentinel , i , sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size++;

    }

    public void addlast(T i){
        Node n = new Node(sentinel.prev , i , sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    public int size(){
        return size;
    }

    public T getlast(){
        return sentinel.prev.item;
    }
    public T getfirst(){
        return sentinel.next.item;
    }

    public T get(int i){
        Node p = sentinel.next;
        int position = 0;
        T toreturn = (T) new Object();
        while(p!=sentinel){
            if(position == i){
                 toreturn = p.item;
            }
            p = p.next;
            position++;
        }
        return toreturn;
    }   

    public Iterator<T> iterator(){
        return  new DLListiterator();
    }
}
