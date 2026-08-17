package lecture7;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DLListtest {

    @Test
    public void testaddlast(){
        DLList n = new DLList();
        n.addlast(5);
        n.addlast(10);

        int last = 10;

        assertThat(last).isEqualTo(n.getlast());
    }

    @Test
    public void testget(){
        DLList n = new DLList();
        n.addlast(5);
        n.addlast(10);
        n.addlast(7);

        assertThat(n.get(0)).isEqualTo(5);
    }

    @Test
    public static void testiterator(){
        DLList n = new DLList();
        n.addlast(5);
        n.addlast(10);
        n.addfirst(7);

        for(int i : n){
            System.out.println(i);
        }

    }

    public static void main(String[] args){
        testiterator();
    }
}
