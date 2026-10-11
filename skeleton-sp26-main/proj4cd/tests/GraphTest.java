package tests;
import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import main.Graph;



public class GraphTest {
    @Test 
    public void Testaddedge(){
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 2);
        g.addEdge(0, 8);
        g.addEdge(2 , 1); 

        ArrayList<Object> edge0 = new ArrayList<>();
        edge0.add(1);

        ArrayList<Object> edge1 = new ArrayList<>();
        edge1.add(2);

        ArrayList<Object> edge2 = new ArrayList<>();

        assertThat(g.adj(0)).containsExactly(1 , 2 , 8);
        assertThat(g.adj(1)).containsExactly(2);
        assertThat(g.adj(2)).containsExactly(1);
    }
}
