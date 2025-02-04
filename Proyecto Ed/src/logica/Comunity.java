package logica;

import java.util.LinkedList;

public class Comunity {
    private int cantdIntegrantes ;
    private LinkedList <Person> integrantes;

    public Comunity(int cantdIntegrantes, LinkedList <Person> integrantes){
        setCantdintegrantes(cantdIntegrantes);
        setIntegrantes(integrantes);
    }
        
    private void setCantdintegrantes(int cantdIntegrantes) {
         this.cantdIntegrantes= cantdIntegrantes;
    }
    
    private void setIntegrantes(LinkedList <Person> integrantes) {
        this.integrantes= integrantes;
     }
}
