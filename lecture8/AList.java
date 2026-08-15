package lecture8;

public class AList{
    int[] items;
    int size;

    public AList(){
        items = new int[999];
        size = 0;
    }

    private void resize(int capacity){
        int[] resized = new int[capacity];

        for(int i = 0 ; i < items.length ; i++){

            resized[i] = items[i];
        }

            items = resized;
    }

    public void addlast(int x){
        if(size == items.length){
            resize(size+1);
        }
        
        items[size] = x;
        size++;
    }

    public void addfirst(int x){
        if(size == items.length){
            resize(size*2);
        }

        if(size == 0){
            items[0] =x;
            size++;
        }
        else{
            int prev = 0;
            int current = 0;
            size++;
            for(int i = 0 ; i < items.length ; i++ ){
                if(i == 0){
                    prev = items[i]; 
                    items[i] = x;
                }
                else{
                    current = items[i];
                    items[i] = prev;
                    prev = current;   
                }
            }
            
        }
    }

    public int size(){
        return size;
    }

    public int get(int i ){
        return items[i];
    }
}
