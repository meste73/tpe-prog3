package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import structures.Grafo;
import utils.Constants;

public class ServicioBFS {

	private ArrayList<Integer> bfsResult;
	private Grafo<?> grafo;
	private HashMap<Integer, String> vertices;
	private LinkedList<Integer> queue;

	public ServicioBFS(Grafo<?> grafo) {

		this.bfsResult = new ArrayList<>();
		this.grafo = grafo;
		this.queue = new LinkedList<>();
		this.vertices = new HashMap<>();
	}

	public List<Integer> bfsForest() {

		Iterator<Integer> iteratorVertice = grafo.obtenerVertices();
		
		setHashMapNotVisited();

		while (iteratorVertice.hasNext()) {
			Integer keyVertice = iteratorVertice.next();
			if (this.vertices.get(keyVertice).equals(Constants.NOT_VISITED)) {
				bfsForest(keyVertice);
			}
		}

		return this.bfsResult;
	}

	private List<Integer> bfsForest(Integer vertice) {

		this.vertices.replace(vertice, Constants.VISITED);
		this.queue.addLast(vertice);
		this.bfsResult.add(vertice);

		while (!this.queue.isEmpty()) {
			Integer keyVertice = this.queue.removeFirst();
			Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(keyVertice);
			while (iteratorAdyacentes.hasNext()) {
				keyVertice = iteratorAdyacentes.next();
				if (this.vertices.get(keyVertice).equals(Constants.NOT_VISITED)) {
					this.vertices.replace(keyVertice, Constants.VISITED);
					this.queue.addLast(keyVertice);
					this.bfsResult.add(keyVertice);
				}
			}
		}
		
		return this.bfsResult;
	}
	
	private void setHashMapNotVisited() {
		
		Iterator<Integer> iteratorVertice = grafo.obtenerVertices();

		while (iteratorVertice.hasNext()) {
			vertices.put(iteratorVertice.next(), Constants.NOT_VISITED);
		}
	}
}
