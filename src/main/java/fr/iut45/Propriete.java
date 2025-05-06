package fr.iut45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Propriete {

    // public Object getString(Graph<String> g) {
    //     return null; // en attente de ton implémentation
    // }

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

    public int getNbTriangles(Graph<String, DefaultEdge> graph){

        List<String> v = new  ArrayList<>(graph.vertexSet());
        int triangleCount = 0;

        for (int i =0; i< v.size()-2; i++){
            String a = v.get(i);
            for(int j = i +1; j < v.size()-1; j++){
                String b = v.get(j);
                for(int k = j+1; k< v.size(); k++){
                    String c = v.get(k);

                    if (graph.containsEdge(b,c) && graph.containsEdge(c, a) && graph.containsEdge(b, c)){
                        triangleCount++;
                    }

                }
            }
        }
        return triangleCount;
    }


    public boolean estChaine(Graph<String, DefaultEdge> graph, List<String> chaine){
        if (chaine == null || chaine.isEmpty() || chaine.size() == 1) {
            return true;
        }
        Set<String> v = graph.vertexSet();
        for(String vertex : chaine){
            if (!v.contains(vertex)) {
                return false;
            }
        }
        for(int i =0; i< chaine.size() -1; i++){
            String u = chaine.get(i);
            String ve = chaine.get(i+1);
            if(!graph.containsEdge(u,ve)){
                return false;
            }
        }
        return true;
    }

// Updated main method to test getNbTriangles
public static void main(String[] args) {
    // Load the graph from Exo.exo1()
    Graph<String, DefaultEdge> graph = Exo.exo1();
    Propriete p = new Propriete();

    // Test getDegreMax (existing functionality)
    int indexMax = p.getDegreMax(graph);
    System.out.println("Indice du sommet ayant le plus grand degré : " + indexMax);

    // Test getNbTriangles
    int triangleCount = p.getNbTriangles(graph);
    System.out.println("Nombre de triangles dans le graphe : " + triangleCount);

List<String> chaine = Arrays.asList("a", "b", "c");
        boolean estChaine = p.estChaine(graph, chaine);
        System.out.println("La séquence " + chaine + " est une chaîne : " + estChaine);
    }
}

