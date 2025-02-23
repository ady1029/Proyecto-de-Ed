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
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Person;
import logica.RedSystem;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import componentesVisuales.Linea;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import componentesVisuales.BotonAnimacion;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import logica.Pais;

public class CambiarDatos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private RedSystem red;
	private Linea linea_1;
	private JComboBox comboBoxPais;


	public CambiarDatos(Person p, int a, RedSystem r ) {
		red = r;
		setBounds(100, 100, 473, 351);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			JPanel panel = new JPanel();
			panel.setBackground(new Color(66, 151, 255));
			panel.setBounds(0, 0, 457, 318);
			contentPanel.add(panel);
			panel.setLayout(null);

			BotonAnimacion btnmcnRealizar = new BotonAnimacion();
			btnmcnRealizar.setBounds(323, 242, 106, 32);
			panel.add(btnmcnRealizar);
			btnmcnRealizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!textField.getText().isEmpty() || a==3) {
						if(a == 0) {
							Vertex b = red.findNick(textField.getText());
							if(b == null) {
								p.setNick(textField.getText());
								JOptionPane.showMessageDialog(CambiarDatos.this, "Cambio Realizado.");
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(CambiarDatos.this, "Nick en uso.");
								textField.setText("");
							}

						}
						if(a == 1) {
							p.setPassword(textField.getText());
							JOptionPane.showMessageDialog(CambiarDatos.this, "Cambio Realizado.");
							dispose();
						}
						if(a == 2) {
							p.setOccupation(textField.getText());
							JOptionPane.showMessageDialog(CambiarDatos.this, "Cambio Realizado.");
							dispose();
						}
						if(a == 3) {
							Pais pais = (Pais)comboBoxPais.getSelectedItem();
							p.setCountry(pais);
							JOptionPane.showMessageDialog(CambiarDatos.this, "Cambio Realizado.");
							dispose();
						}
					}
					else 
						JOptionPane.showMessageDialog(CambiarDatos.this, "El Formulario no debe estar vacío");

				}
			});
			btnmcnRealizar.setText("Realizar");
			btnmcnRealizar.setFont(new Font("Arial", Font.PLAIN, 15));

			BotonAnimacion btnmcnAtrs = new BotonAnimacion();
			btnmcnAtrs.setBounds(29, 242, 106, 32);
			panel.add(btnmcnAtrs);
			btnmcnAtrs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnmcnAtrs.setText("Atrás");
			btnmcnAtrs.setFont(new Font("Arial", Font.PLAIN, 15));

			PanelBordeOval panelBordeOval = new PanelBordeOval(0);
			panelBordeOval.setBackground(new Color(0, 128, 255));
			panelBordeOval.setValorEsquinaOvalSI(60);
			panelBordeOval.setValorEsquinaOvalSD(60);
			panelBordeOval.setValorEsquinaOvalII(60);
			panelBordeOval.setValorEsquinaOvalID(60);
			panelBordeOval.setBounds(30, 53, 399, 168);
			panel.add(panelBordeOval);
			panelBordeOval.setLayout(null);

			comboBoxPais = new JComboBox();
			comboBoxPais.setBorder(null);
			comboBoxPais.setBounds(23, 107, 210, 22);
			panelBordeOval.add(comboBoxPais);
			comboBoxPais.setBackground(new Color(73, 146, 218));

			textField = new JTextField();
			textField.setBorder(null);
			textField.setBounds(23, 107, 210, 22);
			panelBordeOval.add(textField);
			textField.setBackground(new Color(0, 128, 255));
			textField.setFont(new Font("Arial", Font.PLAIN, 15));
			textField.setColumns(10);

			JLabel us_2 = new JLabel("NUEVO");
			us_2.setBounds(23, 71, 134, 24);
			panelBordeOval.add(us_2);
			us_2.setFont(new Font("Arial Narrow", Font.PLAIN, 18));

			JLabel us_1 = new JLabel("FIJO ");
			us_1.setBounds(23, 38, 160, 22);
			panelBordeOval.add(us_1);
			us_1.setFont(new Font("Arial Narrow", Font.PLAIN, 18));

			JLabel us = new JLabel("ACTUAL");
			us.setBounds(23, 8, 134, 31);
			panelBordeOval.add(us);
			us.setFont(new Font("Arial Narrow", Font.PLAIN, 18));

			Linea linea = new Linea(0, 0);
			linea.setBorder(new LineBorder(new Color(0, 0, 0)));
			linea.setBounds(23, 58, 160, 1);
			panelBordeOval.add(linea);

			linea_1 = new Linea(0, 0);
			linea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			linea_1.setBounds(23, 130, 211, 1);
			panelBordeOval.add(linea_1);

			JLabel lblAjustesDeLa = new JLabel("Ajustes de la cuenta ");
			lblAjustesDeLa.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
			lblAjustesDeLa.setBounds(30, 11, 220, 31);
			panel.add(lblAjustesDeLa);


			if(a == 0) {
				us.setText("Usuario actual:");
				us_1.setText(p.getNick());
				us_2.setText("Nuevo Usuario: ");
				comboBoxPais.setVisible(false);
				comboBoxPais.setEnabled(false);
			}
			if(a == 1) {
				us.setText("Contraseña actual:");
				us_1.setText(p.getPassword());
				us_2.setText("Nueva contraseña: ");
				comboBoxPais.setVisible(false);
				comboBoxPais.setEnabled(false);
			}
			if(a == 2) {
				us.setText("Ocupación actual:");
				us_1.setText(p.getOccupation());
				us_2.setText("Nueva ocupación: ");
				comboBoxPais.setVisible(false);
				comboBoxPais.setEnabled(false);
			}
			if(a == 3) {
				us.setText("País actual:");
				us_1.setText(p.getCountry().name());
				us_2.setText("Nuevo país: ");
				textField.setVisible(false);
				textField.setEnabled(false);
				linea_1.setVisible(false);
				comboBoxPais.setVisible(true);
				comboBoxPais.setEnabled(true);
			}
		}
	}
}
