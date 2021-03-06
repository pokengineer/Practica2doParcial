package centralesElectricas;

import java.util.ArrayList;
import java.util.PriorityQueue;

import metro.Arista;

public class Prim {
	private static int INFINITO = 9999;
	private int[][] grafo;

	public Prim(int[][] mat) {
		this.grafo = mat.clone();

		for (int i = 0; i < this.grafo.length; i++) {
			for (int j = 0; j < this.grafo.length; j++) {
				if (this.grafo[i][j] == 0 && i != j)
					this.grafo[i][j] = INFINITO;
			}
		}
	}

	public ArrayList<Arista> prim(ArrayList<Integer> centrales) {
		ArrayList<Arista> arbol = new ArrayList<Arista>();
		PriorityQueue<Arista> aristasRestantes = new PriorityQueue<Arista>();
		boolean[] nodosRecorridos = new boolean[this.grafo.length];

		// for (int i = 0; i < this.grafo.length; i++) {
		// if (this.grafo[nodoInicial][i] != INFINITO && this.grafo[nodoInicial][i] !=
		// 0)
		// aristasRestantes.add(new Arista(nodoInicial, i, this.grafo[nodoInicial][i]));
		// nodosRecorridos[i] = false;
		// }

		for (int i = 0; i < this.grafo.length; i++) {
			nodosRecorridos[i] = false;
		}

		for (Integer i : centrales) {
			// no hace falta que recorra las centrales
			nodosRecorridos[i] = true;
			// agrego lo de aristas restantes
			for (int j = 0; j < this.grafo.length; j++) {
				if (this.grafo[i][j] != INFINITO && this.grafo[i][j] != 0)
					aristasRestantes.add(new Arista(i, j, this.grafo[i][j]));

			}
		}

		Arista aristaActual;
		int nodoActual;
		while (!aristasRestantes.isEmpty()) {
			aristaActual = aristasRestantes.poll();
			nodoActual = aristaActual.getNd();
			if (!nodosRecorridos[nodoActual]) {
				nodosRecorridos[nodoActual] = true;

				arbol.add(aristaActual);

				for (int i = 0; i < this.grafo.length; i++) {
					if (this.grafo[nodoActual][i] != INFINITO && nodoActual != i)
						aristasRestantes.add(new Arista(nodoActual, i, this.grafo[nodoActual][i]));
				}
			}
		}
		return arbol;
	}

}