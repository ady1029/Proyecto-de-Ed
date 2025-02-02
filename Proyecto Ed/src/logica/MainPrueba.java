package logica;

import java.util.Iterator;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;

public class MainPrueba {

	public static void main(String[] args) {
		Systema sistema= new Systema("abc");
		boolean registrado= sistema.registrarse("Jose","123456788", "Cuba", "Ingeniero");
		boolean registrado1= sistema.registrarse("Jose","123456788", "Cuba", "Ingeniero");
		System.out.println(registrado);
		System.out.println(registrado1);
		System.out.println(sistema.login("Jose","123456788"));




		//Prueba metodo obtener islas
		Systema sis = new Systema("Hablemos");
		ILinkedWeightedEdgeNotDirectedGraph grafo = new LinkedGraph();
		Person num1 = new Person("Samira", "1234","Cuba", "Programadora");
		Person num2 = new Person("Marlon", "aaa","Cuba", "Programador");
		Person num3 = new Person("Adrian", "soy tonto", "Cuba" , "Programador");
		grafo.insertVertex(num1);
		grafo.insertVertex(num2);
		grafo.insertVertex(num3);
		grafo.insertEdgeNDG(0, 2);
		sis.setGraph(grafo);
		LinkedList <Person> islas = sis.personasSinConexiones();

		Iterator<Person> iter = islas.iterator();
		while(iter.hasNext()) {
			Person aux = iter.next();
			System.out.println(aux.getNick() + "," + aux.getOccupation());
		}
	}


}
