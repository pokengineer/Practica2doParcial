package Tarzan;

public class Arbol {
	private int x;
	private int y;

	public Arbol(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distancia(Arbol obj) {
		return Math.hypot(this.x - obj.x, this.y - obj.y);
	}

}
