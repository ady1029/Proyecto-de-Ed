package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import interfaz.Login;
import interfaz.MenuPrincAdmin;

public class MainPrueba {

	public static void main(String[] args) {

		RedSystem sis = new RedSystem("Hablemos");
		ILinkedWeightedEdgeNotDirectedGraph grafo = new LinkedGraph();
		Person num1 = new Person("Samira", "1234", Pais.CUBA, "Programadora");
		Person num2 = new Person("Marlon", "aaa", Pais.CUBA, "Programador");
		Person num3 = new Person("Adrian", "soy tonto", Pais.CUBA, "Programador");
		Person num4 = new Person("Migue", "soy negro", Pais.CUBA, "Negro");
		Person num5 = new Person("Jorge", "1234", Pais.CUBA, "Ingeniero");
		grafo.insertVertex(num1);
		grafo.insertVertex(num2);
		grafo.insertVertex(num3);
		grafo.insertVertex(num4);
		grafo.insertVertex(num5);

		sis.setGraph(grafo);
		boolean crearSolicitud = sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(0).getInfo()),((Person) sis.getGraph().getVerticesList().get(2).getInfo()), 9);
		boolean crearSolicitud1 = sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(1).getInfo()),((Person) sis.getGraph().getVerticesList().get(2).getInfo()), 9);
		boolean crearSolicitud2 = sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(0).getInfo()),((Person) sis.getGraph().getVerticesList().get(1).getInfo()), 9);
		sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(0).getInfo()),((Person) sis.getGraph().getVerticesList().get(3).getInfo()), 9);
		sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(1).getInfo()),((Person) sis.getGraph().getVerticesList().get(3).getInfo()), 9);
		sis.crearSolicitud(((Person) sis.getGraph().getVerticesList().get(2).getInfo()),((Person) sis.getGraph().getVerticesList().get(3).getInfo()), 9);
		System.out.println("Solicitud creada(Samira manda solicitad a adrian: )" + crearSolicitud);
		System.out.println("Solicitud creada(Marlon manda solicitad a Adrian: )" + crearSolicitud1);
		System.out.println("Solicitud aceptada(Adrian acepta solicitud de Samaira: "+ sis.crearNuevaRelacion(num1.getNick(), num3));
		sis.crearNuevaRelacion(num2.getNick(), num3);
		sis.crearNuevaRelacion(num1.getNick(), num2);
		sis.crearNuevaRelacion(num1.getNick(), num4);
		sis.crearNuevaRelacion(num2.getNick(), num4);
		sis.crearNuevaRelacion(num3.getNick(), num4);

		LinkedList<Person> islas = sis.personasSinConexiones();
		Iterator<Person> iter = islas.iterator();
		while (iter.hasNext()) {
			Person aux = iter.next();
			System.out.println("Es una isla: " + aux.getNick() + "," + aux.getOccupation());
		}
		System.out.println("Adrian es una isla:" + sis.isIsland("Adrian"));

		GeneralTree<Person> arbol = sis.obtenerTodasconexiones(((Person) sis.getGraph().getVerticesList().get(2).getInfo()));
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


		ArrayList <Float> promedios= new ArrayList<>();
LinkedList<LiderInvestigacion> lideresInvestigacion= sis.lideresInvest(comu);
		System.out.println("Lideres de investigacion");
		for(int j=0; j< lideresInvestigacion.size(); j++){
			System.out.println(lideresInvestigacion.get(j).getNick()+ "------"+ promedios.get(j));
		}
		try {
			Login login = new Login();
			MenuPrincAdmin frame = new MenuPrincAdmin(sis,login);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}