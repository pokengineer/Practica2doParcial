package Tarzan;

public class Arbol {
	private int x;
	private int y;
	private int id;


	public Arbol(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public double distancia(Arbol obj) {
		return Math.hypot(this.x - obj.x, this.y - obj.y);
	}

	public int getId() {
		return id;
	}

}
