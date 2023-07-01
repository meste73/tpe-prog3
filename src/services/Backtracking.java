package services;
import java.util.ArrayList;
import java.util.LinkedList;

import structures.Arco;
import utils.Status;

public class Backtracking {
	
	protected ArrayList<Arco<Integer>> solution;
	protected int solutionDistance = 999999;
	protected long counter = 0;
	
	public Backtracking() {
		this.solution = new ArrayList<>();
	}
	
	public ArrayList<Arco<Integer>> backtracking(LinkedList<Arco<Integer>> archs) {
		this.counter++;
		Status status = new Status();
		status.setTunnels(archs);
		backtracking(status);
		return this.solution;
	}
	
	protected void backtracking(Status status) {
		this.counter++;
		if(status.tunnelsEmpty()) {
			if(status.isSolution() && status.isBetterSolution(this.solutionDistance)) {
				this.solutionDistance = status.getDistance();
				this.solution = new ArrayList<>(status.getSolution());
			}
		} else {

			Arco<Integer> tunnel = status.getFirstPositionTunnel();
			
			status.removeFirstPositionTunnel();
			status.addToSolution(tunnel);
			status.updateDistance(tunnel.getEtiqueta());
			
			if(status.getDistance() < this.solutionDistance && !status.tunnelsExceededLimit()) {
				backtracking(status);
			}
			status.removeLastFromSolution(tunnel);
			status.updateDistance(-tunnel.getEtiqueta());
			
			backtracking(status);
			status.addFirstPositionTunnel(tunnel);
		}
	}

	public int getDistance() {
		return this.solutionDistance;
	}
	
	public long getCounter() {
		return this.counter;
	}
}
