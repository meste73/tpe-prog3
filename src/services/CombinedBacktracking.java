package services;

import java.util.ArrayList;
import java.util.LinkedList;

import structures.Arco;
import utils.Status;

public class CombinedBacktracking extends Backtracking {
	
	@Override
	public ArrayList<Arco<Integer>> backtracking(LinkedList<Arco<Integer>> archs) {
		this.counter++;
		Status status = new Status();
		Greedy greedy = new Greedy();
		super.solution = greedy.greedy(new LinkedList<>(archs));
		super.solutionDistance = greedy.getDistance();
		this.counter += greedy.getCounter();
		status.setTunnels(archs);
		super.backtracking(status);
		return this.solution;
	}
}
