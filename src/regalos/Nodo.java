package regalos;

import java.util.HashMap;
import java.util.Map;

public class Nodo {
	private int id;
	private Map<Integer, Nodo> nodos = new HashMap<Integer, Nodo>();

	
	public Nodo(int nodo) {
		this.id = nodo;
	}
	
	public void add( Nodo obj ) {
		this.nodos.put(obj.id , obj);
	}

}
