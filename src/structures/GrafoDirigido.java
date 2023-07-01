package structures;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashSet<Integer> vertices;
	private HashSet<Arco<T>> arcos;
	
	/**
	 * O(1)
	 * Es O(1), donde 1 son los new de los hashset. 
	 */
	public GrafoDirigido() {

		this.vertices = new HashSet<Integer>();
		this.arcos = new HashSet<Arco<T>>();
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es el agregado de verticeId al HashMap.
	 */
	@Override
	public void agregarVertice(int verticeId) {
		
		this.vertices.add(verticeId);
	}

	/**
	 * O(n) 
	 * Es O(n), donde n es la cantidad de arcos del grafo. Para los
	 * metodos .contains() y .iterator() es O(1), por lo tanto no aumenta la
	 * complejidad.
	 */
	@Override
	public void borrarVertice(int verticeId) {

		if (this.vertices.contains(verticeId)) {
			this.vertices.remove(verticeId);
			Iterator<Arco<T>> iteradorArcos = this.arcos.iterator();

			while (iteradorArcos.hasNext()) {
				Arco<T> arco = iteradorArcos.next();

				if (arco.getVerticeDestino() == verticeId || arco.getVerticeOrigen() == verticeId) {
					iteradorArcos.remove();
				}
			}
		}
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es el add del arco, cada metodo contieneVertice()
	 * tambien es 1.
	 */
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		
		if (this.vertices.contains(verticeId1) && this.vertices.contains(verticeId2)) {
			this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
		}
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es el borrado del arco, metodo contains() es 1 e
	 * instancia de arco es 1.
	 */
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		
		Arco<T> arco = new Arco<T>(verticeId1, verticeId2, null);
		
		if (this.arcos.contains(arco)) {
			this.arcos.remove(arco);
		}
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es el metodo containsKey().
	 */
	@Override
	public boolean contieneVertice(int verticeId) {
		
		return this.vertices.contains(verticeId);
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es la instancia de arco, contains tambien es 1.
	 */
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {

		return this.arcos.contains(new Arco<T>(verticeId1, verticeId2, null));
	}

	/**
	 * O(n) 
	 * Es O(n), donde n son los arcos totales del grafo. El metodo iterator()
	 * es 1, por lo tanto no aumenta la complejidad.
	 */
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		
		Iterator<Arco<T>> iteratorArcos = this.arcos.iterator();
		Arco<T> arcoCheck = new Arco<T>(verticeId1, verticeId2, null);
		
		while (iteratorArcos.hasNext()) {
			Arco<T> arcoIt = iteratorArcos.next();
			
			if (arcoIt.equals(arcoCheck))
				return arcoIt;
		}
		return null;
	}

	/**
	 * O(1) 
	 * Es O(1) donde 1 es la consulta al metodo size().
	 */
	@Override
	public int cantidadVertices() {
		
		return this.vertices.size();
	}

	/**
	 * O(1) 
	 * Es O(1) donde 1 es la consulta al metodo size().
	 */
	@Override
	public int cantidadArcos() {
		
		return this.arcos.size();
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es el metodo .iterator();
	 */
	@Override
	public Iterator<Integer> obtenerVertices() {
		
		return this.vertices.iterator();
	}

	/**
	 * O(n) 
	 * Es O(n), donde n son los arcos totales del grafo, obtener el iterador de
	 * arcos es O(1), por lo tanto no aumenta la complejidad.
	 */
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		
		HashMap<Integer, String> verticesAdyacentes = new HashMap<>();
		Iterator<Arco<T>> iteradorArco = obtenerArcos(verticeId);
		
		while (iteradorArco.hasNext()) {
			Arco<T> arco = iteradorArco.next();
			verticesAdyacentes.put(arco.getVerticeDestino(), null);
		}
		return verticesAdyacentes.keySet().iterator();
	}

	/**
	 * O(1) 
	 * Es O(1), donde 1 es el metodo .iterator();
	 */
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		
		return this.arcos.iterator();
	}

	/**
	 * O(n) 
	 * Es O(n), donde n son los arcos totales del grafo, obtener el iterador de
	 * arcos es O(1), por lo tanto no aumenta la complejidad.
	 */
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		
		HashSet<Arco<T>> resultado = new HashSet<>();
		Iterator<Arco<T>> iteradorArco = obtenerArcos();
		
		while (iteradorArco.hasNext()) {
			Arco<T> arco = iteradorArco.next();
			
			if (arco.getVerticeOrigen() == verticeId) {
				resultado.add(arco);
			}
		}
		return resultado.iterator();
	}

}
