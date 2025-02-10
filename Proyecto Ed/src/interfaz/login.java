package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentesVisuales.PanelBordeOval;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Person;
import logica.RedSystem;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.util.LinkedList;

import componentesVisuales.BotonAnimacion;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelBordeOval panelInicioSeccion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNombreUsuario;
	private JLabel lblContrasenna;
	private JTextField textFieldNombreUsuario;
	private JPasswordField passwordField;
	private BotonAnimacion btnAccederLogin;
	private BotonAnimacion btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1279, 706);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panelInicioSeccion = new PanelBordeOval(100);
		panelInicioSeccion.setBackground(Color.WHITE);
		panelInicioSeccion.setBounds(774, 154, 390, 415);
		panel_1.add(panelInicioSeccion);
		panelInicioSeccion.setLayout(null);

		lblNewLabel_1 = new JLabel("INICIA SESIÓN EN TU");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(67, -15, 273, 96);
		panelInicioSeccion.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("CUENTA");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(124, 54, 200, 47);
		panelInicioSeccion.add(lblNewLabel_2);

		lblNombreUsuario = new JLabel("Usuario");
		lblNombreUsuario.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblNombreUsuario.setBounds(37, 119, 85, 19);
		panelInicioSeccion.add(lblNombreUsuario);

		lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblContrasenna.setBounds(37, 259, 85, 19);
		panelInicioSeccion.add(lblContrasenna);

		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setBackground(Color.WHITE);
		textFieldNombreUsuario.setBounds(36, 155, 299, 35);
		panelInicioSeccion.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(37, 289, 298, 35);
		panelInicioSeccion.add(passwordField);

		btnAccederLogin = new BotonAnimacion();
		btnAccederLogin.setText("ACCEDER");
		btnAccederLogin.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 30));
		btnAccederLogin.setColorEfecto(Color.WHITE);
		btnAccederLogin.setBackground(Color.WHITE);
		btnAccederLogin.setBounds(772, 601, 159, 48);
		panel_1.add(btnAccederLogin);

		btnRegistrarse = new BotonAnimacion();
		btnRegistrarse.setText("CREAR CUENTA");
		btnRegistrarse.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 30));
		btnRegistrarse.setColorEfecto(Color.WHITE);
		btnRegistrarse.setBackground(Color.WHITE);
		btnRegistrarse.setBounds(941, 601, 217, 48);
		panel_1.add(btnRegistrarse);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/fotos/✅.png")));
		lblNewLabel.setBounds(0, 0, 1269, 683);
		panel_1.add(lblNewLabel);
	}
}
