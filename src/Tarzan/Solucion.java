package Tarzan;

import java.io.*;
import java.util.*;

public class Solucion {
	private int[][] mat;
	private Stack<Nodo> caminoFinal;

	public Solucion(String string) {
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		ArrayList<Arbol> arboles = new ArrayList<Arbol>();
		/////////// lo cargo ///////////
		try {
			Scanner sc = new Scanner(new File(string));
			int x, y;
			Arbol aux;
			while (sc.hasNextLine()) {
				x = sc.nextInt();
				y = sc.nextInt();
				aux = new Arbol(x, y);

				for (Arbol item : arboles) {
					if (item.distancia(aux) <= 100) {
						if (item.distancia(aux) <= 50) {
							aristas.add(new Arista(1, 1, 1));
						} else {
							aristas.add(new Arista(1, 1, 1000));
						}
					}
				}
				arboles.add(aux);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/////////// lo paso a una matriz///////////
		this.mat = new int[arboles.size()][arboles.size()];
		for (Arista item : aristas) {
			this.mat[item.getNo()][item.getNd()] = item.getValue(); 
		}
	}

	public static void main(String[] args) {
		Solucion s = new Solucion("tarzan.in");
		s.resolver();
		s.imprimir("tarzan.out");
	}

	private void imprimir(String string) {

	}

	private void resolver() {

	}

}
