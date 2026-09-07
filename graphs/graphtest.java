package graphs;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;

public class graphtest {
    
    @Test 
    public void testcontractation(){
        graph g  = new graph(8);

        g.addEdge(0,1);
        g.addEdge(0, 2);

        assertThat(g.adj(1)).containsExactlyElementsIn(Arrays.asList(0));
        assertThat(g.adj(2)).containsExactlyElementsIn(Arrays.asList(0));
        assertThat(g.adj(0)).containsExactlyElementsIn(Arrays.asList(1 , 2));
    }

    @Test 
    public void testDFS(){
        graph g  = new graph(10);

        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(1,4);
        g.addEdge(2, 5);
        g.addEdge(5,4);
        g.addEdge(4, 3);
        g.addEdge(5,6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);

        Depthfirstpath DFS = new Depthfirstpath(g , 8 , 9);
        Depthfirstpath DFS2 = new Depthfirstpath(g , 8 , 3);


        assertThat(DFS.result()).isEqualTo(false);

        assertThat(DFS2.result()).isEqualTo(true);


    }


    @Test 
    public void testDFSPathto(){
        graph g  = new graph(10);

        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(1,4);
        g.addEdge(2, 5);
        g.addEdge(5,4);
        g.addEdge(4, 3);
        g.addEdge(5,6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);

        DFSpathto dfs = new DFSpathto(g, 0);

        assertThat(dfs.PathTo(g, 7)).containsExactly(7 , 6 , 5 , 2 , 1 , 0).inOrder();
        assertThat(dfs.PathTo(g, 9)).isEqualTo(null);

    }


    public static void main(String[] args){
        graph g  = new graph(8);

        g.addEdge(0,1);
        g.addEdge(0, 2);

        g.printgraph();
    }
}
