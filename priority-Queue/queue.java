
import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class queue {
    private int [] keys;
    public int size;

    public queue(){
        keys = new int[4];
        size = 0;
    }

    public void add(int x){
        if(size == keys.length){
            resize();
        } 
        keys[size] = x;
        swimup(size);
        size++;
    }

    private void resize(){
        int[] re = new int[size*2];

        for(int i = 0 ; i < size ; i++){
            re[i] = keys[i];
        }
        keys = re;
    }

    public int parent(int index){
            return (index-1)/2;
    }

    public void printtree(){
        printhelper(0 , "");
    }

    public void printhelper(int index , String indent){
        if(index >= size){
            return;
        }
        printhelper((index*2)+2  , indent+"    ");
        System.out.println(indent + keys[index]);
        printhelper((index*2)+1, indent +"     ");
    }

    private void swimup(int k){
        if(k == 0){return;}
        if(keys[parent(k)] > keys[k]){
            swap(k , parent(k));
            swimup(parent(k));
        }
    }

    private void swimdown(int k){
        int right = k*2+2;
        int left  = k*2+1;
        int smallest = k;
        if(k == size){return;}
        if(left < size){
            if(keys[k] > keys[left] && keys[left] < keys[smallest]){
                smallest = left;
            }
        }
        if(right < size){
            if(keys[k] > keys[right] && keys[right] < keys[smallest]){
                smallest = right;
            }
        }

        if(smallest != k){
            swap(smallest , k);
            swimdown(smallest);
        }
        
        
    }

    public int getsmallest(){
        return keys[0];
    }

    public int removesmallest(){
        if(size == 0){
            return (Integer) null;
        }
        int removed = keys[0];
        size--;
        swap(0 , size);
        swimdown(0);
        return removed;
    }

    private void swap(int index1 , int index2){
        int temp = keys[index1];
        keys[index1] = keys[index2];
        keys[index2] = temp;
    }

    public int get(int index){
        return keys[index];
    }

    @Test
    public void testadd(){
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(0);

        assertThat(q.get(0)).isEqualTo(0);
    }

    public static void main(String[] args){
        queue q = new queue();
        q.add(1);
        q.add(10);
        q.add(0);
        q.add(3);
        q.add(5);
        q.add(7);
        q.add(2);
        q.add(4);
        q.add(9);
        q.add(8);
        q.printtree();
        q.removesmallest();
        q.printtree();

    }
}
