package elGusano;

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
		return this.dist;
	}

}
