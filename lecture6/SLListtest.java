package lecture6;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class SLListtest {
    
    @Test
    public void testinsert(){
        SLLIST L = new SLLIST();
        L.addfirst(5);
        L.addlast(6);
        L.addlast(2);
        L.insert(10, 1);
        L.insert(15 , -1);
        L.insert(4 , 10);

        SLLIST expected = new SLLIST();
        expected.addfirst(5);
        expected.addlast(10);
        expected.addlast(6);
        expected.addlast(2);
        expected.addfirst(15);
        expected.addlast(4);



        // System.out.println(expected.get(1));
        // System.out.println(L.get(1));

        // for(int i = 0 ; i<L.size() ; i++){
        //     System.out.println(L.get(i));
        // }


        assertThat(expected.get(0)).isEqualTo(L.get(0));
        assertThat(expected.get(1)).isEqualTo(L.get(1));
        assertThat(expected.get(L.size()-1)).isEqualTo(L.get(expected.size()-1));



    }

    // public static void main(String[] args){
    //     testinsert();
    // }
}
