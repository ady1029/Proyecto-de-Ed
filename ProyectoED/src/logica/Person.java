package logica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Person {
	public String nick;
	private String password;
	private String country;
	private String occupation;
	private LinkedList <Request> solicitudAmistad;

	public Person(String nick, String password, String country,String occupation) {
		setNick(nick);
		setPassword(password);
		setCountry(country);
		setOccupation(occupation);
		solicitudAmistad= new LinkedList<Request>();
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

	public Queue<Request> getSolicitudAmistad() {
		return solicitudAmistad;
	}

	public void setSolicitudAmistad(LinkedList <Request> solicitudAmistad) {
		this.solicitudAmistad = solicitudAmistad;
	}
	public Request aceptarSolicitud(String nickSolicitante) {
		Request solicitud= findSolicitud(nickSolicitante);
		if(solicitud != null)
			solicitudAmistad.remove(solicitud);
		return solicitud;

	}
	public Request findSolicitud(String nick) {
		Request solicitud= null;
		Iterator <Request> it= solicitudAmistad.iterator();
		while(it.hasNext() && solicitud == null) {
			Request aux= it.next();
			if(aux.getPersonaEnvia().getNick().equalsIgnoreCase(nick)) {
				solicitud = aux;
			}
		}
		return solicitud;

	}


}
