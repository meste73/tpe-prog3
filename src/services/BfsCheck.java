package services;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import structures.Grafo;
import utils.Constants;

public class BfsCheck<T> {
	
	private Grafo<T> graph;
	private HashMap<Integer, String> stations;
	private LinkedList<Integer> queue;
	private int counter = 0;
	
	public BfsCheck(Grafo<T> graph) {

		this.graph = graph;
		this.queue = new LinkedList<>();
		this.stations = new HashMap<>();
	}
	
	public boolean bfsForest() {
				
		setHashMapNotVisited();

		return bfsForest(this.graph.obtenerVertices().next());
	}

	private boolean bfsForest(Integer station) {

		this.stations.replace(station, Constants.VISITED);
		this.counter++;
		this.queue.addLast(station);

		while (!this.queue.isEmpty()) {
			Integer queueStation = this.queue.removeFirst();
			Iterator<Integer> adyStations = this.graph.obtenerAdyacentes(queueStation);
			while (adyStations.hasNext()) {
				queueStation = adyStations.next();
				if (this.stations.get(queueStation).equals(Constants.NOT_VISITED)) {
					this.stations.replace(queueStation, Constants.VISITED);
					this.counter++;
					this.queue.addLast(queueStation);
				}
			}
		}
		return areAllVisited();
	}
	
	private boolean areAllVisited() {
		return this.counter == this.stations.size();
	}
	
	private void setHashMapNotVisited() {
		
		Iterator<Integer> stations = graph.obtenerVertices();

		while (stations.hasNext()) {
			this.stations.put(stations.next(), Constants.NOT_VISITED);
		}
	}
}
