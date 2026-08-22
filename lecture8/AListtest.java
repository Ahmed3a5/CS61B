package lecture8;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

import java.util.Iterator;

public class AListtest {

    @Test
    public void addlasttest(){
        AList x = new AList();
        
        for(int i = 0 ; i < 2000 ; i++ ){
            x.addlast(i);
        }

        for(int i = 0 ; i < 2000 ; i++){

            assertThat(x.get(i)).isEqualTo(i);
        }
    }

    @Test
    public void addfirsttest(){
        AList x = new AList();
        
        for(int i = 0 ; i <= 2000 ; i++ ){
            x.addfirst(i);
        }
        System.out.println(x.get(0));

        int index = 0;
        for(int i = 2000 ; i >= 0 ; i--){

            assertThat(x.get(index)).isEqualTo(i);
            index++;
        }
    }

    @Test
    public void testIterator(){
        AList x = new AList();
        
        for(int i = 0 ; i <= 2000 ; i++ ){
            x.addfirst(i);
        }

        // System.out.print(x.get(4));

        for(int i : x){
            System.out.println(i);
        }

    }
}
