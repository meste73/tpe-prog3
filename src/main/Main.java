package main;

import java.util.ArrayList;
import java.util.LinkedList;

import services.Backtracking;
import services.CombinedBacktracking;
import services.Greedy;
import structures.Arco;
import utils.CSVReader;
import utils.Constants;

public class Main {
	
	public static void main(String[] args) {
		
		CSVReader reader = new CSVReader(Constants.PATH_DATASET_2);
		LinkedList<Arco<Integer>> archs = reader.read();

		Backtracking back = new Backtracking();
		Greedy greedy = new Greedy();
		Backtracking cback = new CombinedBacktracking();
		
		ArrayList<Arco<Integer>> backSolution = back.backtracking(new LinkedList<>(archs));
		ArrayList<Arco<Integer>> greedySolution = greedy.greedy(new LinkedList<>(archs));
		ArrayList<Arco<Integer>> cbackSolution = cback.backtracking(new LinkedList<>(archs));
		
		printSolution(backSolution, Constants.BACKTRACKING, back.getDistance(), back.getCounter());
		printSolution(greedySolution, Constants.GREEDY, greedy.getDistance(), greedy.getCounter());
		printSolution(cbackSolution, Constants.BACK_GREEDY, cback.getDistance(), cback.getCounter());
		
	}
	
	private static void printSolution(ArrayList<Arco<Integer>> solution, String service, int distance, long steps) {
		System.out.println(service);
		for(Arco<Integer> a: solution) {
			System.out.println(a);
		}
		System.out.println("Distancia total de tuneles: " + distance + "km.");
		System.out.println("Cantidad total de pasos: " + steps + ".\n");
	}
}
