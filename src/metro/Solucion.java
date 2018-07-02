package metro;

import java.io.*;
import java.util.*;

public class Solucion {

	private int[][] mat;

	public int[][] getMat() {
		return mat;
	}

	public Solucion(String string) {
		try {
			Scanner sc = new Scanner(new File(string));
			int cantIslas = sc.nextInt();
			this.mat = new int[cantIslas][cantIslas];
			int cantTuneles = sc.nextInt();
			int cantPuentes = sc.nextInt();
			int no, nd;
			for (int i = 0; i < cantTuneles; i++) {
				no = sc.nextInt() - 1;
				nd = sc.nextInt() - 1;
				this.mat[no][nd] = this.mat[nd][no] = 1;
			}
			for (int i = 0; i < cantPuentes; i++) {
				no = sc.nextInt() - 1;
				nd = sc.nextInt() - 1;
				this.mat[no][nd] = this.mat[nd][no] = 3;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Solucion s = new Solucion("metro.in");
		Prim p = new Prim(s.getMat());
		s.resolver(p.prim(0));
		s.imprimir();

	}

	private void resolver(ArrayList<Arista> prim) {
		int cont = 0;
		for (Arista ar : prim) {
			// System.out.println(ar.getNd() + " " + ar.getNd() + " " + ar.getValue());
			if (ar.getValue() == 3)
				cont++;
		}

		System.out.println(cont);

	}

	private void imprimir() {
		// esto deberia agarrar lo que calcula resolver e imprimirlo, pero me da paja
		// implementarlo
	}

}
