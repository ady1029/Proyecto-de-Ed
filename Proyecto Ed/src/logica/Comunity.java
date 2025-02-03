package logica;

import java.util.LinkedList;

public class Comunity {
    private String name ;
    private LinkedList <Person> integrantes;

    public Comunity(String name){
        setName(name);
            }
        
    private void setName(String name) {
         this.name= name;
            }
}
