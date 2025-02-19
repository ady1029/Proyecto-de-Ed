package interfaz;

import javax.swing.JPanel;
import componentesVisuales.PanelBordeOval;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.RedSystem;
import logica.Person;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import componentesVisuales.Linea;
import javax.swing.border.LineBorder;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import logica.*;

import componentesVisuales.BotonAnimacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBuscar extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNick;
	private JTextField txtCampoObligatorio;
	private JTextField textField_2;
	private MenuPrincAdmin menup;
	private RedSystem red;
	private MenuUsuario menuU;
	
	/**
	 * @wbp.parser.constructor
	 */
	public PanelBuscar(MenuPrincAdmin father, RedSystem sistema) {
		super(father, true);
		setUndecorated(true);
		menup = father;
		red = sistema;
		setTitle("Buscar Usuario");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		setLocationRelativeTo(null);
		setBackground(new Color(30, 144, 255));
		setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*Nick del Usuario a Buscar:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 31, 193, 20);
		getContentPane().add(lblNewLabel);
		
		textFieldNick = new JTextField();
		textFieldNick.setBorder(null);
		textFieldNick.setBackground(new Color(0, 204, 255));
		textFieldNick.setBounds(21, 56, 298, 20);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupación del Usuario a Buscar: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 88, 271, 20);
		getContentPane().add(lblNewLabel_1);
		
		Linea linea = new Linea(0, 0);
		linea.setBorder(new LineBorder(Color.BLACK));
		linea.setBounds(21, 75, 260, 2);
		getContentPane().add(linea);
		
		txtCampoObligatorio = new JTextField();
		txtCampoObligatorio.setColumns(10);
		txtCampoObligatorio.setBorder(null);
		txtCampoObligatorio.setBackground(new Color(0, 204, 255));
		txtCampoObligatorio.setBounds(21, 113, 298, 20);
		getContentPane().add(txtCampoObligatorio);
		
		Linea linea_1 = new Linea(0, 0);
		linea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		linea_1.setBounds(21, 133, 260, 1);
		getContentPane().add(linea_1);
		
		JLabel lblNewLabel_2 = new JLabel("País del Usuario a Buscar");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(21, 144, 193, 20);
		getContentPane().add(lblNewLabel_2);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setBounds(341, 54, 113, 110);
		getContentPane().add(avatarCircular);
		avatarCircular.setAvatar(new ImageIcon(PanelBuscar.class.getResource("/fotos/Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg")));
		
		textField_2 = new JTextField();
		textField_2.setBounds(21, 170, 298, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 204, 255));
		
		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(0, 204, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(10, 11, 470, 218);
		getContentPane().add(panelBordeOval);
		panelBordeOval.setLayout(null);
		
		Linea linea_1_1 = new Linea(0, 0);
		linea_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		linea_1_1.setBounds(10, 180, 260, 1);
		panelBordeOval.add(linea_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 490, 300);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		BotonAnimacion btnmcnBuscar = new BotonAnimacion();
		btnmcnBuscar.setBounds(391, 246, 89, 34);
		panel.add(btnmcnBuscar);
		btnmcnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = textFieldNick.getText();
				if(!a.equalsIgnoreCase("")) {
					Vertex aux= sistema.findNick(a);
					if(aux !=null) {
						Person p = (Person)aux.getInfo();
						try{
							InfoUsuario dialog = new InfoUsuario(father, (Person)aux.getInfo(),sistema,0);
							dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
							dispose();

						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else 
						JOptionPane.showMessageDialog(PanelBuscar.this, "No se encuentra el usuario introducido");
						
				}
				else 
					JOptionPane.showMessageDialog(PanelBuscar.this, "Rellenar el campo obligatorio ");
			}
		});
		btnmcnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnmcnBuscar.setText("Buscar");
		
		BotonAnimacion btnmcnAtrs = new BotonAnimacion();
		btnmcnAtrs.setBounds(20, 246, 89, 34);
		panel.add(btnmcnAtrs);
		btnmcnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
		});
		btnmcnAtrs.setText("Atrás");
		btnmcnAtrs.setFont(new Font("Arial", Font.PLAIN, 14));
		// TODO Auto-generated constructor stub
	}

	public PanelBuscar(MenuUsuario father, RedSystem sistema) {
		super(father, true);
		red = sistema;
		setTitle("Buscar Usuario");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		setLocationRelativeTo(null);
		setBackground(new Color(30, 144, 255));
		setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*Nick del Usuario a Buscar:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 31, 193, 20);
		getContentPane().add(lblNewLabel);
		
		textFieldNick = new JTextField();
		textFieldNick.setBorder(null);
		textFieldNick.setBackground(new Color(0, 204, 255));
		textFieldNick.setBounds(21, 56, 298, 20);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupación del Usuario a Buscar: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 88, 271, 20);
		getContentPane().add(lblNewLabel_1);
		
		Linea linea = new Linea(0, 0);
		linea.setBorder(new LineBorder(Color.BLACK));
		linea.setBounds(21, 75, 260, 2);
		getContentPane().add(linea);
		
		txtCampoObligatorio = new JTextField();
		txtCampoObligatorio.setColumns(10);
		txtCampoObligatorio.setBorder(null);
		txtCampoObligatorio.setBackground(new Color(0, 204, 255));
		txtCampoObligatorio.setBounds(21, 113, 298, 20);
		getContentPane().add(txtCampoObligatorio);
		
		Linea linea_1 = new Linea(0, 0);
		linea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		linea_1.setBounds(21, 133, 260, 1);
		getContentPane().add(linea_1);
		
		JLabel lblNewLabel_2 = new JLabel("País del Usuario a Buscar");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(21, 144, 193, 20);
		getContentPane().add(lblNewLabel_2);
		
		BotonAnimacion btnmcnBuscar = new BotonAnimacion();
		btnmcnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = textFieldNick.getText();
				if(!a.equalsIgnoreCase("")) {
					Vertex aux= sistema.findNick(a);
					if(aux !=null) {
						try{
							InfoUsuario dialog = new InfoUsuario(father, (Person)aux.getInfo(),sistema,0);
							dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
							dispose();

						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else 
						JOptionPane.showMessageDialog(PanelBuscar.this, "No se encuentra el usuario introducido");
						
				}
				else 
					JOptionPane.showMessageDialog(PanelBuscar.this, "Rellenar el campo obligatorio ");
			}
		});
		btnmcnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnmcnBuscar.setText("Buscar");
		btnmcnBuscar.setBounds(343, 216, 89, 34);
		getContentPane().add(btnmcnBuscar);
		
		BotonAnimacion btnmcnAtrs = new BotonAnimacion();
		btnmcnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
		});
		btnmcnAtrs.setText("Atrás");
		btnmcnAtrs.setFont(new Font("Arial", Font.PLAIN, 14));
		btnmcnAtrs.setBounds(21, 216, 89, 34);
		getContentPane().add(btnmcnAtrs);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setBounds(341, 54, 113, 110);
		getContentPane().add(avatarCircular);
		avatarCircular.setAvatar(new ImageIcon(PanelBuscar.class.getResource("/fotos/Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg")));
		
		textField_2 = new JTextField();
		textField_2.setBounds(21, 170, 298, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 204, 255));
		
		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(0, 204, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(10, 11, 454, 196);
		getContentPane().add(panelBordeOval);
		panelBordeOval.setLayout(null);
		
		Linea linea_1_1 = new Linea(0, 0);
		linea_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		linea_1_1.setBounds(10, 180, 260, 1);
		panelBordeOval.add(linea_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 477, 261);
		getContentPane().add(panel);
		// TODO Auto-generated constructor stub
	}





	
}
