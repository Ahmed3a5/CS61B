package array;

public class intarray {
    public int capacity;
    public int totalsize;
    private int[] arr;

    public intarray(int size){
        capacity = size;
        totalsize = 0;
        this.arr = new int[capacity];
    }

    private boolean checkvalid(int index){
        if(index < 0 || index > totalsize){
            return false;
        }
        return true;
    }

    public void insert(int index  , int value){
        if(!checkvalid(index)){
            System.out.println("INVALID INDEX");
        }
        else{
            this.arr[index] = value;
            totalsize++;
        }
    }

    public void deletebyindex(int index){
        if(!checkvalid(index)){
            System.out.println("INVALID INDEX");
        }
        else{
           this.arr[index] = this.arr[totalsize-1];
            totalsize--;
        }
    }

    public int searchindex(int elem){
        for(int i=0 ; i<this.totalsize ; i++){
            if(this.arr[i] == elem ){
                return i;
            }

        }
        return -1;
    }

    public int get(int index){
        if(checkvalid(index)){
            return this.arr[index];

        }else{
            return -1;

        }
    }
}
