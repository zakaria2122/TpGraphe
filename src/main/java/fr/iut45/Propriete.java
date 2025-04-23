package fr.iut45;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Propriete {

    public Object getString(Graph<String> g) {
        return null; // en attente de ton implémentation
    }

    public int getDegreMax(Graph<String, DefaultEdge> graphEntrainement){
        List<String> sommets = new ArrayList<>(graphEntrainement.vertexSet());
        int max = 0;
        int index = 0;
        for(int i = 0; i < sommets.size(); i++){
            String sommet = sommets.get(i);
            int degre = graphEntrainement.degreeOf(sommet);
            if (degre > max) {
                max = degre;
                index = i;
            }
        }
        return index;
    }

    // Méthode main pour tester
    public static void main(String[] args) {
        Graph<String, DefaultEdge> graph = Exo.exo1(); // on appelle le graphe de Exo
        Propriete p = new Propriete();
        int indexMax = p.getDegreMax(graph);
        System.out.println("Indice du sommet ayant le plus grand degré : " + indexMax);
    }
}
