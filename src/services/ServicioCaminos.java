package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import structures.Arco;
import structures.Grafo;
import utils.Constants;

public class ServicioCaminos{

	private Grafo<?> grafo;
	private HashMap<Arco<?>, String> arcos;
	private ArrayList<List<Integer>> caminos;

	private int origen;
	private int destino;
	private int lim;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {

		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.arcos = new HashMap<>();
		this.caminos = new ArrayList<>();
	}

	public List<List<Integer>> caminos() {

		setHashMapNotVisited();
		
		ArrayList<Integer> camino = new ArrayList<>();
		camino.add(this.origen);
		caminosService(this.origen, camino, 0);
		
		return this.caminos;
	}

	private void caminosService(Integer key, ArrayList<Integer> camino, int cantidadArcos) {

		if (key.equals(this.destino)) {
			this.caminos.add(new ArrayList<>(camino));
		} else {

			Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(key);
			
			while (iteratorAdyacentes.hasNext()) {
				Integer iteratorKey = iteratorAdyacentes.next();
				Arco<?> arcoAdy = this.grafo.obtenerArco(key, iteratorKey);

				if (cantidadArcos < this.lim && this.arcos.get(arcoAdy).equals(Constants.NOT_VISITED)) {
					this.arcos.replace(arcoAdy, Constants.VISITED);
					camino.add(iteratorKey);
					caminosService(iteratorKey, camino, cantidadArcos + 1);
					this.arcos.replace(arcoAdy, Constants.NOT_VISITED);
					camino.remove(camino.size() - 1);
				}
			}
		}
	}
	
	private void setHashMapNotVisited() {
		
		Iterator<?> iteratorArcos = this.grafo.obtenerArcos();

		while (iteratorArcos.hasNext()) {
			Arco<?> arco = (Arco<?>) iteratorArcos.next();
			this.arcos.put(arco, Constants.NOT_VISITED);
		}
	}
}
