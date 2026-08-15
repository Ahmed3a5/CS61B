package worksheet2;
import java.util.ArrayList;
import java.util.List;

public class Listexercise {
    public static List<Integer> common(List<Integer> L1 , List<Integer> L2){
        List<Integer> last = new ArrayList<>();
        for(int elem : L1){
            if(!L2.contains(elem) && !last.contains(elem)){
                last.add(elem);
            }
        }
        return last;
    }

    public static void capitalize(List<String> L){
        int i = 0;
        for(String elem : L){
            String newelem = elem.toUpperCase();
            L.set(i, newelem);
            i++;
        }
    }

    public static void main(String[] args){
        // List<Integer> L1 = new ArrayList<Integer>(List.of(1 , 2 , 3 , 4, 5 , 6 , 7));
        // List<Integer> L2 = new ArrayList<Integer>(List.of(2 , 4 , 6 , 8 , 10 , 12, 14 ));
        List<String>  L3  = new ArrayList<String>(List.of("ahmed" , "elem" , "zizo"));
        // List last = common(L1 , L2);

        capitalize(L3);
        System.out.println(L3);




    }
}
