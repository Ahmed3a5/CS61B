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
}
