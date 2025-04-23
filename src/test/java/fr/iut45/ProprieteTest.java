package fr.iut45;
//import static org.junit.Assert.assertEquals;



import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Test;


public class ProprieteTest {

    @Test
    public void testExe(){
        Graph<String, DefaultEdge> g  = Exo.exo1();
        System.out.println(g);
        Propriete p = new Propriete();
        String s ="{a,b,c,d,e}, {a--b,a--c,b--c,b--a,c--a,c--b,c--d,d--e}";
        assertEquals(s,p.getString(g));
    }
}
    