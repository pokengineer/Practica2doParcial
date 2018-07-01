package colectivoEscolar;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Dijkstra {
	private static int INFINITO = 9999;
	private int[][] mat;
	private int[] dist;
	private int[] camino;
	private int inicio;

	public Dijkstra(int[][] matNoDirigida) {
		this.mat = matNoDirigida.clone();
		this.dist = new int[this.mat.length];
		this.camino = new int[this.mat.length];
		
		for(int i = 0; i< mat.length; i++)
		{
			for(int j=0; j<mat.length; j++)
			{
				if( mat[i][j] == 0 )
					mat[i][j] = INFINITO;
			}
		}
		
	}

	public void dijkstra(int inicio) {
		this.inicio = inicio;
		Set<Integer> nodosRestantes = new HashSet<Integer>();
		// PriorityQueue<Arista> aristasRestantes = new PriorityQueue<Arista>();
		int nodo = inicio;

		for (int i = 0; i < this.dist.length; i++) {
			if (this.mat[inicio][i] != 0) {
				dist[i] = this.mat[inicio][i];
				camino[i] = inicio;
				// aristasRestantes.add(new Arista( inicio, i, this.mat[inicio][i]) );

			} else {
				dist[i] = INFINITO;
			}
			nodosRestantes.add(i);
		}

		nodosRestantes.remove(inicio);

		while (!nodosRestantes.isEmpty()) {
			// busco minimo
			int valorMinimo = INFINITO;
			for (Integer item : nodosRestantes) {
				if (dist[item] < valorMinimo) {
					nodo = item;
					valorMinimo = dist[item];
				}
			}

			// saco el que ya estoy recorriendo
			nodosRestantes.remove(nodo);

			// me fijo si puedo mejorar algun camino desde aca
			for (Integer item : nodosRestantes) {
				if (dist[nodo] + mat[nodo][item] < dist[item]) {
					dist[item] = dist[nodo] + mat[nodo][item];
					camino[item] = nodo;
				}
			}
		}

	}

	public Queue<Arista> obtenerCamino(int escuela) {
		LinkedBlockingQueue<Arista> camino = new LinkedBlockingQueue<Arista>();
		int nodoEnElQueEstoyParado = escuela;
		while (nodoEnElQueEstoyParado != inicio) {
			camino.add(new Arista( 
					this.camino[nodoEnElQueEstoyParado],
					nodoEnElQueEstoyParado,
					mat[this.camino[nodoEnElQueEstoyParado]][nodoEnElQueEstoyParado]));
			
			nodoEnElQueEstoyParado = this.camino[nodoEnElQueEstoyParado];
		}
		return camino;
	}

}
