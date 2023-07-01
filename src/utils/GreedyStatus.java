package utils;
import java.util.Collections;
import java.util.HashSet;

import structures.Arco;

public class GreedyStatus extends Status{
	
	private HashSet<Integer> stations;
	
	public GreedyStatus() {
		super();
		this.stations = new HashSet<>();
	}
	
	public void orderTunnels() {
		TunnelComparator comparator = new TunnelComparator();
		Collections.sort(super.getTunnels(), comparator);
	}
	
	public void resetDistance() {
		super.setDistance(99999999);
	}
	
	@Override
	public void addToSolution(Arco<Integer> tunnel) {
		super.addToSolution(tunnel);
		this.stations.add(tunnel.getVerticeOrigen());
		this.stations.add(tunnel.getVerticeDestino());
	}

	public boolean isViable(Arco<Integer> tunnel) {
		
		if(!this.stations.contains(tunnel.getVerticeOrigen()) && 
		   !this.stations.contains(tunnel.getVerticeDestino()) && 
		   super.getSolution().size() == 0) {
			return true;
		} else if(!this.stations.contains(tunnel.getVerticeOrigen()) && this.stations.contains(tunnel.getVerticeDestino())) {
			return true;
		} else if(this.stations.contains(tunnel.getVerticeOrigen()) && !this.stations.contains(tunnel.getVerticeDestino())) {
			return true;
		}
		return false;
	}

}
