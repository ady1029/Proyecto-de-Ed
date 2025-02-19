package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import componentesVisuales.AvatarCircular;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Menu;

import componentesVisuales.Linea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import componentesVisuales.PanelBordeOval;
import logica.Person;
import logica.RedSystem;
import raven.fbr.Border;

import java.awt.Rectangle;
import componentesVisuales.PanelAnimacionCurvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.acl.AclNotFoundException;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import componentesVisuales.BotonAnimacion;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Linea linea = new Linea(0, 0);
	private Login father;
	private RedSystem aplic;
	private Person a;
	private JPanel panel_1;
	private PanelBordeOval panelBordeOval_1;

	public MenuUsuario(Login login, RedSystem app, Person p) {
		setResizable(false);
		father = login;
		aplic = app;
		a = p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 550);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Mi Perfil");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfoUsuario dialog = new InfoUsuario(MenuUsuario.this,p,app,0);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mis Amigos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarAmigos dialog = new MostrarAmigos(MenuUsuario.this,app,p);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Solicitudes");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Enviar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SolicitudesOpciones dialog = new SolicitudesOpciones(MenuUsuario.this,p,app);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ver");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfoUsuario dialog = new InfoUsuario(MenuUsuario.this,p,app, 1);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_2 = new JMenu("Buscar");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Buscar Usuario");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					PanelBuscar dialog = new PanelBuscar(MenuUsuario.this, aplic);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_3 = new JMenu("Ajuste");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cambiar Nombre de Usuario");
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cambiar Contraseña de Usuario");
		mnNewMenu_3.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Cambiar País");
		mnNewMenu_3.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Cambiar Ocupacióm");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
		panelAnimacionCurvas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAnimacionCurvas.setInicioGradiente(new Color(4, 142, 255));
		panelAnimacionCurvas.setFinGradiente(Color.WHITE);
		panelAnimacionCurvas.setColorInicioAnimacion(new Color(55, 165, 255));
		panelAnimacionCurvas.setBackground(new Color(55, 165, 255));
		panelAnimacionCurvas.setBounds(0, 0, 856, 489);
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

		JLabel nombreU = new JLabel("");
		nombreU.setFont(new Font("Arial", Font.PLAIN, 17));
		nombreU.setHorizontalAlignment(SwingConstants.CENTER);
		nombreU.setBounds(86, 23, 140, 22);
		panelBordeOval.add(nombreU);

		JLabel OcupacionU = new JLabel("");
		OcupacionU.setHorizontalAlignment(SwingConstants.CENTER);
		OcupacionU.setFont(new Font("Arial", Font.PLAIN, 17));
		OcupacionU.setBounds(73, 46, 140, 22);
		panelBordeOval.add(OcupacionU);
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
				InfoUsuario dialog = new InfoUsuario(MenuUsuario.this,p,app,0);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

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
				MostrarAmigos dialog = new MostrarAmigos(MenuUsuario.this,app,p);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
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
				SolicitudesOpciones dialog = new SolicitudesOpciones(MenuUsuario.this,p,app);
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		lblNewLabel_1_1_1.setBounds(47, 180, 166, 14);
		panelBordeOval.add(lblNewLabel_1_1_1);

		AvatarCircular avatarCircular_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular_1_1_1_1.setBounds(10, 205, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ver Solicitudes de Amistad");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!p.getSolicitudAmistad().isEmpty()) {
					InfoUsuario dialog = new InfoUsuario(MenuUsuario.this,p,app, 1);
					dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(MenuUsuario.this, "No hay solicitudes de amistad");
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
					PanelBuscar dialog = new PanelBuscar(MenuUsuario.this, aplic);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

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

		panelBordeOval_1 = new PanelBordeOval(0);
		panelBordeOval_1.setBackground(new Color(55, 165, 255));
		panelBordeOval_1.setValorEsquinaOvalSI(60);
		panelBordeOval_1.setValorEsquinaOvalSD(60);
		panelBordeOval_1.setValorEsquinaOvalII(60);
		panelBordeOval_1.setValorEsquinaOvalID(60);
		panelBordeOval_1.setBounds(258, 34, 560, 385);
		panelAnimacionCurvas.add(panelBordeOval_1);


		BotonAnimacion btnmcnBorrar = new BotonAnimacion();
		btnmcnBorrar.setBounds(444, 330, 106, 32);
		btnmcnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBordeOval.setVisible(false);
				inic("Hola2");
				panelBordeOval.setVisible(true);
			}
		});
		panelBordeOval_1.setLayout(null);
		btnmcnBorrar.setText("Borrar");
		btnmcnBorrar.setFont(new Font("Arial", Font.PLAIN, 15));
		panelBordeOval_1.add(btnmcnBorrar);

		JLabel lblNotificaciones = new JLabel("NOTIFICACIONES");
		lblNotificaciones.setBounds(10, 11, 140, 32);
		panelBordeOval_1.add(lblNotificaciones);
		lblNotificaciones.setBackground(new Color(4, 142, 255));
		lblNotificaciones.setForeground(new Color(0, 0, 0));
		lblNotificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificaciones.setFont(new Font("Arial Narrow", Font.ITALIC, 20));


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 515, 255);
		panelBordeOval_1.add(scrollPane);

		panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel_1);
		OcupacionU.setText(" ");
	}
	public void inic(String string) {
		panelBordeOval_1.setVisible(false);
		for (int i = 1; i <= 1; i++) {
			Linea linea1= new Linea(1,1);
			JPanel panel = new JPanel();
			panel.setBackground(new Color(55, 165, 255));
			panel.add(linea1);
			panel.setBorder(new LineBorder(Color.black));
			panel.add(new JLabel(string + i));
			panel_1.add(panel);
		}
		panelBordeOval_1.setVisible(true);


	}
}
