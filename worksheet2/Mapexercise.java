package worksheet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapexercise {
    
    public static Map<Integer , List<Integer>> buildlessthanmap(List<Integer> L){

        Map<Integer , List<Integer>> last = new HashMap<>(); 

        for(int i = 0 ; i < L.size() ; i++){
            if(!last.containsKey(L.get(i))){
                List<Integer> lessIntegers = findlessthan(L, L.get(i));
                last.put(L.get(i) , lessIntegers );
            }
        }
        return last;
        
    }

    public static List<Integer> findlessthan(List<Integer> x , int num){

        List<Integer> last = new ArrayList<Integer>();
        for(int i =0 ; i<x.size() ; i++){
            if(x.get(i) < num){
                if(!last.contains(x.get(i))){
                    last.add(x.get(i));
                }
            }
        }
        return last; 
    }   
}
