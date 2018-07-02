package elGusano;

import java.util.*;

public class Dijkstra {
	private static int INFINITO = 99999;
	private int[][] mat;
	private int[] dist;

	public Dijkstra(int[][] obj) {
		this.mat = obj.clone();
		this.dist = new int[obj.length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] == 0 && i != j) {
					mat[i][j] = INFINITO;
				}
			}
		}
	}

	public int[] dijkstra(int nodoInicial) {
		// hacer Dijkstra :P
		HashSet<Integer> nodosRestantes = new HashSet<Integer>();

		for (int i = 0; i < this.dist.length; i++) {
			this.dist[i] = this.mat[nodoInicial][i];
			nodosRestantes.add(i);
		}

		nodosRestantes.remove(nodoInicial);

		while (!nodosRestantes.isEmpty()) {
			int nodoMin = 0, min = INFINITO;
			for (Integer item : nodosRestantes) {
				if (dist[item] < min) {
					nodoMin = item;
					min = dist[item];
				}
			}
			
			nodosRestantes.remove(nodoMin);

			for(Integer item : nodosRestantes)
			{
				if( this.dist[nodoMin] + this.mat[nodoMin][item] < this.dist[item] )
				{
					this.dist[item] = this.dist[nodoMin] + this.mat[nodoMin][item];
				}
			}
		}

		return this.dist;
	}

}
