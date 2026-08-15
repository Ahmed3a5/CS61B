package worksheet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testmapexercise {
    public static void testfindlessthan(){
        List<Integer> input = new ArrayList<Integer>(List.of(1 , 2 , 3 , 4 , 7));

        List<Integer> expectedof7 = new ArrayList<>(List.of(1 , 2 , 3, 4 ));
        // List<Integer> expectedof4 = new ArrayList<>(List.of(1 , 2 , 3));
        // List<Integer> expectedof3 = new ArrayList<>(List.of(1 , 2));
        // List<Integer> expectedof2 = new ArrayList<>(List.of(1));
        // List<Integer> expectedof1 = new ArrayList<>();
        

            List<Integer> acutal = Mapexercise.findlessthan(input,input.get(3));

            if(!acutal.equals(expectedof7)){
                System.out.println("test fail!");
            }
            else{
                System.out.println("test succsess!");
            }

            // System.out.println(acutal);
    }

    public static void testbuildlessthanmap(){
        List<Integer> input = new ArrayList<Integer>(List.of(4 , 1, 3 , 3));

        Map<Integer , List<Integer>> expected = new HashMap<>();
        List<Integer> exp1 = new ArrayList<>();
        List<Integer> exp3 = new ArrayList<>(List.of(1));
        List<Integer> exp4 = new ArrayList<>(List.of(1 , 3));
        expected.put(1 ,exp1);
        expected.put(3 ,exp3);
        expected.put(4 ,exp4);

        Map<Integer , List<Integer>> actual = Mapexercise.buildlessthanmap(input);

        if(!actual.equals(expected)){
            System.out.println("test fails!");
        }
        else{
            System.out.println("test success!");
        }

        // System.out.println(actual);



    }

    public static void main(String[] args){
        testfindlessthan();
        testbuildlessthanmap();
    }
}
