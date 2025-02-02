package logica;

public class Solicitud {
	private Person PersonaEnvia; 
	private int cantdTrabajos;
	public Solicitud(Person envia, int cantdTrabajo) {
		setPersonaEnvia(envia);
		setCantdTrabajos(cantdTrabajo);
	}
	public Person getPersonaEnvia() {
		return PersonaEnvia;
	}
	public void setPersonaEnvia(Person personaEnvia) {
		PersonaEnvia = personaEnvia;
	}
	public int getCantdTrabajos() {
		return cantdTrabajos;
	}
	public void setCantdTrabajos(int cantdTrabajos) {
		this.cantdTrabajos = cantdTrabajos;
	}
	

}
