package elGusano;

public class Arista {
	private int no;
	private int nd;
	private int value;
	public Arista(int no, int nd) {
		super();
		this.no = no;
		this.nd = nd;
	}

	public Arista(int no, int nd, int value) {
		super();
		this.no = no;
		this.nd = nd;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNd() {
		return nd;
	}

	public void setNd(int nd) {
		this.nd = nd;
	}
}
