package worksheet2;

import java.util.ArrayList;
import java.util.List;

public class filter {
    public static int[] positivefilter(List<Integer> L){
        int[] last = new int[L.size()];
        int x = 0;
        for(int i = 0 ; i<L.size() ; i++){
            if(L.get(i) > 0){
                last[x] = L.get(i);
                x++;
            }   
        }
        return last;
    }

    public static void main(String[] args){
        List<Integer> L = new ArrayList<>(List.of(1 , -1 , -5 , 8 , 7 , 9 , -10));
        int[] last = positivefilter(L);
        for(int i = 0 ; i < last.length ; i++){
            System.out.println(last[i]);
        }
    }
}
