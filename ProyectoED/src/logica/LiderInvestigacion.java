package logica;

public class LiderInvestigacion extends Person{
	private int tamañoComunidad;
	private float promedio;

	public LiderInvestigacion(String nick,int tamañoComunidad,float promedio) {
		super(nick,null,null,null);
		setPromedio(promedio);
		setTamañoComunidad(tamañoComunidad);
		}

	public int getTamañoComunidad() {
		return tamañoComunidad;
	}

	public void setTamañoComunidad(int tamañoComunidad) {
		this.tamañoComunidad = tamañoComunidad;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	

}
