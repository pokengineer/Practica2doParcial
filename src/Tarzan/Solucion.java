package Tarzan;

import java.io.*;
import java.util.*;

public class Solucion {
	private int[][] mat;
	private Stack<Nodo> caminoFinal;
	private int nodoFinal;

	public Solucion(String string) {
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		ArrayList<Arbol> arboles = new ArrayList<Arbol>();
		/////////// lo cargo ///////////
		try {
			Scanner sc = new Scanner(new File(string));
			int x, y, i = 0;
			Arbol aux;
			while (sc.hasNextLine()) {
				x = sc.nextInt();
				y = sc.nextInt();
				aux = new Arbol(x, y, i);

				for (Arbol item : arboles) {
					if (item.distancia(aux) <= 100) {
						if (item.distancia(aux) <= 50) {
							aristas.add(new Arista(item.getId(), aux.getId(), 1));
						} else {
							aristas.add(new Arista(item.getId(), aux.getId(), 1000));
						}
					}
				}
				arboles.add(aux);
				i++;
			}
			nodoFinal = i;
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/////////// lo paso a una matriz///////////
		this.mat = new int[arboles.size()][arboles.size()];
		for (Arista item : aristas) {
			this.mat[item.getNo()][item.getNd()] = item.getValue();
			this.mat[item.getNd()][item.getNo()] = item.getValue();
		}
	}

	public static void main(String[] args) {
		Solucion s = new Solucion("tarzan.in");
		s.resolver();
		s.imprimir("tarzan.out");
	}

	private void imprimir(String string) {
		// imprimir camino final
	}

	private void resolver() {
		Dijkstra d = new Dijkstra(this.mat);

		// por cada arista de distancia 50-100 hago un dijkstra. me quedo con la mejor
		// de esas soluciones
	}

}
