import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {

    @Test
    public void testaddfirst(){

        Deque61B<Integer> alist = new ArrayDeque61B<>();
        alist.addFirst(11); // [11]
        alist.addFirst(12); // [12 , 11]
        alist.addFirst(10); // [10 , 12 , 11]
        alist.addFirst(8); // [10 , 12 , 11]


        assertThat(alist.toList()).containsExactly( 8 ,10 ,12 ,11).inOrder();
        assertThat(alist.getFirst()).isEqualTo(8);

    }

    @Test

    public void testaddlast(){
        Deque61B<Integer> alist =new ArrayDeque61B<>();
        // alist.addFirst(0);
        alist.addLast(1);
        alist.addLast(2);
        alist.addLast(3);

        assertThat(alist.toList()).containsExactly( 1 , 2 , 3).inOrder();
        assertThat(alist.getLast()).isEqualTo(3);
    }

    @Test
    public void testgetfirst(){
        Deque61B<Integer> alist =new ArrayDeque61B<>();

        Deque61B<Integer> alist2 =new ArrayDeque61B<>();

        alist2.addFirst(11); // [11]
        alist2.addFirst(12); // [12 , 11]
        alist2.addFirst(10); // [10 , 12 , 11]
        alist2.addFirst(8);

        assertThat(alist.getFirst()).isEqualTo(null);
        assertThat(alist2.getFirst()).isEqualTo(8);
    }

    @Test
    public void testgetlast(){
        Deque61B<Integer> alist =new ArrayDeque61B<>();

        Deque61B<Integer> alist2 =new ArrayDeque61B<>();
        alist2.addLast(1);
        alist2.addLast(2);
        alist2.addLast(3);

        assertThat(alist.getLast()).isEqualTo(null);
        assertThat(alist2.getLast()).isEqualTo(3);
    }

    @Test

    public void testtoList(){
        Deque61B<Integer> alist =new ArrayDeque61B<>();

        Deque61B<Integer> alist2 =new ArrayDeque61B<>();

        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]

        assertThat(alist.toList()).containsExactly(8 , 4 , 1 , 7 , 6 , 3 ).inOrder();
        assertThat(alist2.toList()).containsExactly().inOrder();


    }
}
