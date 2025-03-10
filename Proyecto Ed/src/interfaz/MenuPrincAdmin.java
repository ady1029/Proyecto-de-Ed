package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import componentesVisuales.AvatarCircular;
import componentesVisuales.PanelAnimacionCurvas;
import logica.LiderInvestigacion;
import logica.RedSystem;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincAdmin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmMatrizAdjacencia;
	private JMenuItem mntmListadoRelaciones;
	private JMenu mnNewMenu_3;
	private RedSystem app;
	private Login father;

	
	public MenuPrincAdmin(RedSystem sistema, Login login) {
		father= login;
		app= sistema;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 528);
		setLocationRelativeTo(null);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmListadoUsuarios = new JMenuItem("Listado de Usarios");
		mntmListadoUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MostrarListadoUsuarios dialog = new MostrarListadoUsuarios(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmListadoUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmListadoUsuarios);
		
		mnNewMenu_3 = new JMenu("Relaciones entre Usuarios ");
		mnNewMenu.add(mnNewMenu_3);
		
		mntmMatrizAdjacencia = new JMenuItem("Matriz de Adyacencia ");
		mntmMatrizAdjacencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MostrarMatrizAdjacencia dialog = new MostrarMatrizAdjacencia(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_3.add(mntmMatrizAdjacencia);
		
		mntmListadoRelaciones = new JMenuItem("Listado de Ralciones ");
		mntmListadoRelaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MostrarRelaciones dialog = new MostrarRelaciones(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_3.add(mntmListadoRelaciones);
		
		JMenuItem Exit = new JMenuItem("Cerrar Sesión");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				father.setVisible(true);
				dispose();
			}
		});
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(Exit);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Relaciones de un usuario en una estructura");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MostrarRelacionesUsuario dialog = new MostrarRelacionesUsuario(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnReportes.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Obtener Usuarios Islas");
		mnReportes.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dado un usario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					PanelBuscar dialog = new PanelBuscar(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Todos los Usuarios Islas ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MostrarUsuariosIslas dialog = new MostrarUsuariosIslas (MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Obtener Comunidades");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					MostrarComunidades dialog = new MostrarComunidades(MenuPrincAdmin.this, sistema);
						dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		mnReportes.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Obtener Usuarios Líderes de Investigación ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			MostrarLideresInvestigacion dialog = new MostrarLideresInvestigacion(MenuPrincAdmin.this, sistema);
				dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		mnReportes.add(mntmNewMenuItem_4);
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Buscar Usuario");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					PanelBuscar dialog = new PanelBuscar(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		mnBuscar.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("Ajuste");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cambiar nombre de usuario");

		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CambiarDatos dialog = new CambiarDatos(app.getAdministrador(), 0,app);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cambiar Contraseña");

		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CambiarDatos dialog = new CambiarDatos(app.getAdministrador(), 1,app);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
		panelAnimacionCurvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelAnimacionCurvas.setFinGradiente(Color.LIGHT_GRAY);
		panelAnimacionCurvas.setInicioGradiente(new Color(47, 162, 255));
		panelAnimacionCurvas.setBounds(0, 0, 737, 467);
		contentPane.add(panelAnimacionCurvas);
		panelAnimacionCurvas.setLayout(null);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(MenuPrincAdmin.class.getResource("/fotos/FotoUsuarios.png")));
		avatarCircular.setBounds(38, 33, 105, 105);
		panelAnimacionCurvas.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("Listado de Usuarios");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					MostrarListadoUsuarios dialog = new MostrarListadoUsuarios(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 149, 137, 14);
		panelAnimacionCurvas.add(lblNewLabel);
		
		AvatarCircular avatarCircular_1 = new AvatarCircular();
		avatarCircular_1.setAvatar(new ImageIcon(MenuPrincAdmin.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular_1.setBounds(38, 201, 131, 131);
		panelAnimacionCurvas.add(avatarCircular_1);
		
		JLabel lblRelacionEntreUsuarios = new JLabel("Relacion entre Usuarios");
		lblRelacionEntreUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					MostrarMatrizAdjacencia dialog = new MostrarMatrizAdjacencia(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		lblRelacionEntreUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRelacionEntreUsuarios.setForeground(Color.BLACK);
		lblRelacionEntreUsuarios.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRelacionEntreUsuarios.setBounds(38, 344, 176, 14);
		panelAnimacionCurvas.add(lblRelacionEntreUsuarios);
		
		AvatarCircular avatarCircular_2 = new AvatarCircular();
		avatarCircular_2.setAvatar(new ImageIcon(MenuPrincAdmin.class.getResource("/fotos/LogoCerrarSesion1.png")));
		avatarCircular_2.setBounds(572, 213, 131, 119);
		panelAnimacionCurvas.add(avatarCircular_2);
		
		JLabel lblCerrarSesin = new JLabel("Cerrar Sesión");
		lblCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				father.setVisible(true);
				dispose();
			}
		});
		lblCerrarSesin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesin.setForeground(Color.BLACK);
		lblCerrarSesin.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCerrarSesin.setBounds(550, 344, 162, 14);
		panelAnimacionCurvas.add(lblCerrarSesin);
		
		AvatarCircular avatarCircular_3 = new AvatarCircular();
		avatarCircular_3.setAvatar(new ImageIcon(MenuPrincAdmin.class.getResource("/fotos/195203d41f527.png")));
		avatarCircular_3.setBounds(308, 213, 131, 119);
		panelAnimacionCurvas.add(avatarCircular_3);
		
		AvatarCircular avatarCircular_3_1 = new AvatarCircular();
		avatarCircular_3_1.setAvatar(new ImageIcon(MenuPrincAdmin.class.getResource("/fotos/LogoCErrarSesion2.png")));
		avatarCircular_3_1.setBounds(572, 22, 140, 119);
		panelAnimacionCurvas.add(avatarCircular_3_1);
		
		JLabel lblAjustesDeLa = new JLabel("Ajustes de la cuenta");
		lblAjustesDeLa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					CambiarDatos dialog = new CambiarDatos(app.getAdministrador(), 1,app);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblAjustesDeLa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAjustesDeLa.setForeground(Color.BLACK);
		lblAjustesDeLa.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblAjustesDeLa.setBounds(572, 150, 137, 14);
		panelAnimacionCurvas.add(lblAjustesDeLa);
		
		JLabel lblLderesDeInvestigacin = new JLabel("Líderes de investigación");
		lblLderesDeInvestigacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					MostrarLideresInvestigacion dialog = new MostrarLideresInvestigacion(MenuPrincAdmin.this, sistema);
						dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		lblLderesDeInvestigacin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLderesDeInvestigacin.setForeground(Color.BLACK);
		lblLderesDeInvestigacin.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblLderesDeInvestigacin.setBounds(292, 345, 176, 14);
		panelAnimacionCurvas.add(lblLderesDeInvestigacin);
		
		JLabel lblmatrizDeAdyacencia = new JLabel("(Matriz de Adyacencia)");
		lblmatrizDeAdyacencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					MostrarMatrizAdjacencia dialog = new MostrarMatrizAdjacencia(MenuPrincAdmin.this, sistema);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblmatrizDeAdyacencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblmatrizDeAdyacencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblmatrizDeAdyacencia.setForeground(Color.BLACK);
		lblmatrizDeAdyacencia.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblmatrizDeAdyacencia.setBounds(34, 359, 162, 14);
		panelAnimacionCurvas.add(lblmatrizDeAdyacencia);
		
		JLabel lblcambiarClave = new JLabel("(Cambiar Clave)");
		lblcambiarClave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					CambiarDatos dialog = new CambiarDatos(app.getAdministrador(), 1,app);
					dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblcambiarClave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcambiarClave.setHorizontalAlignment(SwingConstants.CENTER);
		lblcambiarClave.setForeground(Color.BLACK);
		lblcambiarClave.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblcambiarClave.setBounds(562, 167, 150, 14);
		panelAnimacionCurvas.add(lblcambiarClave);
	}
}
