package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import componentesVisuales.Linea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import componentesVisuales.PanelBordeOval;
import logica.Person;
import logica.RedSystem;

import java.awt.Rectangle;
import componentesVisuales.PanelAnimacionCurvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import componentesVisuales.BotonAnimacion;
import javax.swing.JMenuItem;

public class MenuUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Linea linea = new Linea(0, 0);
	private Login father;
	private RedSystem aplic;
	private Person a;

	public MenuUsuario(Login login, RedSystem app, Person p) {
		father = login;
		aplic = app;
		a = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Mi Perfil");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mis Amigos");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Solicitudes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Enviar");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ver");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Buscar");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Buscar Usuario");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Ajuste");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cambiar Nombre de Usuario");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cambiar Contraseña de Usuario");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
		panelAnimacionCurvas.setInicioGradiente(new Color(4, 142, 255));
		panelAnimacionCurvas.setFinGradiente(Color.WHITE);
		panelAnimacionCurvas.setColorInicioAnimacion(new Color(55, 165, 255));
		panelAnimacionCurvas.setBackground(new Color(55, 165, 255));
		panelAnimacionCurvas.setBounds(0, 0, 907, 489);
		contentPane.add(panelAnimacionCurvas);
		panelAnimacionCurvas.setLayout(null);
		
		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBounds(0, 51, 225, 323);
		panelAnimacionCurvas.add(panelBordeOval);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBackground(new Color(55, 165, 255));
		panelBordeOval.setLayout(null);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/imagenes/icon hombre 1.jpg")));
		avatarCircular.setBounds(10, 11, 83, 74);
		panelBordeOval.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("Nick del usuario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 23, 140, 22);
		panelBordeOval.add(lblNewLabel);
		
		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacion.setFont(new Font("Arial", Font.PLAIN, 17));
		lblOcupacion.setBounds(73, 46, 140, 22);
		panelBordeOval.add(lblOcupacion);
		linea.setBorder(new LineBorder(Color.BLACK, 1, true));
		linea.setGrosor(1);
		linea.setBounds(0, 91, 270, 1);
		panelBordeOval.add(linea);
		
		AvatarCircular avatarCircular_1 = new AvatarCircular();
		avatarCircular_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/FotoUsuarios.png")));
		avatarCircular_1.setBounds(10, 103, 35, 33);
		panelBordeOval.add(avatarCircular_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mi Perfil");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InfoUsuario dialog = new InfoUsuario(p,app);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				setVisible(false);
				
			}
		});
		lblNewLabel_1.setBounds(47, 111, 134, 14);
		panelBordeOval.add(lblNewLabel_1);
		
		AvatarCircular avatarCircular_1_1 = new AvatarCircular();
		avatarCircular_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular_1_1.setBounds(10, 136, 35, 33);
		panelBordeOval.add(avatarCircular_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mis Amigos");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MostrarAmigos dialog = new MostrarAmigos(app,p);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_1_1.setBounds(47, 145, 151, 14);
		panelBordeOval.add(lblNewLabel_1_1);
		
		AvatarCircular avatarCircular_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoCErrarSesion2.png")));
		avatarCircular_1_1_1.setBounds(10, 170, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enviar Solicitud de Amistad");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InfoUsuario dialog = new InfoUsuario(p,app);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_1_1_1.setBounds(47, 180, 166, 14);
		panelBordeOval.add(lblNewLabel_1_1_1);
		
		AvatarCircular avatarCircular_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular_1_1_1_1.setBounds(10, 205, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ver Solicitudes de Amistad");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InfoUsuario dialog = new InfoUsuario(p,app);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				setVisible(false);
				
			}
		});
		lblNewLabel_1_1_1_1.setBounds(47, 214, 178, 14);
		panelBordeOval.add(lblNewLabel_1_1_1_1);
		
		AvatarCircular avatarCircular_1_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/FotoUsuarios.png")));
		avatarCircular_1_1_1_1_1.setBounds(10, 238, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Buscar Usuario");
		lblNewLabel_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					PanelBuscar dialog = new PanelBuscar(null, aplic, MenuUsuario.this);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					setVisible(false);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		lblNewLabel_1_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1_1_1.setBounds(47, 249, 118, 14);
		panelBordeOval.add(lblNewLabel_1_1_1_1_1);
		
		AvatarCircular avatarCircular_1_1_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoCerrarSesion1.png")));
		avatarCircular_1_1_1_1_1_1.setBounds(10, 272, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Cerrar Sesión");
		lblNewLabel_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login dialog = new Login();
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1_1_1_1_1_1.setBounds(47, 282, 118, 14);
		panelBordeOval.add(lblNewLabel_1_1_1_1_1_1);
		
		PanelBordeOval panelBordeOval_1 = new PanelBordeOval(0);
		panelBordeOval_1.setBackground(new Color(55, 165, 255));
		panelBordeOval_1.setValorEsquinaOvalSI(60);
		panelBordeOval_1.setValorEsquinaOvalSD(60);
		panelBordeOval_1.setValorEsquinaOvalII(60);
		panelBordeOval_1.setValorEsquinaOvalID(60);
		panelBordeOval_1.setBounds(258, 34, 614, 385);
		panelAnimacionCurvas.add(panelBordeOval_1);
		panelBordeOval_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 594, 265);
		panelBordeOval_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		BotonAnimacion btnmcnBorrar = new BotonAnimacion();
		btnmcnBorrar.setText("Borrar");
		btnmcnBorrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnmcnBorrar.setBounds(481, 342, 106, 32);
		panelBordeOval_1.add(btnmcnBorrar);
		
		JLabel lblNotificaciones = new JLabel("NOTIFICACIONES");
		lblNotificaciones.setBounds(10, 11, 140, 32);
		panelBordeOval_1.add(lblNotificaciones);
		lblNotificaciones.setBackground(new Color(4, 142, 255));
		lblNotificaciones.setForeground(new Color(0, 0, 0));
		lblNotificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificaciones.setFont(new Font("Arial Narrow", Font.ITALIC, 20));
		
		
	}
}
