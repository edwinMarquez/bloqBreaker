package bloqBreaker;

public class Ladrillo extends Entity {
	int vidas;
	int tipo;
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	
	public Ladrillo(int width, int heigth) {
		super(width, heigth);
	}

}
