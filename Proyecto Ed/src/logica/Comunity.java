package logica;

import java.util.LinkedList;

public class Comunity {
    private int cantdIntegrantes ;
    private LinkedList <Person> integrantes;

    public Comunity(int cantdIntegrantes){
        setCantdintegrantes(cantdIntegrantes);
            }
        
    private void setCantdintegrantes(int cantdIntegrantes) {
         this.cantdIntegrantes= cantdIntegrantes;
            }
}
