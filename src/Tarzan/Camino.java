package Tarzan;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Camino implements Comparable<Camino>{
	private int[] distancias;
	private int[] camino;
	
	
	public Camino(int[] camino2, int[] dist) {
		this.camino = camino2;
		this.distancias = dist;
	}


	@Override
	public int compareTo(Camino o) {
//		if( this.distancias[distancias.length-1] - o.distancias[distancias.length-1] == 0 )
//			return 1;
		return this.distancias[distancias.length-1] - o.distancias[distancias.length-1];
	}
	
	
	public Queue<Arista> obtenerCamino() {
		LinkedBlockingQueue<Arista> camino = new LinkedBlockingQueue<Arista>();
		int nodoEnElQueEstoyParado = this.distancias.length-1;
		while (nodoEnElQueEstoyParado != 0) {
			camino.add(new Arista( 
					this.camino[nodoEnElQueEstoyParado],
					nodoEnElQueEstoyParado,1));
			
			nodoEnElQueEstoyParado = this.camino[nodoEnElQueEstoyParado];
		}
		return camino;
	}
	
	
}
