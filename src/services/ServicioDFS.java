package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import structures.Grafo;
import utils.Constants;

public class ServicioDFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> vertices;
	private ArrayList<Integer> dfsResult;

	public ServicioDFS(Grafo<?> grafo) {
		
		this.dfsResult = new ArrayList<>();
		this.grafo = grafo;
		this.vertices = new HashMap<>();
	}

	public List<Integer> dfsForest() {

		Iterator<Integer> iteratorVertice = grafo.obtenerVertices();
		
		setHashMapWhite();
		
		while (iteratorVertice.hasNext()) {
			Integer keyVertice = iteratorVertice.next();
			if (vertices.get(keyVertice).equals(Constants.WHITE)) {
				dfsVisit(keyVertice);
			}
		}
		
		return this.dfsResult;
	}

	private void dfsVisit(Integer vertice) {

		Integer keyVertice = null;
		Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(vertice);
		
		this.dfsResult.add(vertice);
		this.vertices.replace(vertice, Constants.YELLOW);
		
		while (iteratorAdyacentes.hasNext()) {
			keyVertice = iteratorAdyacentes.next();
			if (this.vertices.get(keyVertice).equals(Constants.WHITE)) {
				dfsVisit(keyVertice);
			}
		}
		this.vertices.replace(keyVertice, Constants.BLACK);
	}
	
	private void setHashMapWhite() {
		
		Iterator<Integer> iteratorVertice = grafo.obtenerVertices();

		while (iteratorVertice.hasNext()) {
			vertices.put(iteratorVertice.next(), Constants.WHITE);
		}
	}
}
