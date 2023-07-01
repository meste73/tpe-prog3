package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import services.BfsCheck;
import structures.Arco;
import structures.Grafo;
import structures.GrafoNoDirigido;

public class Status {
	
	protected ArrayList<Arco<Integer>> solution;
	private Grafo<Integer> graph;
	private int distance = 0;
	private LinkedList<Arco<Integer>> tunnels;
	private BfsCheck<Integer> bfsService;
	
	public Status() {
		this.tunnels = new LinkedList<>();
		this.graph = new GrafoNoDirigido<>();
		this.solution = new ArrayList<>();
	}
	
	public Arco<Integer> getFirstPositionTunnel(){
		return this.tunnels.getFirst();
	}
	
	public ArrayList<Arco<Integer>> getSolution(){
		return this.solution;
	}
	
	public boolean isBetterSolution(int distance) {
		return this.distance < distance;
	}
	
	public boolean isSolution() {
		this.bfsService = new BfsCheck<>(this.graph);
		return this.bfsService.bfsForest();
	}
	
	public boolean tunnelsExceededLimit() {
		return this.solution.size() >= this.graph.cantidadVertices();
	}
	
	public boolean tunnelsEmpty() {
		return this.tunnels.isEmpty();
	}

	public int getDistance() {
		return this.distance;
	}
	
	public Iterator<Integer> getStations(){
		return this.graph.obtenerVertices();
	}
	
	public LinkedList<Arco<Integer>> getTunnels(){
		return this.tunnels;
	}
	
	public void addFirstPositionTunnel(Arco<Integer> tunnel) {
		this.tunnels.addFirst(tunnel);
	}	
	
	public void addToSolution(Arco<Integer> tunnel) {
		this.solution.add(tunnel);
		addTunnelToGraph(tunnel);
	}
	
	public void addTunnelToGraph(Arco<Integer> tunnel) {
		this.graph.agregarArco(tunnel.getVerticeOrigen(), tunnel.getVerticeDestino(), tunnel.getEtiqueta());
	}
	
	public void removeFirstPositionTunnel() {
		this.tunnels.removeFirst();
	}
	
	public void removeLastFromSolution(Arco<Integer> tunnel) {
		this.graph.borrarArco(tunnel.getVerticeOrigen(), tunnel.getVerticeDestino());
		this.solution.remove(this.solution.size()-1);
	}

	public void setTunnels(LinkedList<Arco<Integer>> tunnels) {
		this.tunnels = tunnels;
		graphGenerator();
	}

	public void setDistance(int i) {
		this.distance = i;
	}
	
	public void updateDistance(int distance) {
		this.distance += distance;
	}
	
	private void graphGenerator() {
		Iterator<Arco<Integer>> tunnelIt = this.tunnels.iterator();
		while(tunnelIt.hasNext()) {
			Arco<Integer> tunnel = tunnelIt.next();
			this.graph.agregarVertice(tunnel.getVerticeOrigen());
			this.graph.agregarVertice(tunnel.getVerticeDestino());
		}
	}
}
