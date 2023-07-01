package structures;
public class GrafoNoDirigido<T> extends GrafoDirigido<T> {
	
	/**
	 * Misma complejidad que el metodo que sobreescribe.
	 */
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	/**
	 * Misma complejidad que el metodo que sobreescribe.
	 */
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}
	
	/**
	 * Misma complejidad que el metodo que sobreescribe.
	 */
	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}

}
