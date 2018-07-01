package elGusano;

import java.io.*;
import java.util.*;

public class Solucion {
	private int[][] mat;
	private ArrayList<Arista> aristas;
	private ArrayList<PcInfectada> infectadas;
	private Set<Integer> nodos;
	private ArrayList<Integer> posibles;

	public static void main(String[] args) {
		Solucion s = new Solucion();
		s.cargarmatriz("gusano.in");
		s.mostrarMatriz();
		s.resolver();
		s.imprimir("gusano.out");
	}

	private void cargarmatriz(String s) {
		try {
			Scanner sc = new Scanner(new File(s));
			this.nodos = new HashSet<Integer>();
			this.aristas = new ArrayList<Arista>();
			this.infectadas = new ArrayList<PcInfectada>();
			int cantAristas = sc.nextInt();
			int no, value, nd;

			for (int i = 0; i < cantAristas; i++) {
				no = sc.nextInt();
				nodos.add(no);
				value = sc.nextInt();
				nd = sc.nextInt();
				nodos.add(nd);
				this.aristas.add(new Arista(no - 1, nd - 1, value));
			}
			int cPcInfectadas = sc.nextInt();
			for (int i = 0; i < cPcInfectadas; i++) {
				nd = sc.nextInt();
				value = sc.nextInt();
				infectadas.add(new PcInfectada(nd, value));
			}
			sc.close();

			int max = 0;
			for (Integer n : nodos) {
				if (n > max)
					max = n;
			}

			this.mat = new int[max][max];

			for (Arista item : this.aristas) {
				mat[item.getNo()][item.getNd()] = item.getValue();
				mat[item.getNd()][item.getNo()] = item.getValue();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void resolver() {
		this.posibles = new ArrayList<Integer>();
		Dijkstra d = new Dijkstra(this.mat);
		int[] distancias;

		for (Integer n : nodos) {
			distancias = d.dijkstra(n);
			if (this.puedeSer(distancias))
				this.posibles.add(n);
		}

	}

	private boolean puedeSer(int[] distancias) {
		boolean es = true;
		for (PcInfectada item : this.infectadas) {
			if (distancias[item.getN()] != item.getValue())
				es = false;
		}
		return es;
	}

	private void imprimir(String string) {
		// imprime la lista de posibilidades en el archivo string
	}

	private void mostrarMatriz() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(this.mat[i][j] + "  ");
			}
			System.out.println("");
		}

	}

}
