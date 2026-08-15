import java.util.ArrayList;
import java.util.List;
public class worksheet1 {
    public static int minnum(List<Integer> L){
        int x = 0;
        int minmum = L.get(0);
        while(x < L.size()){
            if(L.get(x) < minmum){
                minmum = L.get(x);
            }
            x = x+1;

        }
        return minmum;
    }
    
    public static int maxnum(List<Integer> L){
        int x = 0;
        int maximum = L.get(0);
        while(x < L.size()){
            if(L.get(x) > maximum){
                maximum = L.get(x);
            }
            x = x+1;

        }
        return maximum;
    }

    
    public static int maxmindiff(List<Integer> L){
        int differ = 0;
        if(L.size() == 0 ){
            System.out.println("list must be at least 1 item ");
        }
        else{
            int maximum = maxnum(L);
            int minumum = minnum(L);
             differ = maximum - minumum ; 
            
        }
        
        return differ;
    }


    public static void main(String[] args){
        List<Integer> L = new ArrayList<Integer>();
        L.add(115);
        L.add(0);
        L.add(3);
        L.add(4);
        L.add(10);
        System.out.println(maxmindiff(L));
        // System.out.println(L.size());
    }
}
