package services;
import java.util.ArrayList;
import java.util.LinkedList;

import structures.Arco;
import utils.GreedyStatus;

public class Greedy {

	private GreedyStatus status;
	private int counter = 0;

	public Greedy() {
		this.status = new GreedyStatus();
	}

	public ArrayList<Arco<Integer>> greedy(LinkedList<Arco<Integer>> tunnels) {
		this.counter++;
		status.setTunnels(tunnels);
		status.orderTunnels();
		while(!status.tunnelsEmpty() && !status.isSolution()) {
			this.counter++;
			Arco<Integer> tunnel = status.getFirstPositionTunnel();
			status.removeFirstPositionTunnel();
			if(status.isViable(tunnel)) {
				status.addToSolution(tunnel);
				status.updateDistance(tunnel.getEtiqueta());
			}
		}
		if(status.isSolution()) {
			return this.status.getSolution();
		}
		this.status.resetDistance();
		return new ArrayList<>();
		
	}
	
	public int getDistance() {
		return this.status.getDistance();
	}
	
	public int getCounter() {
		return this.counter;
	}
}
