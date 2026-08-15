
public class testssort {

    
    public static void testsort(){
        String[] input = {"i" , "have" , "an" , "egg"};
        String[] expected = {"an" , "egg" , "have" , "i"};
        Sort.sort(input);

        for(int i=0 ; i<input.length ; i++){
            if(!input[i].equals(expected[i])){
                System.out.println("Mismatch in position " + i + ", expected: " + expected + ", but got: " + input[i] + ".");
                break;
            }
            
        }
    }

    public static void testfindsmallest(){
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input , 0);

        // String[] input2 = {"there", "are", "many", "pigs"};
        // int expected2 = 1;

        // int actual2 = Sort.findSmallest(input2 , 0);

        if(actual != expected){
            System.out.println("the acutal smallest is " + actual + " the expected is " + expected);            
        }
    }

    public static void testswap(){
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};        
        Sort.swap(input, a, b);

        if(!input[0].equals(expected[0])){
            System.out.println("the test fail");
        }
        else{
            System.out.println("the test success");

        }
    }
    public static void main(String[] args){
        testsort();
        // testfindsmallest();
        // testswap();
    }
}
