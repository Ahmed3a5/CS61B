import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    @Test
    /** In this test, we have three different assert statements that verify that addFirst works correctly. */
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

        /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
           to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
           but not ["front", "middle", "back"].
         */
    }

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        /* I've decided to add in comments the state after each call for the convenience of the
           person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    // Below, you'll write your own tests for LinkedListDeque61B.

    @Test 
    
    // test the is empty method 

    public void testempty(){
        Deque61B<Integer> LLd = new LinkedListDeque61B<>();

        assertThat(LLd.isEmpty()).isEqualTo(true);

        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);

        assertThat(LLd.isEmpty()).isEqualTo(false);
    }

    @Test
    // test the size method 

    public void testsize(){
        Deque61B<Integer> LLd = new LinkedListDeque61B<>();

        assertThat(LLd.size()).isEqualTo(0);


        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);

        assertThat(LLd.size()).isEqualTo(3);
    }


    @Test

    // test the getfirst method 

    public void testgetfirst(){

        Deque61B<Integer> LLd = new LinkedListDeque61B<>();
        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);

        assertThat(LLd.getFirst()).isEqualTo(4);
    }


     @Test

    // test the getlast method 

    public void testgetlast(){

        Deque61B<Integer> LLd = new LinkedListDeque61B<>();
        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);
        LLd.addLast(8);


        assertThat(LLd.getLast()).isEqualTo(8);
    }

    @Test
    // test the remove last method 

    public void testremovelast(){
        Deque61B<Integer> LLd = new LinkedListDeque61B<>();
        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);
        LLd.addLast(8);
        int removeditem  = LLd.removeLast();

        assertThat(LLd.getLast()).isEqualTo(7);
        assertThat(LLd.size()).isEqualTo(3);
        assertThat(removeditem).isEqualTo(8);

    }

    @Test

    // test remove first method 

    public void testremovefirst(){
        Deque61B<Integer> LLd = new LinkedListDeque61B<>();
        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);
        LLd.addLast(8);
        int removeditem  = LLd.removeFirst();


        assertThat(LLd.getFirst()).isEqualTo(0);
        assertThat(LLd.size()).isEqualTo(3);
        assertThat(removeditem).isEqualTo(4);

    }

    @Test 
    // test get iterative 

    public void testiterativeget(){
        Deque61B<Integer> LLd = new LinkedListDeque61B<>();
        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);
        LLd.addLast(8);  
        
        assertThat(LLd.get(0)).isEqualTo(4);
        assertThat(LLd.get(1)).isEqualTo(0);
        assertThat(LLd.get(2)).isEqualTo(7);
        assertThat(LLd.get(3)).isEqualTo(8);

    }

    @Test
    public void testrecursiveget(){
        Deque61B<Integer> LLd = new LinkedListDeque61B<>();
        LLd.addFirst(0);
        LLd.addFirst(4);
        LLd.addLast(7);
        LLd.addLast(8);  
        
        assertThat(LLd.getRecursive(0)).isEqualTo(4);
        assertThat(LLd.getRecursive(1)).isEqualTo(0);
        assertThat(LLd.getRecursive(2)).isEqualTo(7);
        assertThat(LLd.getRecursive(3)).isEqualTo(8);

    }
}