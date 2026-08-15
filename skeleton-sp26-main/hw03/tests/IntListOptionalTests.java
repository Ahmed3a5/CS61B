import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntListOptionalTests {

    // @Test
    public static void testsum(){
        IntList L = new IntList(3 ,new IntList(2 , new IntList(4 , new IntList(1,null))));

        int expectedsumL = 10;
        int actualsumX = L.sum();

        IntList x = new IntList(10 ,new IntList(15 , new IntList(0 , new IntList(5,null))));

        int expectedsumx = 30;
        int actualsumx = x.sum();


        if(expectedsumx == actualsumx){
            System.out.println("test successes");
        }
        else{
            System.out.println("Test fails");
        }
    }

    public static void testaddlast(){

        IntList L = new IntList(3 ,new IntList(2 , new IntList(4 , new IntList(1,null))));
        L.addLast(0);
        L.addLast(10);

        IntList expected= new IntList(3 ,new IntList(2 , new IntList(4 , new IntList(1,new IntList(0,new IntList(10,null))))));



        if(L.get(L.size()-1) == expected.get(expected.size()-1)){
            System.out.println("test successes");
        }
        else{
            System.out.println("test fails");
        }


    }

    public static void testaddfirst(){
        IntList L = new IntList(3 ,new IntList(2 , new IntList(4 , new IntList(1,null))));
        L.addFirst(0);
        L.addFirst(10);

        IntList expected= new IntList(10, new IntList(0, new IntList(3 ,new IntList(2 , new IntList(4 , new IntList(1,null))))));

         if(L.get(0) == expected.get(0)){
            System.out.println("test successes");

        }
        else{
            System.out.println("test fails");
        }



        
    }

    public static void main(String[] args){
        // testsum();
        // testaddlast();
        testaddfirst();
    }
}
