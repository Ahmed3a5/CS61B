// package skeleton-sp26-main.proj1.src;
import java.util.List;


public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node<T>{
        Node prev;
        T item;
        Node next;

        private Node(Node p , T i , Node n){

            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B(){

        sentinel = new Node(null , null , null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size =0;

    }

    @Override
    public void addFirst(T x) {
        Node n = new Node(sentinel , x , sentinel.next);
        sentinel.prev.prev = n;
        sentinel.next = n;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node n = new Node(sentinel.prev ,x , sentinel);
        sentinel.prev.next = n;
        size++;
    }

    @Override
    public List<T> toList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toList'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public T getFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }

    @Override
    public T getLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLast'");
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
    

    public static void main(String[] args){
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addFirst(-1);
    }
}
