package logica;

public class MainPrueba {

	 public static void main(String[] args) {
			Systema sistema= new Systema("abc");
			boolean registrado= sistema.registrarse("Jose","123456788", "Cuba", "Ingeniero");
			boolean registrado1= sistema.registrarse("Manu","123456788", "Cuba", "Ingeniero");
			boolean crearSolicitud=sistema.crearSolicitud((Person)sistema.getGraph().getVerticesList().get(0).getInfo(),(Person)sistema.getGraph().getVerticesList().get(0).getInfo(), 0);
			System.out.println(registrado);
			System.out.println(registrado1);
			System.out.println(sistema.login("Jose","123456788"));
			System.out.println(crearSolicitud);

		}

}
