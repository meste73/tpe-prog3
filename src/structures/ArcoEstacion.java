package structures;

public class ArcoEstacion<T> extends Arco<T>{

	public ArcoEstacion(int verticeOrigen, int verticeDestino, T etiqueta) {
		super(verticeOrigen, verticeDestino, etiqueta);
	}
	
	@Override
	public String toString() {
		return "Tunel de E" + super.getVerticeOrigen() + " a E" + super.getVerticeDestino() + ". Distancia: " + super.getEtiqueta()
				+ "km.";
	}
}
