package logica;

import java.util.LinkedList;

public class Comunity {
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
}
