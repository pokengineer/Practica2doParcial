package inspecionandoLaReserva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solucion {
	private int[][] mat;
	private int caminos;
	
	public Solucion(String string) {
		try {
			Scanner sc = new Scanner( new File(string) );
			int cantNodos = sc.nextInt();
			this.mat = new int[cantNodos][cantNodos];
			int cantCaminos = sc.nextInt();
			int no,nd;
			for( int i = 0; i< cantCaminos ; i++ ) {
				no = sc.nextInt()-1;
				nd = sc.nextInt()-1;
				this.mat[no][nd] = 1; 
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Solucion s = new Solucion("reserva.in");
		s.resolver();
		s.imprimir("reserva.out");
		System.out.println("terminado");
	}

	private void resolver() {
		Dfs d = new Dfs(this.mat);
		this.caminos = d.numberOfPaths( 0, mat.length-1);
	}
	
	private void imprimir(String string) {
		try {
			FileWriter fw = new FileWriter( new File(string) );
			fw.write("" + this.caminos);
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
