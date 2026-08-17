package lecture7;

import java.util.Iterator;

public class DLList implements Iterable<Integer>{

    public class DLListiterator implements Iterator<Integer>{

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

        public Integer next(){
            int toreturn = 0;
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
        int item;
        Node next;

        private Node(Node p  , int i ,Node n ){
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    public int size;

    public DLList(){
        sentinel = new Node(null, -1 , null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public DLList(int i){
        sentinel = new Node(null , -1 , null);
        Node n = new Node(sentinel , i , sentinel);
        sentinel.prev = n;
        sentinel.next = n;
        size++;
    }

    public void addfirst(int i){
        Node n = new Node(sentinel , i , sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size++;

    }

    public void addlast(int i){
        Node n = new Node(sentinel.prev , i , sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    public int size(){
        return size;
    }

    public int getlast(){
        return sentinel.prev.item;
    }
    public int getfirst(){
        return sentinel.next.item;
    }

    public int get(int i){
        Node p = sentinel.next;
        int position = 0;
        int toreturn = 0;
        while(p!=sentinel){
            if(position == i){
                 toreturn = p.item;
            }
            p = p.next;
            position++;
        }
        return toreturn;
    }   

    public Iterator<Integer> iterator(){
        return  new DLListiterator();
    }
}
