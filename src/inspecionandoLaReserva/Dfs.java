package inspecionandoLaReserva;

import java.util.Stack;

public class Dfs {
	private boolean[][] grafo;

	public Dfs(int[][] mat) {
		this.grafo = new boolean[mat.length][mat.length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				this.grafo[i][j] = (mat[i][j] == 1);
			}
		}
	}

	public int numberOfPaths(int inicio, int nodoFinal) {
		Stack<Integer> nodosARecorrer = new Stack<Integer>();
		int cont = 0;
		int nodoActual;
		nodosARecorrer.push(inicio);
		while (!nodosARecorrer.isEmpty()) {
			nodoActual = nodosARecorrer.pop();

			if (nodoActual == nodoFinal) {
				cont++;
				continue;
			}

			for (int i = 0; i < this.grafo.length; i++) {
				if (this.grafo[nodoActual][i])
					nodosARecorrer.push(i);
			}

		}
		return cont;
	}
}
