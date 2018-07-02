package inspecionandoLaReserva;

public class Bfs {
	private boolean[][] grafo;
	
	public Bfs(int[][] mat) {
		this.grafo = new boolean[mat.length][mat.length];
		for(int i = 0; i< mat.length ; i++ )
		{
			for(int j = 0; j< mat.length ; j++ )
			{
				this.grafo[i][j] = (mat[i][j] == 1);
			}
		}
	}

	public int numberOfPaths() {
		//aca meto el BFS
		//con una pila recorro recorridos posibles nomas
		return 0;
	}
}
