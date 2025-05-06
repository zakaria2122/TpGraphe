package fr.iut45;

import java.io.File;

import java.io.IOException;



import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.nio.csv.CSVImporter;

import org.jgrapht.util.SupplierUtil;

public class Exo {

	public static Graph<String, DefaultEdge> loadHeroes() {
		Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(SupplierUtil.createStringSupplier(1),
				SupplierUtil.DEFAULT_EDGE_SUPPLIER, false);
		CSVImporter<String, DefaultEdge> importer = new CSVImporter<>(CSVFormat.EDGE_LIST);
		importer.setVertexFactory(id -> id);
		importer.importGraph(graph, new File("extrait_marvel.csv"));
		return graph;
	}


	public static Graph<String, DefaultEdge> exo1(){
		Graph<String, DefaultEdge> graphSimple = new DefaultUndirectedGraph<>(SupplierUtil.createStringSupplier(1),
				SupplierUtil.DEFAULT_EDGE_SUPPLIER, false);

		String chaine = "abcde";
	
		for (int i  = 0; i< chaine.length();i++){
			graphSimple.addVertex(String.valueOf(chaine.charAt(i)));
		} 
		        // Ajout des arêtes (exemple : a-b, a-c, b-c, c-d, d-e)
				graphSimple.addEdge("a", "b");
				graphSimple.addEdge("a", "c");
				graphSimple.addEdge("b", "c");
				graphSimple.addEdge("c", "d");
				graphSimple.addEdge("d", "e");

				return graphSimple;
	}

	public static void main(String[] args) throws IOException {
		Graph<String, DefaultEdge> graph;
		
		//graph = loadHeroes();
		graph = exo1();
		System.out.println(graph);
		/*Set<String> inactifs = new HashSet<>();
		for( String v : graph.vertexSet()){
			if(graph.degreeOf(v)<20)
				inactifs.add(v);
		}
		graph.removeAllVertices(inactifs);
		*/


		// DOTExporter<String, DefaultEdge> exporter = new DOTExporter<String, DefaultEdge>();
		// exporter.setVertexAttributeProvider((x) -> Map.of("label", new DefaultAttribute<>(x, AttributeType.STRING)));
		// exporter.exportGraph(graph, new FileWriter("graph.dot"));
	}
}