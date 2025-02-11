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
import java.awt.Font;
import componentesVisuales.Linea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import componentesVisuales.PanelBordeOval;
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

public class MenuUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Linea linea = new Linea(0, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
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
		panelBordeOval.setBounds(0, 50, 225, 323);
		panelAnimacionCurvas.add(panelBordeOval);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBackground(new Color(55, 165, 255));
		panelBordeOval.setLayout(null);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/FotoUsuarios.png")));
		avatarCircular.setBounds(10, 11, 83, 74);
		panelBordeOval.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("NIck del usuario");
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
		avatarCircular_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoAjusteCuenta.png")));
		avatarCircular_1.setBounds(10, 103, 35, 33);
		panelBordeOval.add(avatarCircular_1);
		
		JLabel lblNewLabel_1 = new JLabel("Mi Perfil");
		lblNewLabel_1.setBounds(47, 111, 145, 14);
		panelBordeOval.add(lblNewLabel_1);
		
		AvatarCircular avatarCircular_1_1 = new AvatarCircular();
		avatarCircular_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoAjusteCuenta.png")));
		avatarCircular_1_1.setBounds(10, 136, 35, 33);
		panelBordeOval.add(avatarCircular_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mis Amigos");
		lblNewLabel_1_1.setBounds(47, 145, 145, 14);
		panelBordeOval.add(lblNewLabel_1_1);
		
		AvatarCircular avatarCircular_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoAjusteCuenta.png")));
		avatarCircular_1_1_1.setBounds(10, 170, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mandar Solicitud de Amistad");
		lblNewLabel_1_1_1.setBounds(47, 180, 145, 14);
		panelBordeOval.add(lblNewLabel_1_1_1);
		
		AvatarCircular avatarCircular_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoAjusteCuenta.png")));
		avatarCircular_1_1_1_1.setBounds(10, 205, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Aceptar Solicitudes de Amistad");
		lblNewLabel_1_1_1_1.setBounds(47, 214, 166, 14);
		panelBordeOval.add(lblNewLabel_1_1_1_1);
		
		AvatarCircular avatarCircular_1_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoAjusteCuenta.png")));
		avatarCircular_1_1_1_1_1.setBounds(10, 238, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Buscar Usuario");
		lblNewLabel_1_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1_1_1_1.setBounds(47, 249, 166, 14);
		panelBordeOval.add(lblNewLabel_1_1_1_1_1);
		
		AvatarCircular avatarCircular_1_1_1_1_1_1 = new AvatarCircular();
		avatarCircular_1_1_1_1_1_1.setAvatar(new ImageIcon(MenuUsuario.class.getResource("/fotos/LogoAjusteCuenta.png")));
		avatarCircular_1_1_1_1_1_1.setBounds(10, 272, 35, 33);
		panelBordeOval.add(avatarCircular_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Cerrar Sesión");
		lblNewLabel_1_1_1_1_1_1.setBounds(47, 282, 166, 14);
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
