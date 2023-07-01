package utils;
import java.util.Comparator;

import structures.Arco;

public class TunnelComparator implements Comparator<Arco<Integer>>{

	@Override
	public int compare(Arco<Integer> t1, Arco<Integer> t2) {
		return t1.getEtiqueta()-t2.getEtiqueta();
	}

}
