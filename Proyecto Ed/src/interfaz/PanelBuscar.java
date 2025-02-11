package interfaz;

import javax.swing.JPanel;
import componentesVisuales.PanelBordeOval;
import logica.RedSystem;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import componentesVisuales.Linea;
import javax.swing.border.LineBorder;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import componentesVisuales.BotonAnimacion;

public class PanelBuscar extends JDialog {
	
	public PanelBuscar(MenuPrincAdmin father, RedSystem sistema) {
		super(father,true);
		setTitle("Buscar Usuario");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		setLocationRelativeTo(null);
		setBackground(new Color(30, 144, 255));
		setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*NIck del Usuario a Buscar:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 31, 193, 20);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(new Color(0, 204, 255));
		textField.setBounds(21, 56, 298, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
		btnmcnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnmcnBuscar.setText("Buscar");
		btnmcnBuscar.setBounds(343, 216, 89, 34);
		getContentPane().add(btnmcnBuscar);
		
		BotonAnimacion btnmcnAtrs = new BotonAnimacion();
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

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtCampoObligatorio;
	private JTextField textField_2;
}
