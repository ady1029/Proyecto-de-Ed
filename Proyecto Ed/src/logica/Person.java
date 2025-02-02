package logica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Person {
	private String nick;
	private String password;
	private String country;
	private String occupation;
	private LinkedList <Solicitud> solicitudAmistad;

	public Person(String nick, String password, String country,String occupation) {
		setNick(nick);
		setPassword(password);
		setCountry(country);
		setOccupation(occupation);
		solicitudAmistad= new LinkedList<Solicitud>();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Queue<Solicitud> getSolicitudAmistad() {
		return solicitudAmistad;
	}

	public void setSolicitudAmistad(LinkedList <Solicitud> solicitudAmistad) {
		this.solicitudAmistad = solicitudAmistad;
	}
	public Solicitud aceptarSolicitud(String nickSolicitante) {
		Solicitud solicitud= findSolicitud(nickSolicitante);
		if(solicitud != null)
			solicitudAmistad.remove(solicitud);
		return solicitud;

	}
	public Solicitud findSolicitud(String nick) {
		Solicitud solicitud= null;
		Iterator <Solicitud> it= solicitudAmistad.iterator();
		while(it.hasNext() && solicitud == null) {
			Solicitud aux= it.next();
			if(aux.getPersonaEnvia().getNick().equalsIgnoreCase(nick)) {
				solicitud = aux;
			}
		}
		return solicitud;

	}


}
