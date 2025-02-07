package logica;

import java.util.Iterator;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class MainPrueba2 {

	public static void main(String[] args) {

		RedSystem sis = new RedSystem("Hablemos");
		ILinkedWeightedEdgeNotDirectedGraph grafo = new LinkedGraph();
		Person num1 = new Person("Samira", "1234", "Cuba", "Programadora");
		Person num2 = new Person("Marlon", "aaa", "Cuba", "Programador");
		Person num3 = new Person("Adrian", "soy tonto", "Cuba", "Programador");
		Person num4 = new Person("Migue", "soy negro", "Cuba", "Negro");
		grafo.insertVertex(num1);
		grafo.insertVertex(num2);
		grafo.insertVertex(num3);
		grafo.insertVertex(num4);

		sis.setGraph(grafo);
		boolean crearSolicitud = sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(0).getInfo()),((Person) sis.getGraph().getVerticesList().get(2).getInfo()), 9);
		boolean crearSolicitud1 = sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(1).getInfo()),((Person) sis.getGraph().getVerticesList().get(2).getInfo()), 9);
		boolean crearSolicitud2 = sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(0).getInfo()),((Person) sis.getGraph().getVerticesList().get(1).getInfo()), 9);
		sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(0).getInfo()),((Person) sis.getGraph().getVerticesList().get(3).getInfo()), 9);
		System.out.println("Solicitud creada(Samira manda solicitad a adrian: )" + crearSolicitud);
		System.out.println("Solicitud creada(Marlon manda solicitad a Adrian: )" + crearSolicitud1);
		System.out.println("Solicitud aceptada(Adrian acepta solicitud de Samaira: "+ sis.crearNuevaRelacion(num1.getNick(), num3));
		sis.crearNuevaRelacion(num2.getNick(), num3);
		sis.crearNuevaRelacion(num1.getNick(), num2);
		sis.crearNuevaRelacion(num1.getNick(), num4);

		LinkedList<Person> islas = sis.personasSinConexiones();
		Iterator<Person> iter = islas.iterator();
		while (iter.hasNext()) {
			Person aux = iter.next();
			System.out.println("Es una isla: " + aux.getNick() + "," + aux.getOccupation());
		}
		System.out.println("Adrian es una isla:" + sis.isIsland("Adrian"));

		GeneralTree<Person> arbol = sis
				.obtenerTodasconexiones(((Person) sis.getGraph().getVerticesList().get(2).getInfo()));
		InBreadthIterator<Person> a = arbol.inBreadthIterator();
		while (a.hasNext()) {
			Person aux = a.next();
			System.out.println(aux.getNick());
		}
		LinkedList<Comunity> comu = sis.obtenerComunidades();
		int i = 1;
		for (Comunity abc : comu) {
			System.out.println("Comunidad "+i);
			for (Person person : abc.getIntegrantes())
				System.out.println(person.getNick());
			i++;
		}
	}
}