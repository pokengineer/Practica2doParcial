package colectivoEscolar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Solucion {
	private int[][] matOriginal;
	private int[][] matNoDirigida;
	private int inicio;
	private int escuela;
	private int distancia;
	private LinkedBlockingQueue<Arista> cambios;

	public int[][] getMatNoDirigida() {
		return matNoDirigida;
	}

	public static void main(String[] args) {
		Solucion s = new Solucion();
		s.cargarMatriz();
		Dijkstra d = new Dijkstra(s.getMatNoDirigida());
		d.dijkstra(s.inicio);
		LinkedBlockingQueue<Arista> camino = (LinkedBlockingQueue<Arista>) d.obtenerCamino(s.escuela);
		s.verificarCamino( camino );
		//s.imprimir();
	}

	/**
	 * Carga la matriz desde el .in .
	 * 
	 */
	private void cargarMatriz() {
		try {
			Scanner s = new Scanner(new File("cambio.in"));
			int nodos = s.nextInt();
			this.inicio = s.nextInt() - 1;
			this.escuela = s.nextInt() - 1;
			this.matOriginal = new int[nodos][nodos];
			this.matNoDirigida = new int[nodos][nodos];
			int aristas = s.nextInt();
			int no;
			int nd;
			int value;
			for (int i = 0; i < aristas; i++) {
				no = s.nextInt() - 1;
				nd = s.nextInt() - 1;
				value = s.nextInt();
				this.matOriginal[no][nd] = value;
				this.matNoDirigida[no][nd] = value;
				this.matNoDirigida[nd][no] = value;
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * verifica camino, guarda los cambios en "cambios" y la distancia en
	 * "distancia"
	 * 
	 * @param camino
	 */
	private void verificarCamino(LinkedBlockingQueue<Arista> camino) {
		Arista aux;
		while( ! camino.isEmpty() )
		{
			aux = camino.poll();
			System.out.println( aux.getNo() + " " + aux.getNd() + " " + aux.getValue());
		}
	}

	/**
	 * imprime distancia y cambios en .out .
	 * 
	 */
	private void imprimir() {
		try {
			PrintWriter writer = new PrintWriter(new File("cambios.out"));
			writer.print( this.distancia );
			for(Arista item : this.cambios) {
				writer.print( item.getNo() + " " + item.getNd() );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


}
