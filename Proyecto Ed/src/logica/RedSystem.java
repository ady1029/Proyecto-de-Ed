package logica;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class RedSystem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ILinkedWeightedEdgeNotDirectedGraph graph;
	private Person administrador;


	public RedSystem(String name) {
		this.name = name;
		this.graph = new LinkedGraph();
		administrador= new Person("Administrador","12345",null,null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ILinkedWeightedEdgeNotDirectedGraph getGraph() {
		return graph;
	}

	public void setGraph(ILinkedWeightedEdgeNotDirectedGraph graph) {
		this.graph = graph;
	}

	public Person getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Person administrador) {
		this.administrador = administrador;
	}

	public boolean login(String nick, String password) {
		boolean correcto = false;
		Iterator<Vertex> it = graph.getVerticesList().iterator();
		while (it.hasNext() && !correcto) {
			Vertex actual = it.next();
			if (((Person) actual.getInfo()).getNick().equalsIgnoreCase(nick)
					&& ((Person) actual.getInfo()).getPassword().equalsIgnoreCase(password)) {
				correcto = true;
			}
		}
		return correcto;
	}

	public boolean registrarse(String nick, String password, Pais country, String occupation) {
		boolean registrado = false;
		Vertex aux = findNick(nick);
		if (aux == null) {
			graph.insertVertex(new Person(nick, password, country, occupation));
			registrado = true;
		}
		return registrado;

	}

	public Vertex findNick(String nick) {
		Vertex aux = null;
		Iterator<Vertex> it = graph.getVerticesList().iterator();
		while (it.hasNext() && aux == null) {
			Vertex actual = it.next();
			if (((Person) actual.getInfo()).getNick().equalsIgnoreCase(nick))
				aux = actual;
		}
		return aux;
	}

	// Este metodo devuelve las persona sin conexiones (islas)
	public LinkedList<Person> personasSinConexiones() throws IOException {
		Iterator<Vertex> iteradorPrincipal = graph.getVerticesList().iterator();
		LinkedList<Person> islas = new LinkedList<>();

		while (iteradorPrincipal.hasNext()) {
			Vertex aux = iteradorPrincipal.next(); // tomamos un vertice para verificar si es isla
			if (aux.getEdgeList().isEmpty())
				islas.add((Person) aux.getInfo());
		}
		almacenarEnFicheroIslas(islas);
		return islas;
	}

	// revisar si una persona es una isla
	public boolean isIsland(String nick) {
		Vertex a = findNick(nick);
		LinkedList<Vertex> vertices = graph.getVerticesList();
		int b = vertices.indexOf(a);
		boolean island = false;
		if (a != null) {
			LinkedList<Vertex> adyacentes = graph.adjacentsG(b);
			if (adyacentes.size() == 0) {
				island = true;
			}
		}
		return island;
	}

	// Crear una nueva solicitud de amistad
	public boolean crearSolicitud(Person envia, Person recibe, int cantdTrabajo) {
		boolean creada = false;
		Vertex aux = findNick(recibe.getNick());
		if (aux != null) {
			if (((Person) aux.getInfo()).findSolicitud(envia.getNick()) == null) {
				((Person) aux.getInfo()).getSolicitudAmistad().offer(new Request(envia, cantdTrabajo));
				creada = true;
			}
		}
		return creada;
	}

	// Crear nueva relacion de amistad
	public boolean crearNuevaRelacion(String nickSolicitado, Person acepta) {
		Request solicitud = acepta.aceptarSolicitud(nickSolicitado);
		boolean creado = false;
		if (solicitud != null) {
			Vertex persona1 = findNick(nickSolicitado);
			Vertex persona = findNick(acepta.getNick());
			int person1 = graph.getVerticesList().indexOf(persona1);
			int person = graph.getVerticesList().indexOf(persona);
			graph.insertWEdgeNDG(person1, person, solicitud.getCantdTrabajos());
			creado = true;
		}
		return creado;
	}

	// Obtener arbol con todos los conectados directa e indirectamente con un
	// vertice
	public GeneralTree<Person> obtenerTodasconexiones(Person person) throws IOException {
		Vertex persona = findNick(person.getNick());
		BinaryTreeNode<Person> root = new BinaryTreeNode<Person>(person);
		GeneralTree<Person> arbol = new GeneralTree<Person>(root);
		LinkedList<Vertex> visitados = new LinkedList<Vertex>();
		visitados.add(persona);
		int i = 0;
		insertarVertices(persona, arbol, visitados, i);
		almacenarArbolGeneralTodasConexiones(arbol);
		return arbol;
	}

	private void insertarVertices(Vertex actual, GeneralTree<Person> arbol, LinkedList<Vertex> visitados, int i) {
		i++;
		LinkedList<Vertex> adjacentes = actual.getAdjacents();
		Iterator<Vertex> it = adjacentes.iterator();
		while (it.hasNext()) {
			Vertex aux = it.next();
			if (!visitados.contains(aux)) {
				arbol.insert((Person) aux.getInfo(), (Person) actual.getInfo());
				visitados.add(aux);
			}
		}
		if (i < visitados.size()) {
			actual = visitados.get(i);
			insertarVertices(actual, arbol, visitados, i);
		}
	}

	// Obtener comunidades
	public LinkedList<Comunity> obtenerComunidades() throws IOException {
		LinkedList<Comunity> comunidades = new LinkedList<>();
		Iterator<Vertex> it = graph.getVerticesList().iterator();
		while (it.hasNext()) {
			Vertex aux = it.next();
			LinkedList<Vertex> comunidad = new LinkedList<>();
			comunidadesPersona(aux, comunidad, comunidades);
		}
		almacenarEnFicheroComunidades(comunidades);
		return comunidades;
	}

	private void comunidadesPersona(Vertex actual, LinkedList<Vertex> comunidad, LinkedList<Comunity> comunidades) {
		comunidad.add(actual);
		Iterator<Vertex> it = actual.getAdjacents().iterator();
		while (it.hasNext()) {
			Vertex aux = it.next();
			if (!comunidad.contains(aux)) {
				if (contieneNodo(aux, comunidad)) {
					comunidadesPersona(aux, comunidad, comunidades);
				} else if (comunidad.size() > 2) {
					Iterator<Vertex> itConvertir = comunidad.iterator();
					LinkedList<Person> personas = new LinkedList<>();
					while (itConvertir.hasNext()) {
						Person person = (Person) itConvertir.next().getInfo();
						personas.add(person);
					}
					Comunity comun = new Comunity(personas.size(), personas);
					if (containsComunity(comun, comunidades))
						comunidades.add(comun);
				}

			} else if (comunidad.size() > 2 && (comunidad.size() - 1) == (actual.getAdjacents().size())) {
				Iterator<Vertex> itConvertir = comunidad.iterator();
				LinkedList<Person> personas = new LinkedList<>();
				while (itConvertir.hasNext()) {
					Person a = (Person) itConvertir.next().getInfo();
					personas.add(a);
				}
				Comunity comun = new Comunity(personas.size(), personas);
				if (containsComunity(comun, comunidades))
					comunidades.add(comun);
			}
		}
		comunidad.remove(actual);
	}

	private boolean contieneNodo(Vertex actual, LinkedList<Vertex> comunidad) {
		boolean contine = true;
		Iterator<Vertex> it = comunidad.iterator();
		while (contine && it.hasNext()) {
			Vertex vertex = it.next();
			if (!actual.getAdjacents().contains(vertex)) {
				contine = false;
			}
		}
		return contine;
	}

	private boolean containsComunity(Comunity comunidad, LinkedList<Comunity> listaComunidades) {
		int contador = 0;
		boolean Nocontiene = true;
		Iterator<Comunity> itListaCominudades = listaComunidades.iterator();
		while (itListaCominudades.hasNext() && Nocontiene) {
			Comunity aux = itListaCominudades.next();
			if (aux.getCantdintegrantes() == comunidad.getCantdintegrantes()) {
				Iterator<Person> itPersonas = comunidad.getIntegrantes().iterator();
				while (itPersonas.hasNext() && Nocontiene) {
					Person p = itPersonas.next();
					if (aux.getIntegrantes().contains(p)) {
						contador++;
					}
				}
				if (contador == comunidad.getCantdintegrantes())
					Nocontiene = false;
			}

		}

		return Nocontiene;
	}

	// Metodos para obtener los lideres de investigacion (no comprobado)
	public LinkedList<LiderInvestigacion> lideresInvest(LinkedList<Comunity> comunidades) throws IOException {
		LinkedList<LiderInvestigacion> list = new LinkedList<>();

		for (Comunity c : comunidades) {
			float mayor = 0;
			float current = 0;
			for (Person p : c.getIntegrantes()) {
				current = calcularPromedio(p.getNick());
				if (current > mayor) {
					list.clear();
					mayor = current;
					list.add(new LiderInvestigacion(p.getNick(), c.getCantdintegrantes(),mayor));
				} else if (current == mayor) {
					list.add(new LiderInvestigacion(p.getNick(), c.getCantdintegrantes(),mayor));
				}
			}
		}
		almacenarEnFicheroLideresInvestigacion(list);
		return list;
	}

	private float calcularPromedio(String nick) throws IOException {
		float promedio = 0;
		Vertex a = findNick(nick);
		for (Edge ed : a.getEdgeList()) {
			WeightedEdge we = (WeightedEdge) ed;
			promedio += (Integer) we.getWeight();
		}
		promedio /= a.getEdgeList().size();
		return promedio;
	}
	// calcular cant de amigos de una persona.
	public int cantAmigos(Person p) {
		Vertex a = findNick(p.getNick());
		return a.getEdgeList().size();	 
	}
	//calcular cantidad de trabajos publicados de una persona
	public int cantTrabajos(Person p) {
		int cantTrab = 0;
		Vertex a = findNick(p.getNick());
		LinkedList <Edge> v = a.getEdgeList();
		for(Edge e : v) {
			WeightedEdge we = (WeightedEdge)e;
			cantTrab += (Integer)we.getWeight();
		}
		return cantTrab;
	}

	//Fichero con islas
	public void almacenarEnFicheroIslas(LinkedList<Person>islas) throws IOException {
		RandomAccessFile islasFile = new RandomAccessFile("islas.txt", "rw");
		Iterator <Person> iter = islas.iterator();
		while(iter.hasNext()) {
			Person aux = iter.next();
			byte [] arrayBytesPersona = Convert.toBytes(aux);
			islasFile.writeLong(arrayBytesPersona.length);
			islasFile.write(arrayBytesPersona);
		}
		islasFile.close();
	} 

	//Fichero con comunidades
	public void almacenarEnFicheroComunidades(LinkedList<Comunity>comunidades) throws IOException {
		RandomAccessFile comunidadFile = new RandomAccessFile("comunidades.txt", "rw");
		Iterator<Comunity> iter = comunidades.iterator();
		while(iter.hasNext()) {
			Comunity aux = iter.next();
			byte [] arrayBytesComunidad = Convert.toBytes(aux);
			comunidadFile.writeLong(arrayBytesComunidad.length);
			comunidadFile.write(arrayBytesComunidad);
		}
		comunidadFile.close();
	} 

	//Fichero con lideresInvestigacion
	public void almacenarEnFicheroLideresInvestigacion(LinkedList<LiderInvestigacion>lideres) throws IOException {
		RandomAccessFile lideresInvestFile = new RandomAccessFile("lideres.txt", "rw");
		Iterator<LiderInvestigacion> iter = lideres.iterator();
		while(iter.hasNext()) {
			LiderInvestigacion aux = iter.next();
			byte [] arrayLideres = Convert.toBytes(aux);
			lideresInvestFile.writeLong(arrayLideres.length);
			lideresInvestFile.write(arrayLideres);
		}
		lideresInvestFile.close();
	} 


	//Fichero arbol general todas conexiones
	public void almacenarArbolGeneralTodasConexiones(GeneralTree <Person> conexiones) throws IOException {
		RandomAccessFile arbolGeneral = new RandomAccessFile("arboles.txt", "rw");
		long puntero= arbolGeneral.length();
		arbolGeneral.seek(puntero);
		if(!conexiones.isEmpty()) {
			InBreadthIterator<Person> iter = conexiones.inBreadthIterator();
			while(iter.hasNext()) {
				BinaryTreeNode<Person> auxNode = iter.nextNode();
				Person aux = auxNode.getInfo();
				byte [] arrayPerson = Convert.toBytes(aux);
				arbolGeneral.writeLong(arrayPerson.length);
				arbolGeneral.write(arrayPerson);
			}
		}
		arbolGeneral.close();
	}
}
