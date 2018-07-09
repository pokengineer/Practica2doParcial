package Tarzan;

import java.io.*;
import java.util.*;

public class Solucion {
	private int[][] mat;
	private Camino caminoFinal;
	private ArrayList<Arista> saltosTurbo;

	public Solucion(String string) {
		this.saltosTurbo = new ArrayList<Arista>();
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
							this.saltosTurbo.add(new Arista(item.getId(), aux.getId(), 1000));
						}
					}
				}
				arboles.add(aux);
				i++;
			}
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

	private void resolver() {
		Dijkstra d = new Dijkstra(this.mat);
		PriorityQueue<Camino> caminosPosibles = new PriorityQueue<Camino>();

		for (Arista turbo : this.saltosTurbo) {
			d.agregarArista(turbo);
			caminosPosibles.add(d.dijkstra(0));
			d.quitarArista(turbo);
		}

		this.caminoFinal = caminosPosibles.poll();
	}

	private void imprimir(String string) {
		Queue<Arista> laPosta = this.caminoFinal.obtenerCamino();
		Arista item;
		while (!laPosta.isEmpty()) {
			item = laPosta.poll();
			System.out.println(item.getNo() + " " + item.getNd());
		}
		// tiene que pasar por los nodos 0 - 4 - 5 - 6 - 7 - 1F0
	}

}
