package logica;

import java.io.Serializable;
import java.util.LinkedList;

public class Comunity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantdIntegrantes ;
    private LinkedList <Person> integrantes;

    public Comunity(int cantdIntegrantes, LinkedList <Person> integrantes){
        setCantdintegrantes(cantdIntegrantes);
        setIntegrantes(integrantes);
    }
        
    public void setCantdintegrantes(int cantdIntegrantes) {
         this.cantdIntegrantes= cantdIntegrantes;
    }
    
    public void setIntegrantes(LinkedList <Person> integrantes) {
        this.integrantes= integrantes;
     }
     public LinkedList <Person> getIntegrantes() {
        return integrantes;
     }
     public int getCantdintegrantes() {
        return cantdIntegrantes;
     }
}
