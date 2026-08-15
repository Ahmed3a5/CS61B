package array;

public class newaarray {
    
    public static void main(String[] args){
        // staticarray arr = new staticarray(5);
        // arr.set(0 , 1);
        // arr.set(1 , 2);                
        // arr.set(2 , 3);
        // arr.set(3 , 4);
        // arr.set(4 , 5);

        // System.out.println(arr.get(5));

        intarray arr = new intarray(5);
        arr.insert(0 , 1);
        arr.insert(1 , 2);                
        arr.insert(2 , 3);
        arr.insert(3 , 4);
        arr.insert(4 , 5);

        arr.deletebyindex(2);
        System.out.println(arr.searchindex(5));




    }
}
