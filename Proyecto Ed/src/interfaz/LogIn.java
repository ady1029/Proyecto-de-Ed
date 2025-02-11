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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("WorkSphere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 722);
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
		panelInicioSeccion.setBounds(775, 189, 363, 354);
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
		lblContrasenna.setBounds(37, 233, 85, 19);
		panelInicioSeccion.add(lblContrasenna);

		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		textFieldNombreUsuario.setBackground(Color.WHITE);
		textFieldNombreUsuario.setBounds(36, 155, 273, 35);
		panelInicioSeccion.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(37, 262, 273, 35);
		panelInicioSeccion.add(passwordField);

		btnAccederLogin = new BotonAnimacion();
		btnAccederLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAccederLogin.setText("ACCEDER");
		btnAccederLogin.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 25));
		btnAccederLogin.setColorEfecto(Color.WHITE);
		btnAccederLogin.setBackground(Color.WHITE);
		btnAccederLogin.setBounds(773, 603, 139, 48);
		panel_1.add(btnAccederLogin);

		btnRegistrarse = new BotonAnimacion();
		btnRegistrarse.setText("CREAR CUENTA");
		btnRegistrarse.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 25));
		btnRegistrarse.setColorEfecto(Color.WHITE);
		btnRegistrarse.setBackground(Color.WHITE);
		btnRegistrarse.setBounds(951, 603, 187, 48);
		panel_1.add(btnRegistrarse);

		JLabel lblNewLabel = new JLabel("New label");
<<<<<<< Updated upstream:Proyecto Ed/src/interfaz/Login.java
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/fotos/✅.png")));
		lblNewLabel.setBounds(0, 0, 1269, 683);
=======
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/fotos/✅.png")));
		lblNewLabel.setBounds(0, 0, 1167, 683);
>>>>>>> Stashed changes:Proyecto Ed/src/interfaz/login.java
		panel_1.add(lblNewLabel);
	}
}
