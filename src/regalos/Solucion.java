package regalos;

import java.io.*;
import java.util.*;

public class Solucion {

	private Map<Integer, Nodo> nodos = new HashMap<Integer, Nodo>();

	public static void main(String[] args) {
		Solucion s = new Solucion("regalos.in");
		Coloreo col = new Coloreo( s.getNodos() );
		System.out.println("caca");
		
	}

	public Solucion(String string) {
		try {
			Scanner sc = new Scanner(new File(string));
			int cantNodos = sc.nextInt();
			int nodo, aux;
			for (int i = 0; i < cantNodos; i++) {
				nodo = sc.nextInt();
				aux = sc.nextInt();
				if (!nodos.containsKey(nodo))
					nodos.put(nodo, new Nodo(nodo));

				while (aux != -1) {
					if (!nodos.containsKey(aux))
						nodos.put(aux, new Nodo(aux));
					
					nodos.get(nodo).add(nodos.get(aux));
					nodos.get(aux).add(nodos.get(nodo));

					aux = sc.nextInt();
				}

			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Map<Integer, Nodo> getNodos() {
		return nodos;
	}

}
