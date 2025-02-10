package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import componentesVisuales.PanelAnimacionCurvas;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Person;
import logica.RedSystem;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import componentesVisuales.BotonAnimacion;
import java.awt.Font;
import raven.swing.AvatarIcon;
import javax.swing.Icon;
import componentesVisuales.AvatarCircular;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import componentesVisuales.NotificacionesModernas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private RedSystem system;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 842);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
		panelAnimacionCurvas.setInicioGradiente(new Color(107, 148, 184));
		panelAnimacionCurvas.setForeground(new Color(117, 147, 174));
		panelAnimacionCurvas.setFinGradiente(new Color(163, 193, 222));
		panelAnimacionCurvas.setColorInicioAnimacion(Color.LIGHT_GRAY);
		panelAnimacionCurvas.setColorFinalAnimacion(Color.LIGHT_GRAY);
		panelAnimacionCurvas.setBounds(0, 0, 597, 805);
		contentPane.add(panelAnimacionCurvas);
		panelAnimacionCurvas.setLayout(null);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setBounds(206, 81, 185, 164);
		avatarCircular.setAvatar(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\OIP (2).jpg"));
		panelAnimacionCurvas.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(229, 300, 230, 30);
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 30));
		panelAnimacionCurvas.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(187, 453, 230, 38);
		panelAnimacionCurvas.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CLAVE");
		lblContrasea.setBounds(248, 411, 230, 30);
		lblContrasea.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 30));
		panelAnimacionCurvas.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 340, 230, 38);
		panelAnimacionCurvas.add(passwordField);
		
		BotonAnimacion btnmcnAcceder = new BotonAnimacion();
		btnmcnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person p= new Person();
				int counter=2;
				p=acceder(p);
				/*try{
					if(accederMP()== true){
						MenuPrinc frame = new MenuPrinc(fct);
						frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						dispose();
						counter--;
					}
					if(p != null){
						MenuPrincProfesor frame = new MenuPrincProfesor(login.this,fct,p);
						frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						setVisible(false);
						counter--;
					}

					if(counter ==2)
						JOptionPane.showMessageDialog(login.this, "Usuario o contrase�a incorrecta.");

				}catch(Exception e){ 
					
					e.printStackTrace();

				}*/
			}
		});
		btnmcnAcceder.setBounds(213, 555, 159, 48);
		btnmcnAcceder.setBackground(new Color(192, 192, 192));
		btnmcnAcceder.setColorEfecto(new Color(255, 255, 255));
		btnmcnAcceder.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 25));
		btnmcnAcceder.setText("ACCEDER");
		panelAnimacionCurvas.add(btnmcnAcceder);
		
		JLabel lblNewLabel_1 = new JLabel("Registrese aquí");
		lblNewLabel_1.setBounds(229, 681, 143, 24);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setForeground(new Color(97, 97, 97));
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		panelAnimacionCurvas.add(lblNewLabel_1);
		
		AvatarCircular avatarCircular_1 = new AvatarCircular();
		avatarCircular_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		avatarCircular_1.setAvatar(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\iconVolver.png"));
		avatarCircular_1.setBounds(10, 48, 89, 84);
		panelAnimacionCurvas.add(avatarCircular_1);
	}
	public Person acceder(Person p){
		p = null;
		if(!(system.getGraph().isEmpty())) {
		 LinkedList <Vertex> list = system.getGraph().getVerticesList();
			 Vertex c = system.findNick(p.getNick());
			 if(c != null) {
				 
				}
			}
		return p;
		}
		
	public boolean accederMP(){
		boolean acceder = false;
		String a = "0123456789";
		if ((textField.getText().equalsIgnoreCase("admin")) && (passwordField.equals((String)a))){
			acceder = true;
		}
		return acceder;		
	}
}
