package interfaz;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import componentesVisuales.PanelBordeOval;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import logica.Pais;
import logica.RedSystem;

import javax.swing.ImageIcon;
import componentesVisuales.BotonAnimacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCuenta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreUsuario;
	private JPasswordField passwordFieldContrasenna;
	private JPasswordField passwordFieldConfirmarContrasenna;
	private JLabel lblNombreUsuario;
	private JLabel lblContrasenna;
	private JLabel lblConfirmarContrasea;
	private JComboBox comboBoxPais;
	private JLabel lblPais;
	private JLabel lblOcupacin;
	private JTextField textFieldOcupacion;
	private PanelBordeOval panel;
	private RedSystem app;
	private JLabel lblNewLabel_1;

	public CrearCuenta(RedSystem a) {
		app = a;
		setBounds(100, 100, 1282, 722);
		getContentPane().setLayout(null);
		
		panel = new PanelBordeOval(100);
		panel.setBackground(Color.WHITE);
		panel.setBounds(58, 149, 693, 301);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNombreUsuario = new JLabel("Usuario");
		lblNombreUsuario.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblNombreUsuario.setBounds(10, 21, 107, 19);
		panel.add(lblNombreUsuario);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		textFieldNombreUsuario.setColumns(10);
		textFieldNombreUsuario.setBackground(Color.WHITE);
		textFieldNombreUsuario.setBounds(10, 51, 299, 35);
		panel.add(textFieldNombreUsuario);
		
		lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblContrasenna.setBounds(10, 120, 125, 19);
		panel.add(lblContrasenna);
		
		passwordFieldContrasenna = new JPasswordField();
		passwordFieldContrasenna.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		passwordFieldContrasenna.setBackground(Color.WHITE);
		passwordFieldContrasenna.setBounds(10, 150, 298, 35);
		panel.add(passwordFieldContrasenna);
		
		passwordFieldConfirmarContrasenna = new JPasswordField();
		passwordFieldConfirmarContrasenna.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		passwordFieldConfirmarContrasenna.setBackground(Color.WHITE);
		passwordFieldConfirmarContrasenna.setBounds(10, 241, 298, 35);
		panel.add(passwordFieldConfirmarContrasenna);
		
		lblConfirmarContrasea = new JLabel("Confirmar contraseña");
		lblConfirmarContrasea.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblConfirmarContrasea.setBounds(10, 211, 173, 19);
		panel.add(lblConfirmarContrasea);
		
		lblOcupacin = new JLabel("Ocupación");
		lblOcupacin.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblOcupacin.setBounds(354, 21, 125, 19);
		panel.add(lblOcupacin);
		
		lblPais = new JLabel("País");
		lblPais.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblPais.setBounds(354, 124, 125, 19);
		panel.add(lblPais);
		
		comboBoxPais = new JComboBox();
		comboBoxPais.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		comboBoxPais.setModel(new DefaultComboBoxModel(Pais.values()));
		comboBoxPais.setBackground(Color.WHITE);
		comboBoxPais.setBounds(354, 150, 298, 35);
		panel.add(comboBoxPais);
		
		textFieldOcupacion = new JTextField();
		textFieldOcupacion.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		textFieldOcupacion.setColumns(10);
		textFieldOcupacion.setBackground(Color.WHITE);
		textFieldOcupacion.setBounds(354, 51, 299, 35);
		panel.add(textFieldOcupacion);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(351, 241, 274, 35);
		panel.add(lblNewLabel_1);
		
		BotonAnimacion btnRegistrarse = new BotonAnimacion();
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(textFieldNombreUsuario.getText().isEmpty())) {
					char [] password= passwordFieldContrasenna.getPassword();
					String clave= new String(password);
					char [] passwordC= passwordFieldConfirmarContrasenna.getPassword();
					String claveC= new String(password);
					if(!(clave.isEmpty()) && clave.equalsIgnoreCase(claveC)) {
						if(!(textFieldOcupacion.getText().isEmpty())) {
							Pais pais = (Pais)comboBoxPais.getSelectedItem();
							boolean a = app.registrarse(textFieldNombreUsuario.getText(), clave, pais,textFieldOcupacion.getText());
							if(!a) {
								lblNewLabel_1.setText("Cuenta existente. Creación fallida.");
								textFieldNombreUsuario.setText("");
								passwordFieldContrasenna.setText("");
								passwordFieldConfirmarContrasenna.setText("");
								textFieldOcupacion.setText("");
							}
							else {
								lblNewLabel_1.setForeground(new Color(0, 255, 0));
								lblNewLabel_1.setText("Creación exitosa.");
								
								
							}
						}else {
							lblNewLabel_1.setText("Rellene el campo de la ocupación.");
						}
					}else {
						lblNewLabel_1.setText("Contraseña y confirmación no coinciden.");
						passwordFieldContrasenna.setText("");
						passwordFieldConfirmarContrasenna.setText("");
					}
				}else {
					lblNewLabel_1.setText("Rellene el campo del usuario.");
				}
			}
		});
		btnRegistrarse.setText("CREAR CUENTA");
		btnRegistrarse.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 30));
		btnRegistrarse.setColorEfecto(Color.WHITE);
		btnRegistrarse.setBackground(Color.WHITE);
		btnRegistrarse.setBounds(58, 476, 217, 48);
		getContentPane().add(btnRegistrarse);
		
		BotonAnimacion btnmcnVolverAInicio = new BotonAnimacion();
		btnmcnVolverAInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login dialog = new Login();
				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dispose();
			}
		});
		btnmcnVolverAInicio.setText("SALIR");
		btnmcnVolverAInicio.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 30));
		btnmcnVolverAInicio.setColorEfecto(Color.WHITE);
		btnmcnVolverAInicio.setBackground(Color.WHITE);
		btnmcnVolverAInicio.setBounds(531, 476, 217, 48);
		getContentPane().add(btnmcnVolverAInicio);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CrearCuenta.class.getResource("/fotos/2.png")));
		lblNewLabel.setBounds(10, 0, 1266, 694);
		getContentPane().add(lblNewLabel);

	}

}
