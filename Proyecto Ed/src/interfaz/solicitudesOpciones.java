package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import componentesVisuales.PanelAnimacionCurvas;
import java.awt.Color;
import componentesVisuales.PanelBordeOval;
import logica.Person;
import logica.RedSystem;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import componentesVisuales.Linea;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import componentesVisuales.BotonAnimacion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class solicitudesOpciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Person p;
	private MenuUsuario father;
	private RedSystem app;

	public solicitudesOpciones(MenuUsuario menuUsuario, Person a, RedSystem aplic) {
		super(menuUsuario, true);
		father = menuUsuario;
	
		p=a;
		
		app= aplic;
		setLocationRelativeTo(null);
		setBounds(100, 100, 609, 320);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
			panelAnimacionCurvas.setBounds(10, 0, 585, 283);
			panelAnimacionCurvas.setLayout(null);
			panelAnimacionCurvas.setInicioGradiente(new Color(4, 142, 255));
			panelAnimacionCurvas.setFinGradiente(Color.WHITE);
			panelAnimacionCurvas.setColorInicioAnimacion(new Color(55, 165, 255));
			panelAnimacionCurvas.setBackground(new Color(55, 165, 255));
			contentPanel.add(panelAnimacionCurvas);
			{
				JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Buscar Usuario");
				lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_1_1_1_1.setBounds(94, 166, 118, 14);
				panelAnimacionCurvas.add(lblNewLabel_1_1_1_1_1);
			}
			{
				AvatarCircular avatarCircular_1_1_1_1_1 = new AvatarCircular();
				avatarCircular_1_1_1_1_1.setBounds(96, 55, 90, 86);
				panelAnimacionCurvas.add(avatarCircular_1_1_1_1_1);
				avatarCircular_1_1_1_1_1.setAvatar(new ImageIcon(solicitudesOpciones.class.getResource("/fotos/FotoUsuarios.png")));
			}
			{
				AvatarCircular avatarCircular_1_1_1_1 = new AvatarCircular();
				avatarCircular_1_1_1_1.setBounds(331, 55, 118, 86);
				panelAnimacionCurvas.add(avatarCircular_1_1_1_1);
				avatarCircular_1_1_1_1.setAvatar(new ImageIcon(solicitudesOpciones.class.getResource("/fotos/LogoConeccionPersonas.png")));
			}
			{
				JLabel lblNewLabel_1_1_1_1 = new JLabel("Ver Usuarios Disponibles");
				lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						InfoUsuario dialog = new InfoUsuario(solicitudesOpciones.this,p,app, 2);
						dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						setVisible(false);
					}
				});
				lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_1_1_1.setBounds(310, 163, 178, 20);
				panelAnimacionCurvas.add(lblNewLabel_1_1_1_1);
			}
			
			BotonAnimacion btnmcnAtrs = new BotonAnimacion();
			btnmcnAtrs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					father.setVisible(true);
					setVisible(false);
					dispose();
				}
			});
			btnmcnAtrs.setText("Atrás");
			btnmcnAtrs.setFont(new Font("Arial", Font.PLAIN, 15));
			btnmcnAtrs.setBounds(10, 211, 106, 32);
			panelAnimacionCurvas.add(btnmcnAtrs);
		}
	}
}
