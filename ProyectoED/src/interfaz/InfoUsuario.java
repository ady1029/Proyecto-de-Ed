package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import componentesVisuales.PanelBordeOval;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import componentesVisuales.BotonAnimacion;

public class InfoUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InfoUsuario dialog = new InfoUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InfoUsuario() {
		setBounds(100, 100, 491, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(55, 165, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(176, 220, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(22, 11, 439, 243);
		contentPanel.add(panelBordeOval);
		panelBordeOval.setLayout(null);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(InfoUsuario.class.getResource("/fotos/Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg")));
		avatarCircular.setBounds(10, 21, 114, 106);
		panelBordeOval.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("NIck del Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 46, 199, 33);
		panelBordeOval.add(lblNewLabel);
		
		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setFont(new Font("Arial", Font.PLAIN, 24));
		lblOcupacion.setBounds(144, 79, 189, 33);
		panelBordeOval.add(lblOcupacion);
		
		JLabel lblPais = new JLabel("Pais :");
		lblPais.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPais.setBounds(10, 138, 61, 33);
		panelBordeOval.add(lblPais);
		
		JLabel lblCantidadDeTrabajos = new JLabel("Cantidad de amigos: ");
		lblCantidadDeTrabajos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCantidadDeTrabajos.setBounds(10, 168, 170, 33);
		panelBordeOval.add(lblCantidadDeTrabajos);
		
		JLabel lblCuba = new JLabel("Cuba");
		lblCuba.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCuba.setBounds(61, 138, 206, 33);
		panelBordeOval.add(lblCuba);
		
		JLabel lblPais_1 = new JLabel("0");
		lblPais_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPais_1.setBounds(190, 173, 61, 22);
		panelBordeOval.add(lblPais_1);
		
		JLabel lblCantidadDeTrabajos_1 = new JLabel("Cantidad de trabajos publicados: ");
		lblCantidadDeTrabajos_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCantidadDeTrabajos_1.setBounds(10, 199, 278, 33);
		panelBordeOval.add(lblCantidadDeTrabajos_1);
		
		JLabel lblPais_1_1 = new JLabel("0");
		lblPais_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPais_1_1.setBounds(277, 204, 61, 22);
		panelBordeOval.add(lblPais_1_1);
		
		BotonAnimacion btnmcnSiguiente = new BotonAnimacion();
		btnmcnSiguiente.setEnabled(false);
		btnmcnSiguiente.setText("Siguiente ");
		btnmcnSiguiente.setBounds(375, 275, 77, 29);
		contentPanel.add(btnmcnSiguiente);
		
		BotonAnimacion btnmcnAtras = new BotonAnimacion();
		btnmcnAtras.setText("Atrás ");
		btnmcnAtras.setBounds(22, 275, 77, 29);
		contentPanel.add(btnmcnAtras);
	}
}
