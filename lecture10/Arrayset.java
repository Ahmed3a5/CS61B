package lecture10;

import java.util.Iterator;

public class Arrayset<T> implements Iterable<T>{
       // arrayiterattor class for iterator method 
    public class ArrayIterator implements Iterator<T>{
        int wizpos;

        public ArrayIterator(){
            wizpos = 0;
        }

        public boolean hasNext(){
            if(wizpos < size){
                return true;
            }
            return false;
        }

        public T next(){
            T toreturn = items[wizpos];
            wizpos++;

            return toreturn;
        }
    }


    T[] items;
    int size;
    
    public Arrayset(){
        items = (T[]) new Object[100];
        size = 0;
    }
        

    public boolean contains(T x){
        for(int i =0; i<size ; i++){
            if(items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public void add(T x){
        if(!contains(x)){
            items[size] = x;
            size++;
        }
    }

    public Iterator<T> iterator(){
        return new ArrayIterator();
    }

    @Override
    public String toString(){
        String returnedstring = "[";

        for(int i=0 ; i<size ; i++){
            returnedstring += items[i] + ","; 
        }   

        returnedstring+="]";

        return returnedstring;
    }

    
    public boolean equals(Object o){
        if(o instanceof Arrayset old){
            if(this.size == old.size){
                for( T i : this){
                    if(!old.contains(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Arrayset<Integer> aset = new Arrayset<>();
        aset.add(5);
        aset.add(4);
        aset.add(6);
        aset.add(5);

        System.out.println(aset);

        // for(int i : aset){
        //     System.out.println(i);
        // }

        // Iterator<Integer> assss = aset.iterator();

        // while(assss.hasNext()){
        //     System.out.println(assss.next());
        // }
    }
}

 