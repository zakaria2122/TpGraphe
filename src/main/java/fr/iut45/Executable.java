package fr.iut45;

// import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.IOException;
// import java.util.HashSet;
import java.util.Map;
// import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
// import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.AttributeType;
import org.jgrapht.nio.DefaultAttribute;
// import org.jgrapht.nio.csv.CSVFormat;
// import org.jgrapht.nio.csv.CSVImporter;
import org.jgrapht.nio.dot.DOTExporter;
// import org.jgrapht.util.SupplierUtil;

public class Executable {

    public static void main(String[] args) throws IOException {
        // Création d'un graphe simple non orienté dont les sommets sont des chaînes de caractères
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        
        // Ajout des sommets
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");

        // Ajout des arêtes (exemple : a-b, a-c, b-c, c-d, d-e)
        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.addEdge("b", "c");
        graph.addEdge("c", "d");
        graph.addEdge("d", "e");


		DOTExporter<String, DefaultEdge> exporter = new DOTExporter<String, DefaultEdge>();
		exporter.setVertexAttributeProvider((x) -> Map.of("label", new DefaultAttribute<>(x, AttributeType.STRING)));
		exporter.exportGraph(graph, new FileWriter("graph.dot"));
	}

}
