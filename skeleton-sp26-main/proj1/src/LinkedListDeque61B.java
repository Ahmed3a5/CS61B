import java.util.ArrayList;
import java.util.List;


public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node<T>{


        /*
            make the private class node whic is the small unit that make the linked list 
            it have a previous and next pointers to the other nodes 
            and the item whic is the value the node have 
         */
        Node prev;
        T item;
        Node next;

        private Node(Node p , T i , Node n){

            prev = p;
            item = i;
            next = n;
        }
    }

    /*
        make the sentinel node variable and size variable 
     */
    private Node sentinel;
    private int size;

    public LinkedListDeque61B(){
        // intialize the sentinel Node with all null //

        sentinel = new Node(null , null , null);

        // make the sentinel node point to itself

        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        // intialize the size of the list as 0 empty list 

        size =0;

    }

    @Override
    public void addFirst(T x) {
        /*
            intialize the new node have the x value to add 
            the new node previous point to the sentinel and the next point to the next node to the sentinel 
            then the next node to sentinel prev pointer point to the n node 
            then the sentinel next point to the new node 
            then increase the size by one 
        */
        Node n = new Node(null , x , null);
        n.prev = sentinel;
        n.next = sentinel.next;
        sentinel.next.prev = n;
        sentinel.next = n;
        size++;
    }

    @Override
    public void addLast(T x) {
        /*
            intialize the new node to add 
            make its prev point to the last node whic is sentinle prev point 
            then make the next point of the new node point to the sentinel circular 
            make the last node in the list next pointer point to the new last node 
            increase the size by one 

        */
        Node n = new Node(null, x , null);
        n.prev = sentinel.prev;
        n.next = sentinel;
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    @Override
    public List<T> toList() {
        List returnlist = new ArrayList<>();
        if(this.isEmpty()){
            return returnlist;
        }

        Node p = sentinel.next;

        while(p!=sentinel){
            returnlist.add(p.item);
            p = p.next;
        }
        return returnlist;
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
       return this.size;
    }

    @Override
    public T getFirst() {
        return (T) sentinel.next.item;
    }

    @Override
    public T getLast() {
        return (T) sentinel.prev.item;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        T removeditem = (T) sentinel.next.item;
        Node temp = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        temp.next = null;
        temp.prev = null;
        size--;
        
        return removeditem;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        T removeditem = (T) sentinel.prev.item;
        Node temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        temp.next = null;
        temp.prev = null;
        size--;

        return removeditem;
    }

    @Override
    public T get(int index) {
        if(index > size){
            return null;
        }
       
        Node p = sentinel.next;
        
        for(int i = 0 ; i < size ; i++){
            if(i == index){
                return (T) p.item;
            }

            p = p.next;
        }
        return null;
    }

    private T getRecursive( Node p , int index, int i){
        if(i == index){
            return (T) p.item;
        }
        else{
            return getRecursive(p.next, index, i+1);
        }
    }

    @Override
    public T getRecursive(int index) {
        if(index > size || index < 0){
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        T returneditem = getRecursive(p, index, i);
        return returneditem;
    }
    

    public static void main(String[] args){
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(0);
        lld.addLast(1);
        lld.addFirst(-1);
    }
}
