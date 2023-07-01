package main;
import java.util.ArrayList;
import java.util.List;

import services.ServicioBFS;
import services.ServicioCaminos;
import services.ServicioDFS;
import structures.GrafoDirigido;

public class TestMain {
	public static void main(String[] args) {
		
		testGrafoDFS();
		testGrafoBFS();
		testCaminos();
		//testDeleteVertice();
		
	}

	public static void testGrafoDFS() {
		
		GrafoDirigido<String> grafo = new GrafoDirigido<>();
		creadorGrafo(grafo);		
		
		ServicioDFS servicioDFS = new ServicioDFS(grafo);
		ArrayList<Integer> resultadoDFS = new ArrayList<>();
		resultadoDFS.addAll(servicioDFS.dfsForest());
		System.out.println(resultadoDFS);
	
	}
	
	public static void testGrafoBFS() {
		
		GrafoDirigido<String> grafo = new GrafoDirigido<>();
		creadorGrafo(grafo);
		
		ServicioBFS servicioDFS = new ServicioBFS(grafo);
		ArrayList<Integer> resultadoDFS = new ArrayList<>();
		resultadoDFS.addAll(servicioDFS.bfsForest());
		System.out.println(resultadoDFS);
	}
	
	public static void testCaminos() {
		
		GrafoDirigido<String> grafo = new GrafoDirigido<>();
		creadorGrafo(grafo);
		
		ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, 1,7,6);
		List<List<Integer>> result = new ArrayList<>();
		result = servicioCaminos.caminos();
		System.out.println(result);
	}
	
	public static void testDeleteVertice() {
		
		GrafoDirigido<String> grafo = new GrafoDirigido<>();
		creadorGrafo(grafo);
		grafo.borrarVertice(3);
		System.out.println(grafo.obtenerArco(2, 3));
		System.out.println(grafo.contieneVertice(3));
	}
	
	public static void creadorGrafo(GrafoDirigido<String> grafo) {
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		grafo.agregarVertice(8);
		
		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(1, 5, null);
		grafo.agregarArco(5, 6, null);
		grafo.agregarArco(5, 7, null);
		grafo.agregarArco(6, 7, null);
		grafo.agregarArco(4, 2, null);
		grafo.agregarArco(4, 7, null);
		grafo.agregarArco(7, 8, null);
		grafo.agregarArco(2, 8, null);
		grafo.agregarArco(2, 3, null);
		grafo.agregarArco(8, 7, null);
		grafo.agregarArco(3, 2, null);
		grafo.agregarArco(2, 4, null);
		grafo.agregarArco(3, 8, null);
		
	}
}
