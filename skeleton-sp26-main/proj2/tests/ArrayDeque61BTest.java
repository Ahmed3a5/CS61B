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

    @Test

    public void testget(){
        Deque61B<Integer> alist = new ArrayDeque61B<>();
        Deque61B<Integer> alist2 = new ArrayDeque61B<>();


        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]

        assertThat(alist.get(0)).isEqualTo(8);
        assertThat(alist.get(1)).isEqualTo(4);
        assertThat(alist.get(2)).isEqualTo(1);
        assertThat(alist.get(3)).isEqualTo(7);
        assertThat(alist.get(4)).isEqualTo(6);
        assertThat(alist.get(5)).isEqualTo(3);
        assertThat(alist.get(17)).isEqualTo(null);
        assertThat(alist.get(-1)).isEqualTo(null);
        assertThat(alist2.get(0)).isEqualTo(null);
    }

    @Test

    public void testisempty(){

        Deque61B<Integer> alist = new ArrayDeque61B<>();
        Deque61B<Integer> alist2 = new ArrayDeque61B<>();


        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]

        assertThat(alist.isEmpty()).isEqualTo(false);
        assertThat(alist2.isEmpty()).isEqualTo(true);
    }

    @Test

    public void testsize(){
        Deque61B<Integer> alist = new ArrayDeque61B<>();
        Deque61B<Integer> alist2 = new ArrayDeque61B<>();


        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]

        assertThat(alist.size()).isEqualTo(6);
        assertThat(alist2.size()).isEqualTo(0);
    }

    @Test

    public void testremovefirst(){
        Deque61B<Integer> alist = new ArrayDeque61B<>();
        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]

        assertThat(alist.getFirst()).isEqualTo(8);

        int removed1 = alist.removeFirst();

        assertThat(alist.getFirst()).isEqualTo(4);
        assertThat(removed1).isEqualTo(8);

        int removed2 = alist.removeFirst();

        assertThat(alist.getFirst()).isEqualTo(1);
        assertThat(removed2).isEqualTo(4);


        int removed3 = alist.removeFirst();
        assertThat(alist.getFirst()).isEqualTo(7);
        assertThat(removed3).isEqualTo(1);


        int removed4 = alist.removeFirst();
        assertThat(alist.getFirst()).isEqualTo(6);
        assertThat(removed4).isEqualTo(7);


        int removed5 = alist.removeFirst();
        assertThat(alist.getFirst()).isEqualTo(3);
        assertThat(removed5).isEqualTo(6);


        int removed6 = alist.removeFirst();
        assertThat(alist.getFirst()).isEqualTo(null);
        assertThat(removed6).isEqualTo(3);



        assertThat(alist.toList()).containsExactly().inOrder();

    }

    
    @Test

    public void testremovelast(){

        Deque61B<Integer> alist = new ArrayDeque61B<>();
        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]

        assertThat(alist.getLast()).isEqualTo(3);

        int removed1 = alist.removeLast();

        assertThat(alist.getLast()).isEqualTo(6);
        assertThat(removed1).isEqualTo(3);

        int removed2 = alist.removeLast();

        assertThat(alist.getLast()).isEqualTo(7);
        assertThat(removed2).isEqualTo(6);

        int removed3 = alist.removeLast();
        assertThat(alist.getLast()).isEqualTo(1);
        assertThat(removed3).isEqualTo(7);


        int removed4 = alist.removeLast();
        assertThat(alist.getLast()).isEqualTo(4);
        assertThat(removed4).isEqualTo(1);


        int removed5 = alist.removeLast();
        assertThat(alist.getLast()).isEqualTo(8);
        assertThat(removed5).isEqualTo(4);


        int removed6 = alist.removeLast();
        assertThat(alist.getLast()).isEqualTo(null);
        assertThat(removed6).isEqualTo(8);

        assertThat(alist.toList()).containsExactly().inOrder();
    }

    @Test

    public void testresize(){

        Deque61B<Integer> alist = new ArrayDeque61B<>();
        alist.addFirst(1);  // [1]
        alist.addLast(7);   // [1 ,7]
        alist.addFirst(4);  // [4 ,1 ,7]   
        alist.addFirst(8);  // [8 ,4 ,1 ,7]
        alist.addLast(6);   // [8 ,4 ,1  ,7 ,6]
        alist.addLast(3);   // [8 ,4 ,1 ,7 ,6 ,3]
        alist.addLast(5);   // [8 ,4 ,1 ,7 ,6 ,3 ,5]
        alist.addLast(9);   // [8 ,4 ,1 ,7 ,6 ,3 ,5 ,9]
        alist.addFirst(10); // [10 ,8 ,4 ,1 ,7 ,6 ,3 ,5 ,9]
        alist.addFirst(11); // [11 ,10 ,8 ,4 ,1 ,7 ,6 ,3 ,5 ,9]

        assertThat(alist.toList()).containsExactly(11 , 10 , 8 , 4 , 1 , 7 , 6 , 3 , 5 , 9 ).inOrder();

    }
}
